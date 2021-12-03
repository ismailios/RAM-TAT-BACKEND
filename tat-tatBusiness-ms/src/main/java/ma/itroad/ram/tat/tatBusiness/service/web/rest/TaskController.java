package ma.itroad.ram.tat.tatBusiness.service.web.rest;


import ma.itroad.ram.tat.tatBusiness.service.configuration.KeycloakProvider;
import ma.itroad.ram.tat.tatBusiness.service.domain.Task;

import ma.itroad.ram.tat.tatBusiness.service.dtos.*;
import ma.itroad.ram.tat.tatBusiness.service.dtos.mappers.TaskMapper;
import ma.itroad.ram.tat.tatBusiness.service.proxy.CorefProxy;
import ma.itroad.ram.tat.tatBusiness.service.repository.TatPredictRepository;
import ma.itroad.ram.tat.tatBusiness.service.service.TaskService;
import ma.itroad.ram.tat.tatBusiness.service.service.TatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

//@Api(tags="Task controller ")
@RestController
@RequestMapping("/tatBusiness")
public class TaskController {

    @Autowired
    CorefProxy corefProxy;

    @Autowired
    TaskMapper taskMapper;

    @Autowired
    TaskService taskService;

    @Autowired
    TatService tatService;

    @Autowired
    KeycloakProvider keycloak;

    @Autowired
    TatPredictRepository tatPredictRepository;

    @PostMapping("/TatsToActOn")
    public void postTatsToActOn(){
        System.out.println("started op");
        List<TatInfoDto> tatDtos = tatService.getTatsWithNoTasks();
        System.out.println("success tat-info "+tatDtos.size());
        System.out.println("method 2 called");
        int i=0;
        System.out.println("number of tats: "+tatDtos.size());
        for(TatInfoDto tatDto : tatDtos){
            System.out.println("new line : "+i);
            System.out.println("--- tat-Id: "+tatDto.getId()+" --- tat-type: "+tatDto.getTatType()+" --- ac-subtype: "+tatDto.getAcSubType()+" --legtype: "+tatDto.getLegType());
            i++;
            System.out.println(tatDto);
            try {
                List<TaskStandardDto> taskDtos = corefProxy.getTAsksAndStandards(
                        tatDto.getTatType(),
                        tatDto.getAcSubType(),
                        tatDto.getLegType());
                System.out.println("started mapping");
                System.out.println("TASKS FROM COREF");
                System.out.println(taskDtos.get(0).getTask().getRoles());
                System.out.println("");
                List<Task> tasks = new ArrayList<>();
                for(TaskStandardDto taskDto2 : taskDtos){
                   tasks.add(taskMapper.toEntity(taskDto2));
                }

                System.out.println("ended mapping");
                System.out.println("started affect");
                taskService.assignTasksToTat(tatDto.getId(),
                      //  tatDto.getTatType(),
                       // tatDto.getAcSubType(),
                        //tatDto.getLegType(),
                        tasks);
                System.out.println("ended affect");
                System.out.println(tatDto.toString());
                System.out.println("line number "+i);
                System.out.println("tasks for tat : " + tatDto.getId());
                try{
                    tatService.enableHasTasks(tatDto.getId());
                }
                catch(Exception e){
                    System.out.println("failed at updating tat status , exception: "+ e);
                }
                System.out.println(tasks.toString());
            }
            catch (Exception e){
                System.out.println("failed loading tasks for tat id : "+tatDto.getId() +"Exception: "+e);
            }



        }
        System.out.println("dto");

    }
    @GetMapping("/TasksByTatId")
    ResponseEntity<?> getTasksByTatId(@RequestParam("tatId") Long tatId,
                               @RequestParam(value = "phase",required = false,defaultValue = "") String phase,
                               @RequestParam(value = "groupTask",required = false,defaultValue = "") String groupTask,
                               @RequestParam(value = "status",required = false,defaultValue = "") String status) {
        if (phase.equals("")) phase = null;
        if (groupTask.equals("")) groupTask = null;
        if (status.equals("")) status = null;

            int userId;
            String userRole = "";
            String connectedUser =keycloak.getConnectedUser();

            System.out.println("user"+ connectedUser);

            System.out.println("connected user: "+ connectedUser);
            try{

            UserDto user = corefProxy.getUserInfo(connectedUser);
//                System.out.println("user from coref: " + user.toString());
//                System.out.println(user.toString());
//                System.out.println("empno : "+user.getEmpno());
                userId = Integer.parseInt(user.getEmpno());
//                System.out.println("user id "+userId);
//                System.out.println();
                userRole = user.getRole();
            }
            catch (Exception e) {
                return new ResponseEntity<>(
                        "failed loading user from coref, exception : "+e, HttpStatus.NOT_FOUND);
            }
            //if(taskService.isAssignedToTat(tatId,userId))
                 return new ResponseEntity<>(taskService.getTasksByTatId(tatId, phase, groupTask, status), HttpStatus.OK);
            //else
            //    return new ResponseEntity<>(
            //            "you're not assigned to this tat or tat doesn't exist ", HttpStatus.FORBIDDEN);


    }

//    @GetMapping("/teamTasks2")
//    public HashMap<String, TaskListDtoDeprecated> getTasksByTatIdGroupByFamily(@RequestParam("tatId") Long tatId,
//                                                                               @RequestParam(value = "phase",required = false,defaultValue = "") String phase,
//                                                                               @RequestParam(value = "groupTask",required = false,defaultValue = "") String groupTask,
//                                                                               @RequestParam(value = "status",required = false,defaultValue = "") String status,
//                                                                               @RequestParam(value = "groupByGroupTask",required = false,defaultValue = "false") boolean groupByGroupTask,
//                                                                               @RequestParam(value = "groupByRole",required = false,defaultValue = "false") boolean groupByRole){
//        if(phase.equals(""))phase=null;
//        if(groupTask.equals("")) groupTask=null;
//        if(status.equals(""))status=null;
//        return taskService.getTasksByTatIdGroupByFamily(groupByGroupTask,groupByRole,tatId, phase, groupTask, status);
//
//    }
    @GetMapping("/teamTasks")
    public HashMap<String, TaskListDto> getTasksByTatIdGroupByFamily(@RequestParam("tatId") Long tatId,
                                                                      @RequestParam(value = "phase",required = false,defaultValue = "") String phase,
                                                                      @RequestParam(value = "groupTask",required = false,defaultValue = "") String groupTask,
                                                                      @RequestParam(value = "status",required = false,defaultValue = "") String status,
                                                                     @RequestParam(value = "taskDelay",required = false,defaultValue = "false") boolean taskDelay,
                                                                      @RequestParam(value = "groupByGroupTask",required = false,defaultValue = "false") boolean groupByGroupTask,
                                                                      @RequestParam(value = "groupByRole",required = false,defaultValue = "false") boolean groupByRole){
        if(phase.equals(""))phase=null;
        if(groupTask.equals("")) groupTask=null;
        if(status.equals(""))status=null;
        return taskService.getTasksByTatIdGroupByFamily(groupByGroupTask,groupByRole,tatId, phase, groupTask, status,taskDelay);

    }


