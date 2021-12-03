package ma.itroad.ram.tat.tatBusiness.service.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="taskBusiness", url="${task-ms-url}")
public interface TaskProxy {

    @PostMapping(value="/generateTasks")
    void CreateTasksForTat(@RequestParam(name="tatType") String tatType,
                           @RequestParam(name="aircraftSubtype") String aircraftSubtype,
                           @RequestParam(name="legType") String legType);
}
