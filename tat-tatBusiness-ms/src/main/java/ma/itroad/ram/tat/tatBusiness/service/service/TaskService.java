package ma.itroad.ram.tat.tatBusiness.service.service;

import static ma.itroad.ram.tat.tatBusiness.service.domain.enums.PhaseEnum.ARRIVEE_DEPART;
import static ma.itroad.ram.tat.tatBusiness.service.domain.enums.ReferenceDateEnum.ATA;
import static ma.itroad.ram.tat.tatBusiness.service.domain.enums.ReferenceDateEnum.ETA;
import static ma.itroad.ram.tat.tatBusiness.service.domain.enums.ReferenceDateEnum.ETD;
import static ma.itroad.ram.tat.tatBusiness.service.domain.enums.StatusEnum.FINISHED;
import static ma.itroad.ram.tat.tatBusiness.service.domain.enums.StatusEnum.IN_PROGRESS;
import static ma.itroad.ram.tat.tatBusiness.service.domain.enums.StatusEnum.NON_STARTED;
import static ma.itroad.ram.tat.tatBusiness.service.domain.enums.StatusEnum.NOT_APPLICABLE;
import static ma.itroad.ram.tat.tatBusiness.service.domain.enums.StatusEnum.inProgress;
import static ma.itroad.ram.tat.tatBusiness.service.domain.enums.StatusEnum.nonStarted;
import static ma.itroad.ram.tat.tatBusiness.service.domain.enums.TaskTypeEnum.AUTOMATIC;
import static ma.itroad.ram.tat.tatBusiness.service.domain.enums.TatTypeEnum.ARR;
import static ma.itroad.ram.tat.tatBusiness.service.domain.enums.TatTypeEnum.ARRDEP;
import static ma.itroad.ram.tat.tatBusiness.service.domain.enums.TatTypeEnum.DEP;
import static ma.itroad.ram.tat.tatBusiness.service.domain.enums.UserRoleEnum.isCDB;
import static ma.itroad.ram.tat.tatBusiness.service.domain.enums.UserRoleEnum.isOPL;
import static ma.itroad.ram.tat.tatBusiness.service.domain.enums.UserRoleEnum.isSupervisor;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

//import ma.itroad.ram.tat.tatBusiness.service.proxy.TaskProxy;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import ma.itroad.ram.tat.tatBusiness.service.configuration.KeycloakProvider;
import ma.itroad.ram.tat.tatBusiness.service.domain.Flight;
import ma.itroad.ram.tat.tatBusiness.service.domain.Role;
import ma.itroad.ram.tat.tatBusiness.service.domain.Task;
import ma.itroad.ram.tat.tatBusiness.service.domain.Tat;
import ma.itroad.ram.tat.tatBusiness.service.domain.enums.PhaseEnum;
import ma.itroad.ram.tat.tatBusiness.service.domain.enums.StatusEnum;
import ma.itroad.ram.tat.tatBusiness.service.dtos.DelayReasonDto;
import ma.itroad.ram.tat.tatBusiness.service.dtos.RoleDto;
import ma.itroad.ram.tat.tatBusiness.service.dtos.TaskDtoCoref;
import ma.itroad.ram.tat.tatBusiness.service.dtos.TaskFrontDto;
import ma.itroad.ram.tat.tatBusiness.service.dtos.TaskListDto;
import ma.itroad.ram.tat.tatBusiness.service.dtos.TaskStandardDto;
import ma.itroad.ram.tat.tatBusiness.service.dtos.UserDto;
import ma.itroad.ram.tat.tatBusiness.service.dtos.mappers.TaskFrontMapper;
import ma.itroad.ram.tat.tatBusiness.service.dtos.mappers.TaskMapper;
import ma.itroad.ram.tat.tatBusiness.service.proxy.CorefProxy;
import ma.itroad.ram.tat.tatBusiness.service.repository.CrewRepository;
import ma.itroad.ram.tat.tatBusiness.service.repository.RoleRepository;
import ma.itroad.ram.tat.tatBusiness.service.repository.TaskRepository;
import ma.itroad.ram.tat.tatBusiness.service.repository.TatPredictRepository;
import ma.itroad.ram.tat.tatBusiness.service.repository.TatRepository;

@Service
public class TaskService {

    @Value("${local-airport}")
    String LOCALAIRPORT;

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    CorefProxy corefProxy;

    @Autowired
    TatService tatService;

