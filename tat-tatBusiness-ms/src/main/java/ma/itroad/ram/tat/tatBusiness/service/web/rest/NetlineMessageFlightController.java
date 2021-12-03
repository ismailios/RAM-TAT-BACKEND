package ma.itroad.ram.tat.tatBusiness.service.web.rest;

import io.swagger.annotations.ApiOperation;
import ma.itroad.ram.tat.tatBusiness.service.domain.NetlineFlightMessage;
import ma.itroad.ram.tat.tatBusiness.service.dtos.NetlineFlightMessageDto;
import ma.itroad.ram.tat.tatBusiness.service.dtos.mappers.NetlineFlightMessageMapper;
import ma.itroad.ram.tat.tatBusiness.service.service.FlightService;
import ma.itroad.ram.tat.tatBusiness.service.service.NetlineFlightMessageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tatBusiness")
public class NetlineMessageFlightController {

    //Services
    @Autowired
    FlightService flightService;

    @Autowired
    NetlineFlightMessageMapper netlineFlightMessageMapper;

    @Autowired
    NetlineFlightMessageService netlineFlightMessageService;


    //Posting a list of Netline Flight Messages
    @ApiOperation(notes = "", value = "Post multiple Netline Flight Messages")
    @RequestMapping(value="/NetlineMessageFlights",method = RequestMethod.POST)
    public  ResponseEntity<String> convertDtoToEntityAndStoreItInDb(@Valid @NotNull @RequestBody List<NetlineFlightMessageDto> messagesDto){
        Instant instant = Instant.now();
        try {
            int successUpdate = 0;
            int successCreate=0;
            int failed=0;
            String failedmessage="";
            for (NetlineFlightMessageDto messageDto : messagesDto) {
                try {
                    //System.out.println("start convert");
                    NetlineFlightMessage msg = netlineFlightMessageMapper.toEntity(messageDto);
                    //System.out.println("converted");
                    if(!msg.getLegNo().equals(""))
                        {   //System.out.println("start generate flight");
                            String s = flightService.convertNetlineMessageToFLight(msg,instant);
                            //System.out.println("flight generated");
                        if(s.equals("updated"))
                        successUpdate++;
                        if(s.equals("created"))
                        successCreate++;}
                    else {
                        //System.out.println("wrong msg "+messageDto.toString());
                    }
                }
                catch (Exception exception){
                    failedmessage= failedmessage+"\n"+messageDto.toString()+" exception:"+exception;
                    failed++;
                }
            }
            String s= successCreate+successUpdate+" Netline Messages successfully inserted \n"+
                    successCreate+" Flights created \n"+
                    successUpdate+" Flights updated \n"+
                    //failed+" failed (empty netline message ?) \n"+
                    failedmessage;
            System.out.println(s);
            return new ResponseEntity<>(s, HttpStatus.CREATED);
        }
        catch(Exception e){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "not inserted  \n"+e.toString(), e);
        }

    }

    //Posting a single Netline Flight Message // unused
    @ApiOperation(notes = "", value = "Post single Netline Flight Message")
    @RequestMapping(value="/OneNetlineMessageFlight",method = RequestMethod.POST)
    public ResponseEntity<String> convertDtoToEntityAndStoreItInDb(@Valid @RequestBody NetlineFlightMessageDto messageDto){
        Instant instant = Instant.now();
        try {
                NetlineFlightMessage msg = netlineFlightMessageMapper.toEntity(messageDto);
                String s =flightService.convertNetlineMessageToFLight(msg, instant);
                s = "Netline Message inserted, Flight "+s;
                return new ResponseEntity<>(s, HttpStatus.CREATED);
            }
        catch (Exception e){
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, messageDto.toString()+"\n"+e.toString(), e);
        }

    }



    //get All Netline Messages
    //@PreAuthorize("hasAuthority('SCOPE_coref')")
    @ApiOperation(notes = "", value = "get All stored Netline Flight Messages ")
    @RequestMapping(value="/netline/findAllNetlineMessages",method = RequestMethod.GET)
    public List<NetlineFlightMessageDto> findAllNetlineMessages(){
        List<NetlineFlightMessage> allFlights=netlineFlightMessageService.findAllNetlineMessages();
        List<NetlineFlightMessageDto> allFlightsDto = new ArrayList<>();
        for(NetlineFlightMessage flight : allFlights){
            NetlineFlightMessageDto flightMessageDto = netlineFlightMessageMapper.toDto(flight);
            allFlightsDto.add(flightMessageDto);
        }
        return allFlightsDto;
    }



}
