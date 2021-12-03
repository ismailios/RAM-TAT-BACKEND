package ma.itroad.ram.tat.coref.service.service.mapper;

import org.mapstruct.*;

import ma.itroad.ram.tat.coref.service.domain.*;
import ma.itroad.ram.tat.coref.service.service.dto.AirPortRefDTO;

/**
 * Mapper for the entity {@link AirPortRef} and its DTO {@link AirPortRefDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface AirPortRefMapper extends EntityMapper<AirPortRefDTO, AirPortRef> {}
