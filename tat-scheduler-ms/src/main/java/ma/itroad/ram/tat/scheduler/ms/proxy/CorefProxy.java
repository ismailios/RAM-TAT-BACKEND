package ma.itroad.ram.tat.scheduler.ms.proxy;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name="coref", url= "${coref-ms-url}")
public interface CorefProxy {

    @GetMapping("/api/task/byTatAndAircraftAndFlightTypes")
    List<Object> getTAsksAndStandards(@RequestParam("tatType") String tatType,
                                      @RequestParam("aircraftSubType")String acSubType,
                                      @RequestParam("legType") String legType);
}
