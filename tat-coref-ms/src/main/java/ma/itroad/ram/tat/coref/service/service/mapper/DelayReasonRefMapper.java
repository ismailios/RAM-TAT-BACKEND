package ma.itroad.ram.tat.coref.service.service.mapper;

import java.util.Set;
import org.mapstruct.*;

import ma.itroad.ram.tat.coref.service.domain.*;
import ma.itroad.ram.tat.coref.service.service.dto.DelayReasonRefDTO;

/**
 * Mapper for the entity {@link DelayReasonRef} and its DTO {@link DelayReasonRefDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface DelayReasonRefMapper extends EntityMapper<DelayReasonRefDTO, DelayReasonRef> {
    @Named("idSet")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    Set<DelayReasonRefDTO> toDtoIdSet(Set<DelayReasonRef> delayReasonRef);
}
