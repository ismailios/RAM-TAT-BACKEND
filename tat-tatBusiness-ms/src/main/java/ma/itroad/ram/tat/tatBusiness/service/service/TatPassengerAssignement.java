package ma.itroad.ram.tat.tatBusiness.service.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.itroad.ram.tat.tatBusiness.service.domain.Passenger;
import ma.itroad.ram.tat.tatBusiness.service.domain.PassengerInfo;
import ma.itroad.ram.tat.tatBusiness.service.domain.Tat;
import ma.itroad.ram.tat.tatBusiness.service.dto.changer.passengerList.PassengerDto;
import ma.itroad.ram.tat.tatBusiness.service.dto.changer.passengerList.ReturnDto;
import ma.itroad.ram.tat.tatBusiness.service.dto.changer.passengerList.RootPassengerList;
import ma.itroad.ram.tat.tatBusiness.service.dtos.mappers.PassengerInfoMapper;
import ma.itroad.ram.tat.tatBusiness.service.dtos.mappers.PassengerMapper;
import ma.itroad.ram.tat.tatBusiness.service.dtos.mappers.ReturnMapper;
import ma.itroad.ram.tat.tatBusiness.service.proxy.PassengerProxy;
import ma.itroad.ram.tat.tatBusiness.service.repository.PassengerInfoRepository;

@Service
public class TatPassengerAssignement {

	@Autowired
	PassengerProxy passengerProxy;

	@Autowired
	PassengerMapper passengerMapper;
	
	@Autowired
	ReturnMapper returnMapper;

	@Autowired
	PassengerInfoRepository passengerInfoRepository;

	public void passengerAssignement(Tat tat) {

		tat.getFlights().forEach(f -> {

			String departureDate = f.getDayOfOrigin();
			String boardPoint = f.getDepApActual();
			String flightNumber = f.getFnNumber();
			String marketingCarrier = f.getFnCarrier();

			

			try {
				RootPassengerList rootPassengerList = passengerProxy.findPassengerList(boardPoint, departureDate,
						flightNumber,"1", "4", "1", "1", marketingCarrier);
				
			System.out.println(rootPassengerList.toString());
				
			Set<PassengerDto> passengerListDto = new HashSet<>();
			ReturnDto passengerInfoDto = rootPassengerList.getEnvelope().getBody().getGetFlightInfoResponse().getRetour();
            PassengerInfo passengerInfo = returnMapper.toEntity(passengerInfoDto);
			
			
			
			Set<PassengerDto> passengerDto = new HashSet<PassengerDto>();
			Set<Passenger> passengers = new HashSet<Passenger>();

			passengerDto= rootPassengerList.getEnvelope().getBody().getGetFlightInfoResponse().getRetour().getPassengerList().getPassengers();
			
	
			passengers= passengerMapper.toEntity(passengerDto);
			
			passengers.forEach(p->{
				System.out.println(p.getLastName());
				p.setPassengerInfo(passengerInfo);
				
			});
			
			
			passengerInfo.setPassengers(passengers);
		
			
			tat.setPassengerInfo(passengerInfo);
				
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("get passenger" + e);
			}
	
			
			


			

		});
	
	}
}
