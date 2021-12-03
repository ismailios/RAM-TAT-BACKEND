package ma.itroad.ram.tat.coref.service.service.mapper;

import org.mapstruct.*;

import ma.itroad.ram.tat.coref.service.domain.*;
import ma.itroad.ram.tat.coref.service.service.dto.StandardTaskRefDTO;

/**
 * Mapper for the entity {@link StandardTaskRef} and its DTO {@link StandardTaskRefDTO}.
 */
@Mapper(componentModel = "spring", uses = { TaskRefMapper.class })
public interface StandardTaskRefMapper extends EntityMapper<StandardTaskRefDTO, StandardTaskRef> {
    @Mapping(target = "task", source = "task", qualifiedByName = "id")
    StandardTaskRefDTO toDto(StandardTaskRef s);
}
