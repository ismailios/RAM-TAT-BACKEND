package ma.itroad.ram.tat.tatBusiness.service.dtos.mappers;

import java.util.List;
import java.util.Set;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import ma.itroad.ram.tat.tatBusiness.service.domain.Passenger;
import ma.itroad.ram.tat.tatBusiness.service.dto.changer.passengerList.PassengerDto;

@Mapper(componentModel = "spring", uses = PassengerMapper.class)
public interface PassengerMapper {

	@Mapping(expression="java(dto.getSpecialReq()==null ? null : dto.getSpecialReq().toString())", target="specialReq")
	Set<Passenger> toEntity(Set<PassengerDto> dto);
	
	@Mapping(expression="java(dto.getSpecialReq()==null ? null : dto.getSpecialReq().toString())", target="specialReq")
	Passenger toEntity(PassengerDto dto);
	
	PassengerDto toDto(Passenger entity);
	
	List<PassengerDto> toDto(List<Passenger> entity);
}