    @Autowired
    KeycloakProvider keycloak;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    CrewRepository crewRepository;

    @Autowired
    TaskFrontMapper taskFrontMapper;

    @Autowired
    TatRepository tatRepository;

    @Autowired
    TaskMapper taskMapper;

    @Autowired
    TatPredictRepository tatPredictRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(TaskService.class);


    public void getTAsksAndStandards(String tatType, String acSubType, String legType) {

        List<TaskStandardDto> tasks= tasks = corefProxy.getTAsksAndStandards(tatType,
                acSubType,
                legType);

    }

    @Transactional
    public void assignTasksToTat(Long tatId,List<Task> tasks) {
        Tat tat=tatService.findTatById(tatId);
        int i =0;
        boolean b =false;
        for (Task task : tasks){
            i++;
            if(tat.getTatType().equals(DEP.getValue())||tat.getTatType().equals(ARR.getValue())){
                b=true;
                task.setTatId(tatId);
                task.setStatus(NON_STARTED.getValue());
                Flight flight1= tat.getFlights().iterator().next();
                if(task.referenceDate!=null){
                    if(task.referenceDate.equals(ETD.getValue()))
                    {
                        LOGGER.info("etd");
                        task.setStartDateCalculated(flight1.generateDepEstDateTime().plusMinutes(task.getStartDateOffset()));
                        task.setEndDateCalculated(flight1.generateDepEstDateTime().plusMinutes(task.getEndDateOffset()));
                    }
                    else if(task.referenceDate.equals(ETA.getValue())){
                        LOGGER.info("eta");
                        task.setStartDateCalculated(flight1.generateArrEstDateTime().plusMinutes(task.getStartDateOffset()));
                        task.setEndDateCalculated(flight1.generateArrEstDateTime().plusMinutes(task.getEndDateOffset()));

                    }
                    else if(task.referenceDate.equals(ATA.getValue()))
                    {
                        if(flight1.generateOnBlockDateTime()!=null){
                            task.setStartDateCalculated(flight1.generateOnBlockDateTime().plusMinutes(task.getStartDateOffset()));
                            task.setEndDateCalculated(flight1.generateOnBlockDateTime().plusMinutes(task.getEndDateOffset()));
                        }
                    }

                }
            }
            else if(tat.getTatType().equals(ARRDEP.getValue()) && !tat.isHasTasks()){
                b=true;
                task.setTatId(tatId);
                task.setStatus(NON_STARTED.getValue());
                Set<Flight> flights = tat.getFlights();
                Flight depFlight = new Flight();
                Flight arrFlight = new Flight();
                for(Flight flight:flights){
                    if(flight.getArrApActual().equals(LOCALAIRPORT))
                        arrFlight=flight;
                    else
                        depFlight=flight;
                }
                if(task.referenceDate!=null){
                    if(task.referenceDate.equals("ETD"))
                    {
                        //LOGGER.info("etd");
                        task.setStartDateCalculated(depFlight.generateDepEstDateTime().plusMinutes(task.getStartDateOffset()));
                        task.setEndDateCalculated(depFlight.generateDepEstDateTime().plusMinutes(task.getEndDateOffset()));
                    }
                    else if(task.referenceDate.equals("ETA")){
                        //LOGGER.info("eta");
                        task.setStartDateCalculated(arrFlight.generateArrEstDateTime().plusMinutes(task.getStartDateOffset()));
                        task.setEndDateCalculated(arrFlight.generateArrEstDateTime().plusMinutes(task.getEndDateOffset()));

                    }
                    else if(task.referenceDate.equals("ATA"))
                    {
                        if(arrFlight.generateOnBlockDateTime()!=null){
                            task.setStartDateCalculated(arrFlight.generateOnBlockDateTime().plusMinutes(task.getStartDateOffset()));
                            task.setEndDateCalculated(arrFlight.generateOnBlockDateTime().plusMinutes(task.getEndDateOffset()));
                        }

                    }

                }


            }

            if(task.getRoles()!=null){
                for (Role role :task.getRoles() ){
                    roleRepository.save(role);
                }}
            try{
            setTaskOwner(task,tatId);}
            catch(Exception e){
                LOGGER.info(task.toString());
                LOGGER.info("exception:: "+e);
            }
            taskRepository.save(task);
        }
        if(b) {
            LocalDateTime startDate =tasks.stream().map(Task::getStartDateCalculated).min(LocalDateTime::compareTo).get();
            LocalDateTime endDate=tasks.stream().map(Task::getEndDateCalculated).max(LocalDateTime::compareTo).get();
            tat.setStartDate(startDate);
            tat.setEndDate(endDate);
            tat.setDuration(ChronoUnit.MINUTES.between(startDate,endDate));
            tatRepository.save(tat);
        }


    }

