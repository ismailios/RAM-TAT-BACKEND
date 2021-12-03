package ma.itroad.ram.tat.thirdPartyConnectors.service.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ma.itroad.ram.tat.thirdPartyConnectors.service.dto.changer.crewMember.RootCrewMemberDto;

@FeignClient(name = "crewMemeber", url = "${jepssen.crewMember.uri}")
public interface CrewMemberRepository {

	@PostMapping("/")
	public RootCrewMemberDto findCrewMember(@RequestParam(name = "AIRLINE") String airline,
			@RequestParam(name = "FLTNBR") String fltnbr, @RequestParam(name = "STARTTIME") String starttime,
			@RequestParam(name = "USER_ID") String userId);

}
