
package ma.itroad.ram.tat.tatBusiness.service.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import ma.itroad.ram.tat.tatBusiness.service.dtos.UserDto;

//coref
//@FeignClient(name="coref", url="localhost:8083")

@FeignClient(name = "new-environment2", url = "localhost:8083333")

public interface UserRoleProxy {



	/*
	 * @GetMapping(value="/api/aircraf-type-by-ac-registration/{acRegistration}")
	 * AircraftType aircraftTypeByAcRegistration(@PathVariable("acRegistration")
	 * String acRegistration);
	 */
}
