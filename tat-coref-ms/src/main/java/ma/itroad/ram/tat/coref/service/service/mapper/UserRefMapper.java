package ma.itroad.ram.tat.coref.service.service.mapper;

import java.util.Set;
import org.mapstruct.*;

import ma.itroad.ram.tat.coref.service.domain.*;
import ma.itroad.ram.tat.coref.service.service.dto.RoleRefDTO;
import ma.itroad.ram.tat.coref.service.service.dto.UserRefDTO;

/**
 * Mapper for the entity {@link RoleRef} and its DTO {@link RoleRefDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface UserRefMapper extends EntityMapper<UserRefDTO, UserRef> {
    @Named("idSet")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    Set<UserRefDTO> toDtoIdSet(Set<UserRef> userRef);
}
