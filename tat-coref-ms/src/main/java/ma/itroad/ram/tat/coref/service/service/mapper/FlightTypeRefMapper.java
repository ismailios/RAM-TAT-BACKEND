package ma.itroad.ram.tat.coref.service.service.mapper;

import org.mapstruct.*;

import ma.itroad.ram.tat.coref.service.domain.*;
import ma.itroad.ram.tat.coref.service.service.dto.FlightTypeRefDTO;

/**
 * Mapper for the entity {@link FlightTypeRef} and its DTO {@link FlightTypeRefDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface FlightTypeRefMapper extends EntityMapper<FlightTypeRefDTO, FlightTypeRef> {

    @Named("id")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    FlightTypeRefDTO toDtoId(FlightTypeRef flightTypeRef);
}
