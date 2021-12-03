package ma.itroad.ram.tat.coref.service.service;

import java.util.*;

import ma.itroad.ram.tat.coref.service.domain.enumeration.*;
import ma.itroad.ram.tat.coref.service.repository.StandardTaskRefRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.itroad.ram.tat.coref.service.domain.FlightTypeRef;
import ma.itroad.ram.tat.coref.service.domain.StandardTaskRef;
import ma.itroad.ram.tat.coref.service.domain.TaskRef;
import ma.itroad.ram.tat.coref.service.repository.TaskRefRepository;
import ma.itroad.ram.tat.coref.service.service.dto.TaskRefDTO;
import ma.itroad.ram.tat.coref.service.service.mapper.TaskRefMapper;

/**
 * Service Implementation for managing {@link TaskRef}.
 */
@Service
@Transactional
public class TaskRefService {

    @Autowired
    AircraftTypeRefService aircraftTypeRefService;

    @Autowired
    FlightTypeRefService flightTypeRefService;

    @Autowired
    StandardTaskRefRepository standardTaskRefRepository;

    private final Logger log = LoggerFactory.getLogger(TaskRefService.class);

    private final TaskRefRepository taskRefRepository;

    private final TaskRefMapper taskRefMapper;

    public TaskRefService(TaskRefRepository taskRefRepository, TaskRefMapper taskRefMapper) {
        this.taskRefRepository = taskRefRepository;
        this.taskRefMapper = taskRefMapper;
    }

    /**
     * Save a taskRef.
     *
     * @param taskRefDTO the entity to save.
     * @return the persisted entity.
     */
    public TaskRefDTO save(TaskRefDTO taskRefDTO) {
        log.debug("Request to save TaskRef : {}", taskRefDTO);
        TaskRef taskRef = taskRefMapper.toEntity(taskRefDTO);
        taskRef = taskRefRepository.save(taskRef);
        return taskRefMapper.toDto(taskRef);
    }

    /**
     * Partially update a taskRef.
     *
     * @param taskRefDTO the entity to update partially.
     * @return the persisted entity.
     */
    public Optional<TaskRefDTO> partialUpdate(TaskRefDTO taskRefDTO) {
        log.debug("Request to partially update TaskRef : {}", taskRefDTO);

        return taskRefRepository
            .findById(taskRefDTO.getId())
            .map(
                existingTaskRef -> {
                    taskRefMapper.partialUpdate(existingTaskRef, taskRefDTO);

                    return existingTaskRef;
                }
            )
            .map(taskRefRepository::save)
            .map(taskRefMapper::toDto);
    }

    /**
     * Get all the taskRefs.
     *
     * @parampageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public List<TaskRef> findAll() {
        log.debug("Request to get all TaskRefs");
        return taskRefRepository.findAll();
        //.map(taskRefMapper::toDto);
    }

    /**
     * Get all the taskRefs with eager load of many-to-many relationships.
     *
     * @return the list of entities.
     */
    public Page<TaskRef> findAllWithEagerRelationships(Pageable pageable) {
        return taskRefRepository.findAllWithEagerRelationships(pageable);
        //.map(taskRefMapper::toDto);
    }

    /**
     * Get one taskRef by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<TaskRefDTO> One(Long id) {
        log.debug("Request to get TaskRef : {}", id);
        return taskRefRepository.findOneWithEagerRelationships(id).map(taskRefMapper::toDto);
    }

    /**
     * Delete the taskRef by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete TaskRef : {}", id);
        taskRefRepository.deleteById(id);
    }

    public List<StandardTaskRef> getTasksByTatFlightAircraftTypes(String tatType, String legType, String acSubtype)
    {
        long tatTypeLong;
        if(tatType.equals("Arr"))
            tatTypeLong=1;
        if(tatType.equals("Dep"))
            tatTypeLong=2;
        else tatTypeLong=3;

        //MP GP
        String s ="";
        String aircraftType= aircraftTypeRefService.getAircraftTypeBySubtype(acSubtype);

        FlightTypeEnum aircraftTypeEnum=FlightTypeEnum.valueOf(aircraftType); // it's actually AircraftType !! but the enum was called flightType instead
       /* if(aircraftType.equals("GP")) aircraftTypeEnum=FlightTypeEnum.GP;
        else if(aircraftType.equals("MP")) aircraftTypeEnum=FlightTypeEnum.MP;
        else if(aircraftType.equals("AT7")) aircraftTypeEnum=FlightTypeEnum.AT7;
        else  aircraftTypeEnum=FlightTypeEnum.MP;*/
        String tatTypeEdit ="";
        if(tatType.equals("Arr"))  tatTypeEdit="ARRIVEE";
        else if(tatType.equals("Dep")) tatTypeEdit="DEPART";
        else if(tatType.equals("ArrDep")) tatTypeEdit="ARRIVEE_DEPART";

        AirFlightTypeEnum flightTypeEnum;
        List<FlightTypeRef> flightTypes= flightTypeRefService.getFlightTypeByLegType(legType);




        List<StandardTaskRef> tasks= standardTaskRefRepository.getPrincipalTasksByTatFlightAircraft(aircraftTypeEnum,tatTypeEdit,flightTypes);

        Set<StandardTaskRef> uniquetasks = new HashSet<StandardTaskRef>(tasks);
        List<StandardTaskRef> mainList = new ArrayList<StandardTaskRef>();
        mainList.addAll(uniquetasks);
        return mainList;






    }

    public Optional<TaskRefDTO> findOne(Long id) {
        return null;
    }

    public List<TaskRef> getALlExceptionalTasks(String phase,String groupTask) {
        PhaseEnum phaseEnum = PhaseEnum.ARRIVEE_DEPART;
        GroupTaskEnum groupTaskEnum=GroupTaskEnum.ALL;
        if(phase!="")
        try
        { phaseEnum=PhaseEnum.valueOf(phase);}
        catch(Exception e){}
        if(groupTask!="")
        try
        { groupTaskEnum=GroupTaskEnum.valueOf(groupTask);}
        catch (Exception e){}
        return taskRefRepository.getAllExceptionalTasks(phaseEnum,groupTaskEnum);
    }

    public StandardTaskRef getTaskById(long taskId) {
        return standardTaskRefRepository.findByTaskId(taskId).get(0);

    }
}
