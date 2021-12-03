package ma.itroad.ram.tat.coref.service.service.mapper;

import java.util.Set;
import org.mapstruct.*;

import ma.itroad.ram.tat.coref.service.domain.*;
import ma.itroad.ram.tat.coref.service.service.dto.TatTypeDTO;

/**
 * Mapper for the entity {@link TatType} and its DTO {@link TatTypeDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface TatTypeMapper extends EntityMapper<TatTypeDTO, TatType> {
    @Named("idSet")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    Set<TatTypeDTO> toDtoIdSet(Set<TatType> tatType);
}
