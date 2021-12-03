package ma.itroad.ram.tat.coref.service.service.mapper;

import org.mapstruct.*;

import ma.itroad.ram.tat.coref.service.domain.*;
import ma.itroad.ram.tat.coref.service.service.dto.EquipmentRefDTO;

/**
 * Mapper for the entity {@link EquipmentRef} and its DTO {@link EquipmentRefDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface EquipmentRefMapper extends EntityMapper<EquipmentRefDTO, EquipmentRef> {}
