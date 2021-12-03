package ma.itroad.ram.tat.scheduler.ms.service.mapper;

import org.mapstruct.*;

import ma.itroad.ram.tat.scheduler.ms.domain.NetlineFlightMessage;
import ma.itroad.ram.tat.scheduler.ms.service.dto.NetlineFlightMessageDto;

@Mapper(componentModel = "spring", uses = {})
public interface NetlineFlightMessageMapper extends EntityMapper<NetlineFlightMessageDto, NetlineFlightMessage> {
	@Named("id")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target= "id", source = "id")
    NetlineFlightMessageDto toDtoId(NetlineFlightMessage  netlineFlightMessage);
}