    public void updateNonStartedTaskStandards(Tat tat){
        List<Task> tasks = taskRepository.findNonStartedTasksByTatId(tat.getId());
        if(tat.isArrDep()) {
            for (Task task : tasks) {
                Set<Flight> flights = tat.getFlights();
                Flight depFlight = new Flight();
                Flight arrFlight = new Flight();
                for (Flight flight : flights) {
                    if (flight.getArrApActual().equals(LOCALAIRPORT))
                        arrFlight = flight;
                    else
                        depFlight = flight;
                }
                if (task.referenceDate != null) {
                    if (task.referenceDate.equals("ETD")) {
                        //LOGGER.info("etd");
                        task.setStartDateCalculated(depFlight.generateDepEstDateTime().plusMinutes(task.getStartDateOffset()));
                        task.setEndDateCalculated(depFlight.generateDepEstDateTime().plusMinutes(task.getEndDateOffset()));
                    } else if (task.referenceDate.equals("ETA")) {
                        //LOGGER.info("eta");
                        task.setStartDateCalculated(arrFlight.generateArrEstDateTime().plusMinutes(task.getStartDateOffset()));
                        task.setEndDateCalculated(arrFlight.generateArrEstDateTime().plusMinutes(task.getEndDateOffset()));

                    } else if (task.referenceDate.equals("ATA")) {
                        if (arrFlight.generateOnBlockDateTime() != null) {
                            task.setStartDateCalculated(arrFlight.generateOnBlockDateTime().plusMinutes(task.getStartDateOffset()));
                            task.setEndDateCalculated(arrFlight.generateOnBlockDateTime().plusMinutes(task.getEndDateOffset()));
                        }

                    }
                }
            }
        }
        else{
            for(Task task: tasks) {
                Flight flight1 = tat.getFlights().iterator().next();
                if (task.referenceDate != null) {
                    if (task.referenceDate.equals("ETD")) {
                        LOGGER.info("etd");
                        task.setStartDateCalculated(flight1.generateDepEstDateTime().plusMinutes(task.getStartDateOffset()));
                        task.setEndDateCalculated(flight1.generateDepEstDateTime().plusMinutes(task.getEndDateOffset()));
                    } else if (task.referenceDate.equals("ETA")) {
                        LOGGER.info("eta");
                        task.setStartDateCalculated(flight1.generateArrEstDateTime().plusMinutes(task.getStartDateOffset()));
                        task.setEndDateCalculated(flight1.generateArrEstDateTime().plusMinutes(task.getEndDateOffset()));

                    } else if (task.referenceDate.equals("ATA")) {
                        if (flight1.generateOnBlockDateTime() != null) {
                            task.setStartDateCalculated(flight1.generateOnBlockDateTime().plusMinutes(task.getStartDateOffset()));
                            task.setEndDateCalculated(flight1.generateOnBlockDateTime().plusMinutes(task.getEndDateOffset()));
                        }
                    }
                }
            }
        }

    }
    public Task findTaskById(long taskId){
        LOGGER.info("task:::" +taskRepository.findById(taskId));
        return taskRepository.findById(taskId).get();
    }

    public void makeNotApplicable(Task task){
        LOGGER.info("start make not applicable");
        //StatusEnum statusEnum=StatusEnum.valueOf(task.getStatus());
        LOGGER.info(task.getStatus());
        if(StatusEnum.nonStarted(task.getStatus())) {
            //if(task.getStatus().equals("NON_STARTED"))
            LOGGER.info("condition ok");
            task.setNotApplicable(true);
            task.setStatus(NOT_APPLICABLE.getValue());
            taskRepository.save(task);
            try {
                updateTatDuration(task.getTatId());
            } catch (Exception e) {
                LOGGER.info("tat duration update failed , excep "+ e);
            }
        }
    }

    public void updateTaskProgress(int progress,Task task){
        if(progress<100)
        {
            task.setProgress(progress);
            taskRepository.save(task);
            Tat tat= tatRepository.findById(task.getTatId()).get();
            tat.setProgress(tatService.tatProgress(task.getTatId()));
            tatRepository.save(tat);

        }
        else if(task.getType().equals(AUTOMATIC.getValue())) // p=100 & automatique
        {
            finishTask(task,true);
        }
    }

