package ma.itroad.ram.tat.tatBusiness.service.dtos.mappers;

import ma.itroad.ram.tat.tatBusiness.service.domain.Task;
import ma.itroad.ram.tat.tatBusiness.service.dtos.TaskFrontDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",uses = RoleMapper.class)
public interface TaskFrontMapper extends EntityMapper<TaskFrontDto, Task>{

    @Override
    Task toEntity(TaskFrontDto dto);

    @Override
    TaskFrontDto toDto(Task entity);


}
