package ma.itroad.ram.tat.scheduler.ms.proxy;


import java.util.HashMap;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import ma.itroad.ram.tat.scheduler.ms.dto.TatInfoDto;

@FeignClient(name="task-business-ms", url= "${task-ms-url}")
public interface TaskBusinessProxy {


}
