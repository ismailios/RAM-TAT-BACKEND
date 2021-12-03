package ma.itroad.ram.tat.tatBusiness.service.dtos.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import ma.itroad.ram.tat.tatBusiness.service.domain.Passenger;
import ma.itroad.ram.tat.tatBusiness.service.domain.PassengerInfo;
import ma.itroad.ram.tat.tatBusiness.service.dto.changer.passengerList.PassengerDto;
import ma.itroad.ram.tat.tatBusiness.service.dto.changer.passengerList.ReturnDto;
import ma.itroad.ram.tat.tatBusiness.service.dtos.PassengerInfoDto;

@Mapper(componentModel = "spring", uses = { PassengerInfoMapper.class, PassengerMapper.class})
public interface PassengerInfoMapper {

	


	PassengerInfoDto toEntity(PassengerInfo passengerInfo);
}