    public boolean startTask(long taskId){
        boolean taskStarted=false;
        Task task = taskRepository.getById(taskId);
        LOGGER.info("task_found");
        LOGGER.info(task.toString());
        int duration = task.getDuration();
        List<String> startingRoles;
        try{
         startingRoles = Arrays.asList(task.getStartingRoles().split("-"));}
        catch (Exception e){
           startingRoles=null;
        }
        if(!task.isShared() || startingRoles.contains(connectedRole()))
            if(StatusEnum.nonStarted(task.getStatus())) {
            task.setStatus(IN_PROGRESS.getValue());
            Instant startInstant = Instant.now();
            LocalDateTime startDateTimeActual = LocalDateTime.ofInstant(startInstant, ZoneOffset.UTC);
            task.setStartDateActual(startDateTimeActual);
            LocalDateTime startDateCalculated=task.getStartDateCalculated();
            if(startDateCalculated.isBefore(startDateTimeActual))
            {
                long startDelay = ChronoUnit.MINUTES.between(startDateCalculated,startDateTimeActual);
                task.setStartDelay(startDelay);

            }
            int prog=5;
            updateTaskProgress(prog,task);
            //task.setProgress(prog);
            String owner=keycloak.getConnectedUser();
            String ownerRole= corefProxy.getUserInfo(owner).getRole();
            task.setStartedBy(owner);
            task.setOwner(owner);
            task.setOwnerRole(ownerRole);
            taskRepository.save(task);




            TimerTask progress25 = new TimerTask() {
                public void run() {
                    updateTaskProgress(25,task);
                }
            };
            TimerTask progress50 = new TimerTask() {
                public void run() {
                    updateTaskProgress(50,task);
                }
            };
            TimerTask progress75 = new TimerTask() {
                public void run() {
                    updateTaskProgress(75,task);
                }
            };
            TimerTask progress100 = new TimerTask() {
                public void run() {
                    updateTaskProgress(100,task);

                }
            };
            Timer timer = new Timer("Timer");
            long firstUpdate = 60000*duration/4;
            timer.schedule(progress25,firstUpdate);

            long secondUpdate = 60000*duration/2;
            timer.schedule(progress50,secondUpdate);

            long thirdUpdate =  60000*duration*3/4;
            timer.schedule(progress75,thirdUpdate);

            long lastUpdate = 60000*duration;
            timer.schedule(progress100,lastUpdate);

            taskStarted=true;
            return taskStarted;

        }
        return  taskStarted;


    }
    public void finishTask(Task task){
        finishTask(task,false);
    }
    public void finishTask(Task task, boolean automaticFinish){
        List<String> finishingRoles=null;
        try{finishingRoles = Arrays.asList(task.getFinishingRoles().split("-"));}
        catch (Exception e){

        }
        if(!task.isShared() || finishingRoles.contains(connectedRole()) || automaticFinish)
            if(inProgress(task.getStatus())){
            task.setStatus(FINISHED.getValue());
            Instant endInstant = Instant.now();
            LocalDateTime endDateTimeActual = LocalDateTime.ofInstant(endInstant, ZoneOffset.UTC);
            task.setEndDateActual(endDateTimeActual);
            task.setProgress(100);
            LocalDateTime endDateCalculated=task.getEndDateCalculated();
            long actualDuration = ChronoUnit.MINUTES.between(task.getStartDateActual(),endDateTimeActual);
            task.setExceeding(actualDuration-task.getDuration());
            if(endDateCalculated.isBefore(endDateTimeActual)) {
                long endDelay = ChronoUnit.MINUTES.between(endDateCalculated,endDateTimeActual);
                task.setEndDelay(endDelay);
            }
            if( automaticFinish)
                task.setFinishedBy("automatic");
            else {
                String owner=keycloak.getConnectedUser();
                String ownerRole= corefProxy.getUserInfo(owner).getRole();
                task.setFinishedBy(owner);
                task.setOwner(owner);
                task.setOwnerRole(ownerRole);
                  }
            taskRepository.save(task);
            if(task.getTaskToFinish()!=null){
                finishTask(taskRepository.getTatTaskByRefId(task.getTaskToFinish(),task.getTatId()),true);
            }
            Tat tat= tatRepository.findById(task.getTatId()).get();
            tat.setProgress(tatService.tatProgress(task.getTatId()));
            tatRepository.save(tat);

        }

    }

