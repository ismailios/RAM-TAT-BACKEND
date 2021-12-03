package ma.itroad.ram.tat.tatBusiness.service.dtos.mappers;

import ma.itroad.ram.tat.tatBusiness.service.domain.Role;
import ma.itroad.ram.tat.tatBusiness.service.dtos.RoleDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleMapper extends EntityMapper<RoleDto, Role> {

    @Override
    Role toEntity(RoleDto dto);

    @Override
    RoleDto toDto(Role entity);
}