    @PostMapping("/startTask")
    public ResponseEntity<String> startTask(@RequestParam("taskId") long taskId){
        boolean b =taskService.startTask(taskId);
        if(b)
            return new ResponseEntity<>(
                    "task started ", HttpStatus.CREATED);
        else
            return new ResponseEntity<>(
                    "task not started  ", HttpStatus.NOT_ACCEPTABLE);

    }

    @PostMapping("/finishTask")
    public void finishTask(@RequestParam("taskId") long taskId){
        Task task = taskService.findTaskById(taskId);
        taskService.finishTask(task);
    }



//    @GetMapping("/myTasks2")
//    public ResponseEntity<?> myTasks(@RequestParam("tatId") long tatId,
//                                     @RequestParam(value = "phase",required = false,defaultValue = "") String phase,
//                                     @RequestParam(value = "groupTask",required = false,defaultValue = "") String groupTask,
//                                     @RequestParam(value = "status",required = false,defaultValue = "") String status){
//
//        if(phase.equals(""))phase=null;
//        if(groupTask.equals("")) groupTask=null;
//        if(status.equals(""))status=null;
//            //long l =2556;
//        String connectedUser =keycloak.getConnectedUser();
//        int userId;
//        String userRole="";
//        try{
//            UserDto user ;
//            try{user = corefProxy.getUserInfo(connectedUser);}
//            catch (Exception e)
//            {return new ResponseEntity<>("failed loading user from coref, exception : "+e, HttpStatus.NOT_FOUND);}
//            System.out.println("user from coref: "+user.toString());
//            System.out.println(user.toString());
//            userId=Integer.parseInt(user.getEmpno());
//            userRole =user.getRole();
//            if(taskService.isAssignedToTat(tatId,userId))
//                return new ResponseEntity<>(
//                        taskService.getMyTasksByTatId(tatId,userId,userRole,phase,groupTask,status),HttpStatus.OK);
//
//            else
//                return new ResponseEntity<>(
//                        "you're not assigned to this tat or tat doesn't exist ", HttpStatus.FORBIDDEN);
//        }
//        catch(Exception e){
//            return new ResponseEntity<>(
//                    "failed operation, exception : "+e, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//
//    }