    public String connectedRole(){
        return corefProxy.getUserInfo(keycloak.getConnectedUser()).getRole();
    }
    public int empNo(){
        return Integer.parseInt(corefProxy.getUserInfo(keycloak.getConnectedUser()).getEmpno());
    }
    public void createExceptionalTask(long tatId,long taskId,String comment){
        LOGGER.info("started");
        TaskStandardDto exceptional = corefProxy.getExceptionalTask(taskId);
        LOGGER.info("task from coref");
        LOGGER.info(exceptional.toString());
        TaskDtoCoref exceptionalTask =exceptional.getTask();
        LOGGER.info(exceptionalTask.toString());
        //List<Role> roles=exceptionalTask.getRoles();
        Task task = taskMapper.toEntity(exceptional);
//        Task task = new Task( exceptional.getIdStandardTask(),  exceptionalTask.getName(),
//                    exceptionalTask.getGroupTask(), EXCEPTIONAL.getValue(), phase,
//                    exceptionalTask.getDescription(),  exceptionalTask.getIdTask(),
//         exceptional.getDuration(), exceptionalTask.getTaskOrder(),
//        "startedBy",  "owner",  "ownerRole", tatId,  "status");
        if(task.getRoles()!=null){
            for (Role role :task.getRoles() ){
                roleRepository.save(role);
            }}
        task.setStatus(NON_STARTED.getValue());
        task.setComment(comment);
        try{
        setTaskOwner(task,tatId);}
        catch (Exception e){
            LOGGER.info("exception::: "+e);
        }
        List<Task> taskList = Collections.singletonList(task);
        LOGGER.info("start assign");
        System.out.println("start assign");
        try{
        assignTasksToTat(tatId,taskList);}
        catch (Exception e){
            LOGGER.info(" assign exception"+e);
        }

        if(task.getTaskToCreate()!=null){
            createExceptionalTask(tatId,task.getTaskToCreate(),"");
        }


    }



    public List<Task> getTasksByTatId(Long tatId,String phase,String groupTask,String status) {
        return taskRepository.findByTatIdOrderByGroupTask(tatId,phase,groupTask,status);
    }

//    public HashMap<String, TaskListDtoDeprecated> getTasksByTatIdGroupByFamily(boolean groupByGroup, boolean groupByRole, Long tatId, String phase, String groupTask, String status) {
//
//        List<Task> tasks = taskRepository.findByTatIdOrderByGroupTask(tatId,phase,groupTask,status);
//        //LOGGER.info("req "+taskRepository.findByTatIdOrderByGroupTask(tatId,phase,groupTask,status).size());
//        //LOGGER.info("var "+tasks.size());
//        if(groupByGroup) {
//            HashMap<String, TaskListDtoDeprecated> hashMap = new HashMap<String, TaskListDtoDeprecated>();
//            int i = 0;
//            for (Task task : tasks) {
//                i++;
//                if (!hashMap.containsKey(task.getGroupTask())) {
//                    List<Task> list = new ArrayList<Task>();
//                    list.add(task);
//                    TaskListDtoDeprecated taskListDtoDeprecated = new TaskListDtoDeprecated(list);
//                    hashMap.put(task.getGroupTask(), taskListDtoDeprecated);
//
//                } else {
//                    hashMap.get(task.getGroupTask()).add(task);
//                }
//            }
//            hashMap.entrySet().stream().forEach(e -> {e.getValue().generateProgressAndAlerts();});
//            return hashMap;
//        }
//        else if (groupByRole) {
//            HashMap<String, TaskListDtoDeprecated> hashMap = new HashMap<String, TaskListDtoDeprecated>();
//            for (Task task : tasks) {
//                for (Role role : task.getRoles()) {
//                    String roleName= role.getName();
//                    if (roleName!=null){
//                        if(!roleName.equals("OPL")) {
//                        if (roleName.equals("CDB"))
//                            roleName = "CDB/OPL";
//                        if (!hashMap.containsKey(roleName)) {
//                            List<Task> list = new ArrayList<Task>();
//                            list.add(task);
//                            TaskListDtoDeprecated taskListDtoDeprecated = new TaskListDtoDeprecated(list);
//
//                            hashMap.put(roleName, taskListDtoDeprecated);
//                        } else {
//                            hashMap.get(roleName).add(task);
//                        }
//                    }
//                    }
//                }
//            }
//            hashMap.entrySet().stream().forEach(e -> {e.getValue().generateProgressAndAlerts();});
//            return hashMap;
//        }
//        else{
//            HashMap<String, TaskListDtoDeprecated> hashMap = new HashMap<String, TaskListDtoDeprecated>();
//            TaskListDtoDeprecated taskListDtoDeprecated =new TaskListDtoDeprecated(tasks);
//            hashMap.put("Tasks", taskListDtoDeprecated);
//            hashMap.entrySet().stream().forEach(e -> {e.getValue().generateProgressAndAlerts();});
//            return hashMap;
//
//        }
//
//
//
//    }
public HashMap<String, TaskListDto> getMyTasksByTatId(Long tatId, int userId, String userRole, String phase, String groupTask, String status) {

    //String connectedUser =keycloak.getConnectedUser();
    List<Task> tasks= taskRepository.findByTatIdAndUserRole(tatId,userRole,phase,groupTask,status,getCrewPhase(tatId,userId));

    HashMap<String, TaskListDto> hashMap = new HashMap<String, TaskListDto>();
    for (Task task : tasks) {
        TaskFrontDto taskFrontDto=taskFrontMapper.toDto(task);
        taskFrontDto.setAllowStart(allowStart(taskFrontDto,tatId));
        taskFrontDto.setAllowFinish(allowFinish(taskFrontDto,tatId));
        taskFrontDto.setDelayReasons(getDelayReasonByTaskId(taskFrontDto.getRefId()));
        if (!hashMap.containsKey(task.getGroupTask())) {
            List<TaskFrontDto> list = new ArrayList<TaskFrontDto>();
            list.add(taskFrontDto);
            TaskListDto taskListDto=new TaskListDto(list);
            hashMap.put(task.getGroupTask(), taskListDto);
        } else {
            hashMap.get(task.getGroupTask()).add(taskFrontDto);
        }
    }
    //LOGGER.info(hashMap);
    hashMap.entrySet().stream().forEach(e -> {e.getValue().generateProgressAndAlerts(false);});
    return hashMap;
}

