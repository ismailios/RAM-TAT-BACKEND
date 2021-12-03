package ma.itroad.ram.tat.coref.service.service.mapper;

import org.mapstruct.*;

import ma.itroad.ram.tat.coref.service.domain.*;
import ma.itroad.ram.tat.coref.service.service.dto.TaskCategoryRefDTO;

/**
 * Mapper for the entity {@link TaskCategoryRef} and its DTO {@link TaskCategoryRefDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface TaskCategoryRefMapper extends EntityMapper<TaskCategoryRefDTO, TaskCategoryRef> {}
