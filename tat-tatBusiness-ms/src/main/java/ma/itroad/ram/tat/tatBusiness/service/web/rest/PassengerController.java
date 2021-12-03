package ma.itroad.ram.tat.tatBusiness.service.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ma.itroad.ram.tat.tatBusiness.service.dto.changer.passengerList.PassengerDto;
import ma.itroad.ram.tat.tatBusiness.service.service.PassengerService;

@RestController
@RequestMapping("/tatBusiness")
public class PassengerController {

	@Autowired
	PassengerService passengerService;
	
	@GetMapping("/passengers")
	public List<PassengerDto> passengerFilter(@RequestParam(name ="id") Long id,
			@RequestParam(name ="firstName") String firstName,
			@RequestParam(name ="lastName") String lastName,
			@RequestParam(name ="type") String type,
			@RequestParam(name ="classe") String classe,
			@RequestParam(name ="seat") String seat,
			@RequestParam(name ="specialReq") String specialReq,
			@RequestParam(name ="status") String status )
	
	{
	
		return passengerService.passengerFilter(id, firstName, lastName, type, classe, seat, specialReq, status);
		
	}
	
}