    public HashMap<String, TaskListDto> getTasksByTatIdGroupByFamily(boolean groupByGroup, boolean groupByRole, Long tatId, String phase, String groupTask, String status,boolean taskDelay) {

        List<Task> tasks = taskRepository.findByTatIdOrderByGroupTask(tatId,phase,groupTask,status);
        String connectedRole=connectedRole();
        if(groupByGroup ) {
            HashMap<String, TaskListDto> hashMap = new HashMap<String, TaskListDto>();
            int i = 0;
            for (Task task : tasks) {
                TaskFrontDto taskDto= taskFrontMapper.toDto(task);
//                taskDto.setDelayReasons(getDelayReasonByTaskId(taskDto.getRefId()));
//                taskDto.setAllowStart(allowStart(taskDto,tatId));
//                taskDto.setAllowFinish(allowFinish(taskDto,tatId));
                taskDto.setAllowNotApplicableButton(allowNotApplicable(taskDto,tatId,connectedRole));
                i++;
                if (!hashMap.containsKey(task.getGroupTask())) {
                    List<TaskFrontDto> list = new ArrayList<TaskFrontDto>();
                    list.add(taskDto);
                    TaskListDto taskListDto = new TaskListDto(list);
                    hashMap.put(task.getGroupTask(), taskListDto);

                } else {
                    hashMap.get(task.getGroupTask()).add(taskDto);
                }
            }
            hashMap.entrySet().stream().forEach(e -> {e.getValue().generateProgressAndAlerts(taskDelay);});
            return hashMap;
        }
            else if (groupByRole) {
            HashMap<String, TaskListDto> hashMap = new HashMap<String, TaskListDto>();
            for (Task task : tasks) {
                TaskFrontDto taskDto= taskFrontMapper.toDto(task);
                taskDto.setAllowNotApplicableButton(allowNotApplicable(taskDto,tatId,connectedRole));
//                taskDto.setDelayReasons(getDelayReasonByTaskId(taskDto.getRefId()));
//                taskDto.setAllowStart(allowStart(taskDto,tatId));
//                taskDto.setAllowFinish(allowFinish(taskDto,tatId));
                for (RoleDto role : taskDto.getRoles()) {
                    String roleName= role.getName();
                    if(roleName!=null) {
                        if (!isOPL(roleName)) {
                            if (isCDB(roleName))
                                roleName = "CDB/OPL";
                            if (!hashMap.containsKey(roleName)) {
                                List<TaskFrontDto> list = new ArrayList<TaskFrontDto>();
                                list.add(taskDto);
                                TaskListDto taskListDto = new TaskListDto(list);

                                hashMap.put(roleName, taskListDto);
                            } else {
                                hashMap.get(roleName).add(taskDto);
                            }
                        }
                    }
                }
            }
            hashMap.entrySet().stream().forEach(e -> {e.getValue().generateProgressAndAlerts(taskDelay);});
            return hashMap;
        }
            else{
            HashMap<String, TaskListDto> hashMap = new HashMap<String, TaskListDto>();
            List<TaskFrontDto> taskListDtos= taskFrontMapper.toDto(tasks);
            TaskListDto taskListDto=new TaskListDto(taskListDtos);
            for(TaskFrontDto taskDto: taskListDtos){
//                taskDto.setAllowStart(allowStart(taskDto,tatId));
//                taskDto.setAllowFinish(allowFinish(taskDto,tatId));
//                taskDto.setDelayReasons(getDelayReasonByTaskId(taskDto.getRefId()));
                taskDto.setAllowNotApplicableButton(allowNotApplicable(taskDto,tatId,connectedRole));

            }
            hashMap.put("Tasks", taskListDto);
            hashMap.entrySet().stream().forEach(e -> {e.getValue().generateProgressAndAlerts(taskDelay);});
            return hashMap;

        }

    }
    public boolean allowStart(TaskFrontDto task,long tatId){
        if(!nonStarted(task.getStatus()))
            return false;
        //RoleDto role = new RoleDto(connectedRole());
        List<String> listRoles=new ArrayList<>();
        for(RoleDto roleDto : task.getRoles()){
            listRoles.add(roleDto.getName());
        }
        if(listRoles.contains(connectedRole()) && isAssignedToTat(tatId,empNo())){
            if(!task.isShared()){
                    return true;
            }
            else return(task.generateStartingRoles().contains(connectedRole()));

        }
        else return false;

    }
    public boolean allowFinish(TaskFrontDto task,long tatId){
        if(!inProgress(task.getStatus()))
            return false;
        RoleDto role = new RoleDto(connectedRole());
        if(task.getRoles().contains(role) && isAssignedToTat(tatId,empNo())){
            if(!task.isShared()){
                return true;
            }
            else return(task.generateFinishingRoles().contains(connectedRole())); //check if is role in list of finishing role
        }
        else return false;


    }
    public boolean allowNotApplicable(TaskFrontDto task,long tatId,String connectedRole){

        return (nonStarted(task.getStatus())&& isSupervisor(connectedRole)
                && isAssignedToTat(tatId,empNo()));
    }

