package ma.itroad.ram.tat.tatBusiness.service.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import ma.itroad.ram.tat.tatBusiness.service.domain.Flight;
import ma.itroad.ram.tat.tatBusiness.service.dtos.FlightDto;
import ma.itroad.ram.tat.tatBusiness.service.dtos.mappers.FlightMapper;
import ma.itroad.ram.tat.tatBusiness.service.proxy.CorefProxy;
import ma.itroad.ram.tat.tatBusiness.service.service.FlightService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tatBusiness")
public class FlightController  {

    @Autowired
    CorefProxy corefProxy;

    @Autowired
    FlightMapper flightMapper;

    @Autowired
    FlightService flightService;

    @Value("${flight-start}")
    int startDefault;

    @Value("${flight-end}")
    int endDefault;

    @Value("${local-airport}")
    String localAirport;


   //@PreAuthorize("hasAuthority('SCOPE_coref')")

    @RequestMapping(value="/AllFlights", method= RequestMethod.GET)
    public Page<FlightDto> findAllFlights(  @PageableDefault(page = 0, size = 300) Pageable page){
        Page<Flight> flights= flightService.findAllFlights(page);
        List<FlightDto> flightDtos = new ArrayList<>();
        for(Flight flight : flights){
            FlightDto flightDto = flightMapper.toDto(flight);
            flightDtos.add(flightDto);
        }
        return new PageImpl<>(flightDtos, page, flights.getTotalElements());
        //return flightDtos;
    }
    //unused
    //@PreAuthorize("hasAuthority('SCOPE_coref')")
    @GetMapping("/AllFlightsNoDetails")
    public List<FlightDto> findAllFlightsPage( @PageableDefault(page = 0, size = 300) Pageable pageable){
        Page<Flight> flights= flightService.findAllFlights(pageable);
        List<FlightDto> flightDtos = new ArrayList<>();
        for(Flight flight : flights){
            FlightDto flightDto = flightMapper.toDto(flight);
            flightDtos.add(flightDto);
        }
        return flightDtos;
    }

//    @GetMapping("/testCoref2")
//    public long testCoref(){
//    return corefProxy.tatMaxBySubType("320");}

    //unused filter
    @RequestMapping(value="/filterFlights",method=RequestMethod.GET)
    public Page<FlightDto> filterFlights(@RequestParam(name ="acRegistration", required = false, defaultValue = "") String acRegistration,
                                         @RequestParam(name ="tatType", required = false, defaultValue = "") String tatType,
                                         @RequestParam(name ="isRam", required = false, defaultValue = "") String isRam,
                                         @RequestParam(name ="flightNumber", required = false, defaultValue = "") String flightNumber,
                                         @RequestParam(name ="fnCarrier", required = false, defaultValue = "") String fnCarrier,
                                         @RequestParam(name ="fnNumber", required = false, defaultValue = "") String fnNumber,
                                         @RequestParam(name="startDate",required = false,defaultValue = "")  @DateTimeFormat(pattern="yyyy-MM-dd") String start,
                                         @RequestParam(name="endDate",required = false,defaultValue = "")  @DateTimeFormat(pattern="yyyy-MM-dd") String end,
                                         @RequestParam(name="interval",required = false,defaultValue = "0") int interval,
                                         @PageableDefault(page = 0, size = 300) Pageable page){
        System.out.println("acRegistration "+acRegistration);
        if(!start.equals("") || !end.equals("")) {
            interval=0;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
        LocalDateTime startDate;
        LocalDateTime endDate;
        try{
            startDate = LocalDateTime.parse(start, formatter);}
        catch(Exception e){
            startDate=LocalDateTime.now().minusHours(startDefault);
        }
        try{
            endDate = LocalDateTime.parse(end, formatter);}
        catch (Exception e){
            endDate=LocalDateTime.now().plusHours(endDefault);
        }

        Page<Flight> flights= flightService.filterFlights(acRegistration,tatType,isRam,flightNumber,
                                            fnCarrier,fnNumber,startDate,endDate,interval,page);
        List<FlightDto> flightDtos = new ArrayList<>();
        for(Flight flight : flights){
            FlightDto flightDto = flightMapper.toDto(flight);
            flightDtos.add(flightDto);
        }
        return new PageImpl<>(flightDtos, page, flights.getTotalElements());

    }
}




