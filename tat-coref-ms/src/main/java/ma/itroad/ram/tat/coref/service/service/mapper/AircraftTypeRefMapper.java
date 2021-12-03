package ma.itroad.ram.tat.coref.service.service.mapper;

import org.mapstruct.*;

import ma.itroad.ram.tat.coref.service.domain.*;
import ma.itroad.ram.tat.coref.service.service.dto.AircraftTypeRefDTO;

/**
 * Mapper for the entity {@link AircraftTypeRef} and its DTO {@link AircraftTypeRefDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface AircraftTypeRefMapper extends EntityMapper<AircraftTypeRefDTO, AircraftTypeRef> {
    @Named("id")
    @BeanMapping(ignoreByDefault = true)
	
	  @Mapping(target = "id", source = "id")
	  
	  @Mapping(target = "code", source = "code")
	  
	  @Mapping(target = "idAircraft", source = "idAircraft")
	  
	  @Mapping(target = "name", source = "name")
	  
	  @Mapping(target = "tatMaxDuration", source = "tatMaxDuration")
	  
	  @Mapping(target = "drinkingWaterTank", source = "drinkingWaterTank")
	  
	  @Mapping(target = "airCraftType", source = "airCraftType")
	 
    AircraftTypeRefDTO toDtoId(AircraftTypeRef aircraftTypeRef);
}