    public boolean isManuallyAssignedToTat(long tatId,int userId){
        if (crewRepository.checkIfManuallyAssignedToTat(tatId,userId).size()!=0)
            return true;
        else return false;
    }

    public boolean isAssignedToTat(long tatId,int userId){
        if (crewRepository.checkIfAssignedToTat(tatId,userId).size()!=0)
            return true;
        else return false;
    }

    public String getCrewPhase(long tatId,int userId){
        List<String> phases=crewRepository.getCrewPhase(tatId,userId);
        Set<String> uniquePhase = new HashSet<String>(phases);
        if (uniquePhase.size()==1)
            return phases.get(0);
        else if(uniquePhase.size()>1)
            return ARRIVEE_DEPART.getValue();
        else return null;
    }
//    public HashMap<String, TaskListDtoDeprecated> getMyTasksByTatId(Long tatId, int userId, String userRole, String phase, String groupTask, String status) {
//
//        String connectedUser =keycloak.getConnectedUser();
//        //LOGGER.info("user role: "+userRole);
//        List<Task> tasks= taskRepository.findByTatIdAndUserRole(tatId,userRole,phase,groupTask,status,getCrewPhase(tatId,userId));
//
//        HashMap<String, TaskListDtoDeprecated> hashMap = new HashMap<String, TaskListDtoDeprecated>();
//        for (Task task : tasks) {
//            if (!hashMap.containsKey(task.getGroupTask())) {
//                //LOGGER.info("group task " + task.getGroupTask() + " not in map");
//                List<Task> list = new ArrayList<Task>();
//                list.add(task);
//                TaskListDtoDeprecated taskListDtoDeprecated =new TaskListDtoDeprecated(list);
//                hashMap.put(task.getGroupTask(), taskListDtoDeprecated);
//            } else {
//                hashMap.get(task.getGroupTask()).add(task);
//            }
//        }
//        //LOGGER.info(hashMap);
//        hashMap.entrySet().stream().forEach(e -> {e.getValue().generateProgressAndAlerts();});
//        return hashMap;
//    }

