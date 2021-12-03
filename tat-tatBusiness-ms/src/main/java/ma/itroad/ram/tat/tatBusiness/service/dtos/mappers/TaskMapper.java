package ma.itroad.ram.tat.tatBusiness.service.dtos.mappers;


import ma.itroad.ram.tat.tatBusiness.service.domain.Role;
import ma.itroad.ram.tat.tatBusiness.service.domain.Task;
import ma.itroad.ram.tat.tatBusiness.service.dtos.RoleRefDto;
import ma.itroad.ram.tat.tatBusiness.service.dtos.TaskDtoCoref;
import ma.itroad.ram.tat.tatBusiness.service.dtos.TaskStandardDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.HashSet;
import java.util.Set;

@Mapper(componentModel="spring",uses=RoleMapper.class)
public interface TaskMapper extends EntityMapper<TaskStandardDto, Task> {


    String expIdTask="java(dto.getTask().getIdTask())";
    String expCode="java(dto.getTask().getCode())";
    String expName="java(dto.getTask().getName())";
    String expGroupTask="java(dto.getTask().getGroupTask())";
    String expDescription="java(dto.getTask().getDescription())";
    String expTatType="java(dto.getTask().getTatType())";
    String expPhase="java(dto.getTask().getPhase())";
    String expType="java(dto.getTask().getType())";
    String expOrder="java(dto.getTask().getOrder())";
    String expRefPreviousTask="java(dto.getTask().getRefPreviousTask())";
    String expRefRelatedTask="java(dto.getTask().getRefRelatedTask())";
    String expIsActive="java(dto.getTask().isActif())";
    String expIsCritical="java(dto.getTask().isCritical())";
    String referenceDate="java(dto.getReferenceDate())";
    String roles="java(dto.getTask().getRoles())";
    String idStandardTask="java(dto.getIdStandardTask())";
    String duration="java(dto.getDuration())";
    String startDateOffset="java(dto.getStartDateOffset())";
    String endDateOffset="java(dto.getEndDateOffset())";
    String taskOrder="java(dto.getTask().getTaskOrder())";
    String refId="java(dto.getTask().getId())";
    String sharedTask="java(dto.getTask().isSharedTask())";
    String startingRoles="java(dto.getTask().getStartingRoles())";
    String finishingRoles="java(dto.getTask().getFinishingRoles())";
    String taskToFinish="java(dto.getTask().getTaskToFinish())";
    String taskToCreate="java(dto.getTask().getTaskToCreate())";
    String taskInput = "java(dto.getTask().getTaskInput())";
    //String delayReasons="java(dto.getTask().getDelayReasons())";

    @Override
    @Mapping(target="idTask",expression = expIdTask)
    @Mapping(target="idStandardTask",expression = idStandardTask)
    @Mapping(target="code",expression = expCode)
    @Mapping(target="name",expression = expName)
    @Mapping(target="groupTask",expression = expGroupTask)
    @Mapping(target = "description",expression = expDescription)
    @Mapping(target = "tatType",expression = expTatType)
    @Mapping(target="phase",expression = expPhase)
    @Mapping(target="type",expression = expType)
    @Mapping(target="order",expression = expOrder)
    @Mapping(target="refPreviousTask",expression = expRefPreviousTask)
    @Mapping(target="refRelatedTask",expression = expRefRelatedTask)
    @Mapping(target="isCritical",expression=expIsCritical)
    @Mapping(target="isActif",expression=expIsActive)
    @Mapping(target="referenceDate",expression = referenceDate)
    @Mapping(target="duration",expression = duration)
    @Mapping(target="startDateOffset",expression = startDateOffset)
    @Mapping(target="endDateOffset",expression = endDateOffset)
    @Mapping(target="taskOrder",expression = taskOrder)
    @Mapping(target = "refId",expression = refId)
    @Mapping(target="shared",expression = sharedTask)
    @Mapping(target="startingRoles",expression = startingRoles)
    @Mapping(target="finishingRoles",expression = finishingRoles)
    @Mapping(target="taskToFinish",expression = taskToFinish)
    @Mapping(target ="taskToCreate",expression = taskToCreate)
    @Mapping(target="taskInput",expression=taskInput)
    //@Mapping(target="delayReasons",expression =delayReasons )
    @Mapping(target="roles",source="task",qualifiedByName = "mapRoles")
    Task toEntity(TaskStandardDto dto);


    @Named("mapRoles")
    default Set<Role> mapRoles(TaskDtoCoref task){

        try{
            Set<Role> roles = new HashSet<>() ;
            Set<RoleRefDto> rolesDto=task.getRoles();

            for(RoleRefDto roleDto : rolesDto){
                System.out.println("role name");
                System.out.println(roleDto.getRole());
                System.out.println(roleDto);
                Role role=  new Role(roleDto.getRole());
                roles.add(role);
            }
            return roles;
        }
        catch(Exception e){
            return null;}

    }






    /**
     *
     * @Mapper(componentModel = "spring")
     * public interface FlightMapper extends EntityMapper<Flight, Flight> {
     *
     *      String exp="java(entity.generateTatId())";
     *      String exp2="java(entity.generateTatType())";
     *      String exp="java(entity.generateTatId())";
     *      String exp2="java(entity.generateTatType())";
     *
     *     @Mapping(target="fnNumber",source="fnNumber")
     *     @Mapping(target="tatId",expression = exp)
     *     @Mapping(target="tatType",expression =exp2)
     *     Flight toDto(Flight entity);
     * */
}
