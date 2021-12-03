package ma.itroad.ram.tat.scheduler.ms.proxy;

import java.util.HashMap;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import ma.itroad.ram.tat.scheduler.ms.dto.LoadSheet;
import ma.itroad.ram.tat.scheduler.ms.dto.OndaInfo;
import ma.itroad.ram.tat.scheduler.ms.dto.TatInfoDto;
import ma.itroad.ram.tat.scheduler.ms.service.dto.changer.onda.RootOnda;
import ma.itroad.ram.tat.scheduler.ms.service.dto.changer.onda.Vol;
import ma.itroad.ram.tat.scheduler.ms.service.dto.changer.sitatx.RootSitatx;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "business-ms", url = "${business-ms-url}")
public interface BusinessProxy {

	@GetMapping("/getTatsWithNoTasks")
	List<TatInfoDto> getTatsWithNoTasks();

	@PostMapping(value="/affectTasks")
	void postTasks(@RequestBody HashMap<TatInfoDto, List<Object>> map);

	@PostMapping(value="/TatsToActOn")
	void postTats();
	
	@PostMapping(value="/OndaInfo")
	void postOndaInfo(@RequestBody RootOnda rootOnda);

	@PostMapping(value="/LoadSheet")
	void postLoadSheet(@RequestBody List<LoadSheet> LoadSheets);
	
	@PostMapping(value="/sitatx")
	void postSitatxMessage(@RequestBody RootSitatx rootSitatx);
	
}