    public List<TaskDtoCoref> getListOfExceptionalTasks(String phase,String groupTask) {

       return  corefProxy.getListOfExceptionalTasks(phase,groupTask);
    }

    public void updateTatDuration(long tatId){
        Tat tat=tatRepository.findById(tatId).get();
        List<Task> tasks = taskRepository.findApplicableTasksByTatId(tatId);
        LOGGER.info("size "+tasks.size());
        LocalDateTime startDate =tasks.stream().map(Task::getStartDateCalculated).min(LocalDateTime::compareTo).get();
        LocalDateTime endDate=tasks.stream().map(Task::getEndDateCalculated).max(LocalDateTime::compareTo).get();
        tat.setStartDate(startDate);
        tat.setEndDate(endDate);
        tat.setDuration(ChronoUnit.MINUTES.between(startDate,endDate));
        tatRepository.save(tat);

    }

    public void setTatTasksOwners( long tatId){
        List<Task> tasks = taskRepository.findNonStartedTasksByTatId(tatId);
        tasks.forEach(task -> setTaskOwner(task,tatId));
    }

    public void setTaskOwner(Task task , long tatId){
        LOGGER.info("start task owner ");
        List<String> taskRoles=task.generateRoles();
        LOGGER.info("taskroles "+taskRoles.get(0));
        int empNo=crewRepository.getTaskOwnerEmpno(taskRoles,tatId).get(0);
        LOGGER.info("empno from crewRepo "+empNo);
        UserDto user= corefProxy.getUserByEmpNO(""+empNo);
        LOGGER.info("User "+user);
        task.setOwner(user.getFirstName()+" "+user.getLastName());
        task.setOwnerRole(user.getRole());

    }

    public List<String> getListOfPhases(long tatId) {
        String tatType= tatService.findTatById(tatId).getTatType();
        switch (tatType){
            case "Arr" :
                //create a list of one single element called Arrivée
                return Collections.singletonList(PhaseEnum.ARRIVEE.getValue());
            case "Dep":
                return Collections.singletonList(PhaseEnum.DEPART.getValue());
            default:
                return Arrays.asList(PhaseEnum.DEPART.getValue(),PhaseEnum.ARRIVEE.getValue());
        }
    }

    public List<DelayReasonDto> getDelayReasonByTaskId(Long refId) {
        LOGGER.info("start");
        try{
        List<DelayReasonDto> list= corefProxy.getDelayReasonByTaskId(refId);
        return list;}
        catch(Exception e){
            LOGGER.info("excp:::::::::::"+e);
            return  Collections.singletonList(new DelayReasonDto("default") );
        }


    }

    public void insertInputs(long taskId,
                                   String delayReason,
                                   String delayReasonPrecision,
                                   String comment,
                                   double fuelQuantity,
                                   double drinkingWater,
                                   double remainingWater,
                                   double trip,
                                   double taxi


    ) {
        Task task = taskRepository.findById(taskId).get();
        Tat tat = tatRepository.findById(task.getTatId()).get();

        if(delayReason!=null) task.setDelayReason(delayReason);
        if(delayReasonPrecision!=null) task.setDelayReasonPrecision(delayReasonPrecision);
        if(comment!=null) task.setComment(comment);
        if(trip>=0) {task.setTrip(trip);
            tat.setFuelQuantity(fuelQuantity);
            tatRepository.save(tat);}
        if(taxi>=0) {   task.setTaxi(taxi);
                        tat.setFuelQuantity(fuelQuantity);
                        tatRepository.save(tat);}
        if(fuelQuantity>=0) {   task.setFuelQuantity(fuelQuantity);
                                tat.setFuelQuantity(fuelQuantity);
                                tatRepository.save(tat);}
        if(drinkingWater>=0) {task.setDrinkingWater(drinkingWater);}
        if(remainingWater>=0) {task.setRemainingDrinkingWater(remainingWater);}

        //if(task)
        taskRepository.save(task);
        //task.set
    }
}
