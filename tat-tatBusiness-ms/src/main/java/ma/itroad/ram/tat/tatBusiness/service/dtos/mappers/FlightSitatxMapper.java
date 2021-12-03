package ma.itroad.ram.tat.tatBusiness.service.dtos.mappers;

import org.mapstruct.Mapper;

import ma.itroad.ram.tat.tatBusiness.service.domain.FlightSitatx;
import ma.itroad.ram.tat.tatBusiness.service.dto.changer.sitatx.FlightSitatxDto;

@Mapper(componentModel = "spring", uses = FlightSitatxMapper.class)
public interface FlightSitatxMapper extends EntityMapper<FlightSitatxDto, FlightSitatx> {

}
