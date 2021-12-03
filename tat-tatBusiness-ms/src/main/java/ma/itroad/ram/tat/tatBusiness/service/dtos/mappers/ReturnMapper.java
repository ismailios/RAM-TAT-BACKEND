package ma.itroad.ram.tat.tatBusiness.service.dtos.mappers;

import java.util.Set;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import ma.itroad.ram.tat.tatBusiness.service.domain.Passenger;
import ma.itroad.ram.tat.tatBusiness.service.domain.PassengerInfo;
import ma.itroad.ram.tat.tatBusiness.service.dto.changer.passengerList.PassengerDto;
import ma.itroad.ram.tat.tatBusiness.service.dto.changer.passengerList.ReturnDto;

@Mapper(componentModel = "spring", uses = ReturnMapper.class)
public interface ReturnMapper {

	
	@Mapping(expression = "java( source.getSpclWchDetail()==null ? null : source.getSpclWchDetail().toString() )", target = "spclWchDetail")
	@Mapping(expression = "java( source.getSpclKidDetail()==null ? null : source.getSpclKidDetail().toString() )", target = "spclKidDetail")
	@Mapping(expression = "java( source.getSpclCreDetail()==null ? null : source.getSpclCreDetail().toString() )", target = "spclCreDetail")
	PassengerInfo toEntity(ReturnDto source);
	

}
