package ma.itroad.ram.tat.coref.service.service.mapper;

import org.mapstruct.*;
import org.springframework.context.annotation.Configuration;

import ma.itroad.ram.tat.coref.service.domain.*;
import ma.itroad.ram.tat.coref.service.service.dto.AirLineRefDTO;

/**
 * Mapper for the entity {@link AirLineRef} and its DTO {@link AirLineRefDTO}.
 */

@Mapper(componentModel = "spring", uses = {})
public interface AirLineRefMapper extends EntityMapper<AirLineRefDTO, AirLineRef> {}
