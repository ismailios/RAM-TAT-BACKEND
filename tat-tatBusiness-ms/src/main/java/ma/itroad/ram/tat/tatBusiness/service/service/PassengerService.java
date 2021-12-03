package ma.itroad.ram.tat.tatBusiness.service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import ma.itroad.ram.tat.tatBusiness.service.domain.Passenger;
import ma.itroad.ram.tat.tatBusiness.service.dto.changer.passengerList.PassengerDto;
import ma.itroad.ram.tat.tatBusiness.service.dtos.mappers.PassengerMapper;
import ma.itroad.ram.tat.tatBusiness.service.repository.PassengerRepository;

@Service
public class PassengerService {

	@Autowired
	PassengerRepository passengerRepository;
	
	@Autowired
	PassengerMapper PassengerMapper;
	
	
	public List<PassengerDto>  passengerFilter(Long id, String firstName, String lastName, String type, String classe, String seat, String specialReq, String status)
{
		List<Passenger> passengers =passengerRepository.passengerFilter(id, firstName, lastName, type, classe, seat, specialReq, status);
		List<PassengerDto> passengersDto = PassengerMapper.toDto(passengers);
		
    return passengersDto;


}
}
