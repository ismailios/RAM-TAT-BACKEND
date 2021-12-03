package ma.itroad.ram.tat.coref.service.service.mapper;

import org.mapstruct.*;

import ma.itroad.ram.tat.coref.service.domain.*;
import ma.itroad.ram.tat.coref.service.service.dto.ResourceRefDTO;

/**
 * Mapper for the entity {@link ResourceRef} and its DTO {@link ResourceRefDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface ResourceRefMapper extends EntityMapper<ResourceRefDTO, ResourceRef> {}
