package ma.itroad.ram.tat.coref.service.service.mapper;

import org.mapstruct.*;

import ma.itroad.ram.tat.coref.service.domain.*;
import ma.itroad.ram.tat.coref.service.service.dto.AircraftRefDTO;

/**
 * Mapper for the entity {@link AircraftRef} and its DTO {@link AircraftRefDTO}.
 */
@Mapper(componentModel = "spring", uses = { AircraftTypeRefMapper.class })
public interface AircraftRefMapper extends EntityMapper<AircraftRefDTO, AircraftRef> {
    @Mapping(target = "aircraftTypeRef", source = "aircraftTypeRef", qualifiedByName = "id")
    AircraftRefDTO toDto(AircraftRef s);
}
