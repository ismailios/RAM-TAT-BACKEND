package ma.itroad.ram.tat.tatBusiness.service.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ma.itroad.ram.tat.tatBusiness.service.dtos.changer.crewMember.RootCrewMemberDto;

@FeignClient(name = "crew-member", url = "${third-party-ms-url}")

public interface CrewProxy {

	@PostMapping(value = "/3rd-party-connectors/crewMember")
	RootCrewMemberDto getCrewMember(@RequestParam(name = "AIRLINE") String airline, @RequestParam(name = "FLTNBR") String fltnbr, @RequestParam(name = "STARTTIME") String starttime, @RequestParam(name = "USER_ID") String userId );

	/*
	 * @GetMapping(value="/api/aircraf-type-by-ac-registration/{acRegistration}")
	 * AircraftType aircraftTypeByAcRegistration(@PathVariable("acRegistration")
	 * String acRegistration);
	 */
}