    @PutMapping("/insertCommentOrDelayReasons/")
    public ResponseEntity<String> insertDelayReasons(@RequestParam("taskId") long taskId,
                                                     @RequestParam(value = "delayReason",required = false,defaultValue = "") String delayReason,
                                                     @RequestParam(value = "delayReasonPrecision",required = false,defaultValue = "") String delayReasonPrecision,
                                                     @RequestParam(value = "comment",required = false,defaultValue = "") String comment,
                                                     @RequestParam(value = "remainingWaterInBoard",required = false,defaultValue = "-1") double remainingWaterInBoard,
                                                     @RequestParam(value = "trip",required = false,defaultValue = "-1") double trip,
                                                     @RequestParam(value = "taxi",required = false,defaultValue = "-1") double taxi,
                                                     @RequestParam(value = "fuelQuantity",required = false,defaultValue = "--1") double fuelQuantity,
                                                     @RequestParam(value = "waterInBoard",required = false,defaultValue = "-1") double waterInBoard


    )
        {

        comment = comment == "" ? null : comment;
        delayReasonPrecision = delayReasonPrecision==""?null: delayReasonPrecision;
        delayReason = delayReason==""?null: delayReason;



        try {

            taskService.insertInputs(taskId, delayReason,delayReasonPrecision,comment,fuelQuantity,waterInBoard,remainingWaterInBoard,trip,taxi);
            return new ResponseEntity<>("inserted", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("failed", HttpStatus.NOT_MODIFIED);
        }
    }

    @GetMapping("/getDelayReasons")
    public List<DelayReasonDto> getDelayReasons(@RequestParam("refId") long refId)
    {
        return taskService.getDelayReasonByTaskId(refId);
    }






    @PutMapping("/makeNotApplicable")
    public ResponseEntity<String> makeNotApplicable(@RequestParam("taskId") long taskId){
        try {
            Task task = taskService.findTaskById(taskId);
            taskService.makeNotApplicable(task);
            return new ResponseEntity<>(
                    "not applicable ok ", HttpStatus.OK);
        }
        catch (Exception e){
            System.out.println("excep::: "+e);
            return new ResponseEntity<>(
                    "Failed, exception: "+e, HttpStatus.NOT_MODIFIED);
        }
    }

    @GetMapping("/myTasks")
    public ResponseEntity<?> myTasks(@RequestParam("tatId") long tatId,
                                     @RequestParam(value = "phase",required = false,defaultValue = "") String phase,
                                     @RequestParam(value = "groupTask",required = false,defaultValue = "") String groupTask,
                                     @RequestParam(value = "status",required = false,defaultValue = "") String status){

        if(phase.equals(""))phase=null;
        if(groupTask.equals("")) groupTask=null;
        if(status.equals(""))status=null;
        //long l =2556;
        String connectedUser =keycloak.getConnectedUser();
        int userId;
        String userRole="";
        try{
            UserDto user = corefProxy.getUserInfo(connectedUser);
            System.out.println("user from coref: "+user.toString());
            System.out.println(user.toString());
            userId=Integer.parseInt(user.getEmpno());
            userRole =user.getRole();
            if(taskService.isAssignedToTat(tatId,userId))
                return new ResponseEntity<>(
                        taskService.getMyTasksByTatId(tatId,userId,userRole,phase,groupTask,status),HttpStatus.OK);

            else
                return new ResponseEntity<>(
                        "you're not assigned to this tat or tat doesn't exist ", HttpStatus.FORBIDDEN);
        }
        catch(Exception e){
            return new ResponseEntity<>(
                    "failed loading user from coref, exception : "+e, HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/exceptionalTasks")
    public List<TaskDtoCoref> getListOfExceptionalTasks(@RequestParam(value = "phase",required = false,defaultValue = "") String phase,
                                                        @RequestParam(value = "groupTask",required = false,defaultValue = "") String groupTask){

        return taskService.getListOfExceptionalTasks(phase,groupTask);
    }


    @GetMapping("/listOfPhases")
    public List<String> getListOfPhases(@RequestParam("tatId") long tatId){

        return taskService.getListOfPhases(tatId);
    }




    @PostMapping("/addNewExceptionalTask")
    public void createNewExceptionalTask(@RequestParam("tatId")long tatId,
                                         @RequestParam("taskId")long[] taskIds,
                                         @RequestParam(value = "comment",required = false,defaultValue = "")String comment){
        for(long taskId : taskIds)
        {taskService.createExceptionalTask(tatId,taskId,comment);}
    }




}

