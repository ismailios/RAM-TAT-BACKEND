package ma.itroad.ram.tat.thirdPartyConnectors.service.proxy;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import ma.itroad.ram.tat.thirdPartyConnectors.service.dto.changer.loadSheet.LoadSheet;

@FeignClient(name = "loadSheetInfo", url = "${loadsheet.info.uri}")
public interface LoadSheetRepository {

	@GetMapping("/")
	List<LoadSheet> findSome();
	
}
