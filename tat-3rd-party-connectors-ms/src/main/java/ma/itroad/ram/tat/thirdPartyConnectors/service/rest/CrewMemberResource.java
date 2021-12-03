package ma.itroad.ram.tat.thirdPartyConnectors.service.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ma.itroad.ram.tat.thirdPartyConnectors.service.dto.changer.crewMember.RootCrewMemberDto;
import ma.itroad.ram.tat.thirdPartyConnectors.service.proxy.CrewMemberRepository;


@RestController
@RequestMapping("/3rd-party-connectors")
public class CrewMemberResource {

	@Autowired
	CrewMemberRepository crewMemberRepository;

	
	@PostMapping("/crewMember")
	public RootCrewMemberDto getCrewMember(@RequestParam(name = "AIRLINE") String airline, @RequestParam(name = "FLTNBR") String fltnbr, @RequestParam(name = "STARTTIME") String starttime, @RequestParam(name = "USER_ID") String userId ) {
		System.out.println("get from 3rd party");
		return crewMemberRepository.findCrewMember(airline, fltnbr, starttime, userId);
	}
}
