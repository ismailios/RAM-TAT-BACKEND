package ma.itroad.ram.tat.tatBusiness.service.proxy;


import java.util.List;
import java.util.Optional;

import javax.validation.constraints.NotEmpty;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import ma.itroad.ram.tat.tatBusiness.service.dtos.AirPortDto;
import ma.itroad.ram.tat.tatBusiness.service.dtos.AircraftTypeDto;
import ma.itroad.ram.tat.tatBusiness.service.dtos.DelayReasonDto;
import ma.itroad.ram.tat.tatBusiness.service.dtos.EquipmentDto;
import ma.itroad.ram.tat.tatBusiness.service.dtos.NetlineFlightMessageDto;
import ma.itroad.ram.tat.tatBusiness.service.dtos.ResourceDto;
import ma.itroad.ram.tat.tatBusiness.service.dtos.TaskDtoCoref;
import ma.itroad.ram.tat.tatBusiness.service.dtos.TaskStandardDto;
import ma.itroad.ram.tat.tatBusiness.service.dtos.UserDto;

//local moccker
//@FeignClient(name="new-environment", url="localhost:3002")

//an online mocker but it only allows 100 requests per day
//@FeignClient(name="new-environment", url="https://ypglpoyvzq.api.quickmocker.com")

//coref ms

@FeignClient(name="coref", url="${coref-ms-url}")
public interface CorefProxy {

    @GetMapping(value = "/test")
    List<NetlineFlightMessageDto> listeDesVols();

    @GetMapping(value="/test/{id}")
    NetlineFlightMessageDto getFlightById(@PathVariable @NotEmpty long id);

    @GetMapping(value="/api/aircraft-refs/code/{acRegistration}")
   AircraftTypeDto aircraftTypeByAcRegistration(@PathVariable("acRegistration") String acRegistration);

    @GetMapping(value="/api/tatMaxBySubType/{subType}")
    long tatMaxBySubType(@PathVariable("subType") String subType);

    @GetMapping(value="/api/getTatMax")
    String tatMaxByAcRegistration(@PathVariable("acRegistration")String acRegistration);

    @GetMapping("/api/task/byTatAndAircraftAndFlightTypes")
    List<TaskStandardDto> getTAsksAndStandards(@RequestParam("tatType") String tatType,
                                               @RequestParam("aircraftSubType") String acSubType, @RequestParam("legType") String legType);

    @GetMapping("/api/task/getExceptionalTask")
    TaskStandardDto getExceptionalTask(@RequestParam("taskId") long taskId);
//    @GetMapping("/api/getRoleByUsername")
//    String getRoleByUsername(String connectedUser);

    @GetMapping(value = "/api/user-refs/username/{username}")
    UserDto getUserInfo(@PathVariable String username);


    @GetMapping(value = "/api/aircraft-type-refs")
    List<AircraftTypeDto> listAircraftAllRefs();


    @GetMapping("/api/aircraftTypeBySubType/{subType}")
    String getAircraftTypeBySUbType(@PathVariable String subType);
    
    @GetMapping("/api/air-port-refs/code/{code}")
    Optional<AirPortDto> getAirportByName(@PathVariable String code);

    @GetMapping("/api/user-refs/empno/{empno}")
    UserDto getUserByEmpNO(@PathVariable String empno);

    @GetMapping("/api/task/getAllExceptionalTasks")
    List<TaskDtoCoref> getListOfExceptionalTasks(@RequestParam("phase")String phase,@RequestParam("groupTask")String groupTask);
    //UserDto getUserInfo(String connectedUser);

    
    @GetMapping("/api/resource-refs/{id}")
    ResourceDto getResource(@RequestParam("id") long id);

    
    @PostMapping("/api/resource-refs/resources")
    List<ResourceDto> getResources(@RequestBody List<Long> ids);

    
    @GetMapping("/equipment-refs/{id}")
    EquipmentDto getEquipment(@RequestParam("id") long id);

    
    @PostMapping("/api/resource-refs/equipments")
    List<EquipmentDto> getEquipments(@RequestBody List<Long> ids);


    @GetMapping("/api/delay-reason-by-task-id")
    List<DelayReasonDto> getDelayReasonByTaskId(@RequestParam("taskId") long taskId);


}
