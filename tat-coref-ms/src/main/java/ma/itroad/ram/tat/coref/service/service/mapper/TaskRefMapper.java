package ma.itroad.ram.tat.coref.service.service.mapper;

import java.util.Set;
import org.mapstruct.*;

import ma.itroad.ram.tat.coref.service.domain.*;
import ma.itroad.ram.tat.coref.service.service.dto.TaskRefDTO;

/**
 * Mapper for the entity {@link TaskRef} and its DTO {@link TaskRefDTO}.
 */
@Mapper(
    componentModel = "spring",
    uses = { FlightTypeRefMapper.class, TatTypeMapper.class, DelayReasonRefMapper.class, RoleRefMapper.class }
)
public interface TaskRefMapper extends EntityMapper<TaskRefDTO, TaskRef> {
   //@Mapping(target = "refFlightType", source = "refFlightType", qualifiedByName = "id")
    @Mapping(target = "tatTypes", source = "tatTypes", qualifiedByName = "idSet")
    @Mapping(target = "delayReasons", source = "delayReasons", qualifiedByName = "idSet")
    @Mapping(target = "roles", source = "roles", qualifiedByName = "idSet")
    TaskRefDTO toDto(TaskRef s);

    @Named("id")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    TaskRefDTO toDtoId(TaskRef taskRef);

    @Mapping(target = "removeTatType", ignore = true)
    //@Mapping(target = "removeDelayReason", ignore = true)
    @Mapping(target = "removeRole", ignore = true)
    TaskRef toEntity(TaskRefDTO taskRefDTO);
}
