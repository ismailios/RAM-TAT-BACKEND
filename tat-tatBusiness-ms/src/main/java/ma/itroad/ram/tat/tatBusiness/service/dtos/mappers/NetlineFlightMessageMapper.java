package ma.itroad.ram.tat.tatBusiness.service.dtos.mappers;

import org.mapstruct.Mapper;

import ma.itroad.ram.tat.tatBusiness.service.domain.NetlineFlightMessage;
import ma.itroad.ram.tat.tatBusiness.service.dtos.NetlineFlightMessageDto;

@Mapper(componentModel = "spring")
public interface NetlineFlightMessageMapper extends EntityMapper<NetlineFlightMessageDto, NetlineFlightMessage>{
}
