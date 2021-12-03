package ma.itroad.ram.tat.tatBusiness.service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ma.itroad.ram.tat.tatBusiness.service.domain.Flight;
import ma.itroad.ram.tat.tatBusiness.service.domain.NetlineFlightMessage;
import ma.itroad.ram.tat.tatBusiness.service.domain.NetlineInstantTransaction;
import ma.itroad.ram.tat.tatBusiness.service.repository.FlightRepository;

//import java.awt.print.Pageable;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;

import static ma.itroad.ram.tat.tatBusiness.service.domain.enums.LegStateEnum.legStateEnum;

@Service
public class FlightService {

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    TatIdentifier tatIdentifier;

    @Autowired
    NetlineFlightMessageService netlineFlightMessageService;

    @Autowired
    NetlineDatesParser netlineDatesParser;
    

    

    @Value("${local-airport}")
    String LOCALAIRPORT;

    @Value("${flight-start}")
    int startDefault;

    @Value("${flight-end}")
    int endDefault;


    public Flight createFlightFromNetlineMessage(NetlineFlightMessage message,Instant legDateTime){

        Flight flight= new Flight();

        flight.setLegNo(message.getLegNo());
        flight.setFnCarrier(message.getFnCarrier());
        flight.setFnNumber(message.getFnNumber());
        flight.setFnSuffix(message.getFnSuffix());
        flight.setJointFnCarrier1(message.getJointFnCarrier1());
        flight.setJointFnCarrier2(message.getJointFnCarrier2());
        flight.setJointFnCarrier3(message.getJointFnCarrier3());
        flight.setDayOfOrigin(message.getDayOfOrigin());
        flight.setAcOwner(message.getAcOwner());
        flight.setAcSubtype(message.getAcSubtype());
        flight.setAcLogicalNo(message.getAcLogicalNo());
        flight.setAcVersion(message.getAcVersion());
        flight.setAcPrbd(message.getAcPrbd());
        flight.setIsRam(message.getIsRam());
        flight.setAcRegistration(message.getAcRegistration());
        flight.setDepTimeEst(message.getDepTimeEst());
        flight.setDepApSched(message.getDepApSched());
        flight.setArrApSched(message.getArrApSched());
        flight.setDepApActual(message.getDepApActual());
        flight.setArrApActual(message.getArrApActual());
        flight.setLegState(message.getLegState());
        flight.setLegType(message.getLegType());

        flight.setDepDaySched(message.getDepDaySched());
        flight.setDepTimeSched(message.getDepTimeSched());
        flight.setArrTimeSched(message.getArrTimeSched());
        flight.setDepDayEst(message.getDepDayEst());
        flight.setArrDayEst(message.getArrDayEst());
        flight.setArrDaySched(message.getArrDaySched());
        flight.setArrTimeEst(message.getArrTimeEst());
        flight.setNextInfoDay(message.getNextInfoDay());
        flight.setNextInfoTime(message.getNextInfoTime());
        flight.setOffBlockDay(message.getOffBlockDay());

        flight.setOffBlockTime(message.getOffBlockTime());
        flight.setAirborneDay(message.getAirborneDay());
        flight.setAirborneTime(message.getAirborneTime());
        flight.setLandingDay(message.getLandingDay());
        flight.setOnBlockDay(message.getOnBlockDay());
        flight.setOnBlockTime(message.getOnBlockTime());
        flight.setNextInfoDay(message.getNextInfoDay());
        flight.setNextInfoTime(message.getNextInfoTime());

        flight.setDelayTime01(message.getDelayTime01());
        flight.setDelayTime02(message.getDelayTime02());
        flight.setDelayTime03(message.getDelayTime03());
        flight.setDelayCode01(message.getDelayCode01());
        flight.setDelayCode02(message.getDelayCode02());
        flight.setDelayCode03(message.getDelayCode03());

        flight.setUniqueCode(message.generateUniqueFlightCode());
        flight.setFlightNumber(""+message.getFnCarrier()+message.getFnNumber());


        //parse dates

        flight.setDayOfOriginAsDate(netlineDatesParser.dateParser(message.getDayOfOrigin()));
        flight.setDepEstAsDateTime(netlineDatesParser.dateTimeParser(message.getDepDayEst(),message.getDepTimeEst()));
        flight.setArrEstAsDateTime(netlineDatesParser.dateTimeParser(message.getArrDayEst(),message.getArrTimeEst()));
        flight.setArrSchedAsDateTime(netlineDatesParser.dateTimeParser(message.getArrDaySched(),message.getArrTimeSched()));
        flight.setDepSchedAsDateTime(netlineDatesParser.dateTimeParser(message.getDepDaySched(),message.getDepTimeSched()));
        flight.setOnblockAsDateTime(netlineDatesParser.dateTimeParser(message.getOnBlockDay(),message.getOnBlockTime()));
        flight.setLandingAsDAteTime(netlineDatesParser.dateTimeParser(message.getLandingDay(),message.getLandingTime()));
        flight.setAirborneAsDateTime(netlineDatesParser.dateTimeParser(message.getAirborneDay(),message.getAirborneTime()));
        flight.setOffBlockAsDateTime(netlineDatesParser.dateTimeParser(message.getOffBlockDay(),message.getOffBlockTime()));
        flight.setNextInfoAsDayTime(netlineDatesParser.dateTimeParser(message.getNextInfoDay(),message.getNextInfoTime()));

        //last operation id
        flight.setLastLegMessage(message.getId());
        flight.setLastOperation(message.getId());

        //legDateTime
        flight.setLegDateTime(legDateTime);


        return flight;

    }


    public Flight updateFlightFromNetlineMessage(Flight flight,NetlineFlightMessage message,Instant legDateTime){

        flight.setLegNo(message.getLegNo());
        flight.setFnCarrier(message.getFnCarrier());
        flight.setFnNumber(message.getFnNumber());
        flight.setFnSuffix(message.getFnSuffix());
        flight.setJointFnCarrier1(message.getJointFnCarrier1());
        flight.setJointFnCarrier2(message.getJointFnCarrier2());
        flight.setJointFnCarrier3(message.getJointFnCarrier3());
        flight.setDayOfOrigin(message.getDayOfOrigin());
        flight.setAcOwner(message.getAcOwner());
        flight.setAcSubtype(message.getAcSubtype());
        flight.setAcLogicalNo(message.getAcLogicalNo());
        flight.setAcVersion(message.getAcVersion());
        flight.setAcPrbd(message.getAcPrbd());
        flight.setIsRam(message.getIsRam());
        flight.setAcRegistration(message.getAcRegistration());
        flight.setDepTimeEst(message.getDepTimeEst());
        flight.setDepApSched(message.getDepApSched());
        flight.setArrApSched(message.getArrApSched());
        flight.setDepApActual(message.getDepApActual());
        flight.setArrApActual(message.getArrApActual());
        flight.setLegState(message.getLegState());
        flight.setLegType(message.getLegType());
        flight.setDepDaySched(message.getDepDaySched());
        flight.setDepTimeSched(message.getDepTimeSched());
        flight.setArrTimeSched(message.getArrTimeSched());
        flight.setDepDayEst(message.getDepDayEst());
        flight.setArrDayEst(message.getArrDayEst());
        flight.setArrDaySched(message.getArrDaySched());
        flight.setArrTimeEst(message.getArrTimeEst());
        flight.setNextInfoDay(message.getNextInfoDay());
        flight.setNextInfoTime(message.getNextInfoTime());
        flight.setOffBlockDay(message.getOffBlockDay());
        flight.setOffBlockTime(message.getOffBlockTime());
        flight.setAirborneDay(message.getAirborneDay());
        flight.setAirborneTime(message.getAirborneTime());
        flight.setLandingDay(message.getLandingDay());
        flight.setOnBlockDay(message.getOnBlockDay());
        flight.setOnBlockTime(message.getOnBlockTime());
        flight.setDelayTime01(message.getDelayTime01());
        flight.setDelayTime02(message.getDelayTime02());
        flight.setDelayTime03(message.getDelayTime03());
        flight.setDelayCode01(message.getDelayCode01());
        flight.setDelayCode02(message.getDelayCode02());
        flight.setDelayCode03(message.getDelayCode03());
        flight.setFlightNumber(""+message.getFnCarrier()+message.getFnNumber());

        flight.setDayOfOriginAsDate(netlineDatesParser.dateParser(message.getDayOfOrigin()));
        flight.setDepEstAsDateTime(netlineDatesParser.dateTimeParser(message.getDepDayEst(),message.getDepTimeEst()));
        flight.setArrEstAsDateTime(netlineDatesParser.dateTimeParser(message.getArrDayEst(),message.getArrTimeEst()));
        flight.setArrSchedAsDateTime(netlineDatesParser.dateTimeParser(message.getArrDaySched(),message.getArrTimeSched()));
        flight.setDepSchedAsDateTime(netlineDatesParser.dateTimeParser(message.getDepDaySched(),message.getDepTimeSched()));
        flight.setOnblockAsDateTime(netlineDatesParser.dateTimeParser(message.getOnBlockDay(),message.getOnBlockTime()));
        flight.setLandingAsDAteTime(netlineDatesParser.dateTimeParser(message.getLandingDay(),message.getLandingTime()));
        flight.setAirborneAsDateTime(netlineDatesParser.dateTimeParser(message.getAirborneDay(),message.getAirborneTime()));
        flight.setOffBlockAsDateTime(netlineDatesParser.dateTimeParser(message.getOffBlockDay(),message.getOffBlockTime()));

        //last operations
        flight.setLastLegMessage(message.getId());
        flight.setLastOperation(message.getId());

        // legDateTime
        flight.setLegDateTime(legDateTime);



        return flight;
    }

    public boolean tatForUpdate(Flight flight,NetlineFlightMessage message)
    {
        if(     flight.getDepDaySched()!=message.getDepDaySched()||
                flight.getDepTimeSched()!=message.getDepTimeSched()||
                flight.getDepDayEst()!=message.getDepDayEst()||
                flight.getDepTimeEst()!=message.getDepTimeEst()||
                flight.getDepApActual()!=message.getDepApActual()||
                flight.getArrDaySched()!=message.getArrDaySched()||
                flight.getArrTimeSched()!=message.getArrTimeSched()||
                flight.getArrDayEst()!=message.getArrDayEst()||
                flight.getArrTimeEst()!=message.getArrTimeEst()||
                flight.getArrApSched()!=message.getArrApSched()||
                flight.getArrApActual()!=message.getArrApActual()||
                flight.getOnBlockDay()!=message.getOnBlockDay()||
                flight.getOnBlockTime()!=message.getOnBlockTime()||
                flight.getAcRegistration()!=message.getAcRegistration()

        )
            return true;
        else
            return false;
    }
    public String convertNetlineMessageToFLight(NetlineFlightMessage msg, Instant legTimeDate){
        netlineFlightMessageService.saveNetlineFlightMessage(msg);
        String s;
        Flight f11 = new Flight();
        List<Flight> flights= flightRepository.findingFlightByUniqueCode(msg.generateUniqueFlightCode());
        if(flights.size()==0){
            s="created";
            Flight f2 = createFlightFromNetlineMessage(msg,legTimeDate);
            flightRepository.save(f2);
            tatIdentifier.generateAndStoreTat(f2,LOCALAIRPORT);
            flightRepository.save(f2);
            return s;
        }
        else
        {   s="updated";
            Flight f3 = flights.get(0);
            boolean b = tatForUpdate(f3,msg);
            updateFlightFromNetlineMessage(f3,msg,legTimeDate);
            flightRepository.save(f3);
            if(true) //b
            tatIdentifier.generateAndStoreTat(f3,LOCALAIRPORT);
            flightRepository.save(f3);


            return s;

        }

    }

    public Page<Flight> findAllFlights(Pageable page ) {
        //Pageable page = PageRequest.of(pageNumber,pageSize);
        Page<Flight> flights = flightRepository.findAllFLights( LocalDateTime.now().minusHours(startDefault),
                                                                LocalDateTime.now().plusHours(endDefault),
                                                                LOCALAIRPORT,
                                                                page);
        return flights;
    }



    public Page<Flight> filterFlights(String acRegistration,String tatType,String isRam,
                                      String flightNumber,String fnCarrier,
                                      String fnNumber,LocalDateTime startDate,LocalDateTime endDate,
                                      int interval, Pageable page){
        LocalDateTime customStart ;
        LocalDateTime customEnd;
        if(interval==0){
            customStart = startDate;
            customEnd= endDate;
        }
        else if(interval >0){
            customStart = LocalDateTime.now();
            customEnd = LocalDateTime.now().plusHours(interval)  ;
            startDate=customStart;
            endDate=customEnd;
        }
        else{
            customStart = LocalDateTime.now().minusHours(-interval)  ;
            customEnd = LocalDateTime.now();
            startDate=customStart;
            endDate=customEnd;
        }


        Page<Flight> filteredFlights = flightRepository.filterFlights(acRegistration,
                tatType,isRam,flightNumber,fnCarrier,fnNumber,startDate,endDate,customStart,customEnd,LOCALAIRPORT,page);
        return filteredFlights;
    }

    public String padLeftZeros(String inputString, int length) {
        if (inputString.length() >= length) {
            return inputString;
        }
        StringBuilder sb = new StringBuilder();
        while (sb.length() < length - inputString.length()) {
            sb.append('0');
        }
        sb.append(inputString);

        return sb.toString();
    }

    public Flight updateFlightWithInstantNatKey(Flight f , NetlineInstantTransaction msg){


        //state
        String state=msg.getLegState();
        f.setLegState(state);

        //natKey elements
        f.setFnCarrier(msg.getFnCarrier());
        f.setFnNumber(""+msg.getFnNumber());
        f.setFlightNumber(msg.getFnCarrier()+msg.getFnNumber());
        f.setDayOfOrigin(msg.getDayOfOrigin().replaceAll("-",""));
        f.setDayOfOriginAsDate(netlineDatesParser.parseTransactionDate(msg.getDayOfOrigin()));
        f.setDepApSched(msg.getDepApSched());
        f.setUniqueCode(msg.generateNatKey());
        f.setLegNo(msg.getLegNo());


        //balise schedule
        //arrival
        f.setArrApSched(msg.getArrivalAirport());
        f.setArrApActual(msg.getArrivalAirport());

        //departure
        //depSched already taken from natkey
        f.setDepApActual(msg.getDepApSched());

        f.setDepSchedAsDateTime(msg.getDeparture());
        f.setArrSchedAsDateTime(msg.getArrival());

        f.setDepEstAsDateTime(msg.getDeparture());
        f.setArrEstAsDateTime(msg.getArrival());

        f.setAcOwner(msg.getAircraftOwner());
        f.setLegType(msg.getServiceType());
        f.setAcSubtype(msg.getAircraftSubtype());
        f.setAcVersion(msg.getAircraftConfiguration());
        f.setAcRegistration(msg.getRegistration());
        if(msg.getFnCarrier().equals("AT"))
            f.setIsRam("1");
        else
            f.setIsRam("O");

        if(msg.delayCode!=null && msg.delayTime!=null){
            List<String> delayCodes=msg.generateDelayCodes();
            List<String> delayTimes=msg.generateDelayTimes();

            f.setDelayCode01(delayCodes.get(0));
            String s0=delayTimes.get(0);
            f.setDelayTime01(padLeftZeros(s0,4));
            if(delayCodes.size()>1 && delayCodes.size()>1)
            {
                f.setDelayCode02(delayCodes.get(1));
                String s1 =delayTimes.get(1);
                f.setDelayTime02(padLeftZeros(s1,4));
            }
            if(delayCodes.size()>2 && delayCodes.size()>2)
            {
                f.setDelayCode03(delayCodes.get(2));
                String s2=delayTimes.get(2);
                f.setDelayTime03(padLeftZeros(s2,4));
            }
        }

        switch(legStateEnum(state)){

            case OUT:
                f.setArrEstAsDateTime(msg.getEstimatedTimeArrival());
                f.setOffBlockAsDateTime(msg.getOffblockTime());
                //delay code if exist
                break;
            case ON:
                f.setArrEstAsDateTime(msg.getEstimatedTimeArrival());
                f.setOffBlockAsDateTime(msg.getOffblockTime());
                f.setAirborneAsDateTime(msg.getAirborneTime());
                f.setLandingAsDAteTime(msg.getLandingTime());
                //delay if exist
                break;
            case DEP:
                f.setArrEstAsDateTime(msg.getEstimatedTimeArrival());
                f.setOffBlockAsDateTime(msg.getOffblockTime());
                f.setAirborneAsDateTime(msg.getAirborneTime());
                //get delay if exist
                break;
            case ETD:
                f.setDepEstAsDateTime(msg.getEstimatedTimeDeparture());
                f.setArrEstAsDateTime(msg.getEstimatedTimeArrival());
                //delay if exist
                break;
            case ARR:
                f.setArrEstAsDateTime(msg.getEstimatedTimeArrival());
                f.setOffBlockAsDateTime(msg.getOffblockTime());
                f.setAirborneAsDateTime(msg.getAirborneTime());
                f.setLandingAsDAteTime(msg.getLandingTime());
                f.setOnblockAsDateTime(msg.getOnblockTime());
                //delay if exist
                break;
            case NXI:
                f.setDepEstAsDateTime(msg.getAdviseTime());
                f.setArrEstAsDateTime(msg.getEstimatedTimeArrival());
                //delay if exist
            break;
        }
        //transaction id
        f.setLastTransaction(msg.getId());
        f.setLastOperation(msg.getId());

        return f;
    }
    public Flight createFlightFromInstantMessage(NetlineInstantTransaction msg)
    {
        Flight f = new Flight();
        //state
        String state=msg.getLegState();
        f.setLegState(state);

        //natKey elements
        f.setFnCarrier(msg.getFnCarrier());
        f.setFnNumber(""+msg.getFnNumber());
        f.setFlightNumber(msg.getFnCarrier()+msg.getFnNumber());
        f.setDayOfOrigin(msg.getDayOfOrigin().replaceAll("-",""));
        f.setDepApSched(msg.getDepApSched());
        f.setUniqueCode(msg.generateNatKey());
        f.setDayOfOriginAsDate(netlineDatesParser.parseTransactionDate(msg.getDayOfOrigin()));
        f.setLegNo(msg.getLegNo());
        if(msg.getFnCarrier().equals("AT"))
        f.setIsRam("1");
        else
        f.setIsRam("O");


        //balise schedule
        //arrival
        f.setArrApSched(msg.getArrivalAirport());
        f.setArrApActual(msg.getArrivalAirport());

        //departure
        //depSched already taken from natKey
        f.setDepApActual(msg.getDepApSched());

        f.setDepSchedAsDateTime(msg.getDeparture());
        f.setArrSchedAsDateTime(msg.getArrival());

        f.setDepEstAsDateTime(msg.getDeparture());
        f.setArrEstAsDateTime(msg.getArrival());

        f.setAcOwner(msg.getAircraftOwner());
        f.setLegType(msg.getServiceType());
        f.setAcSubtype(msg.getAircraftSubtype());
        f.setAcVersion(msg.getAircraftConfiguration());
        f.setAcRegistration(msg.getRegistration());

        //transaction id
        f.setLastTransaction(msg.getId());
        f.setLastOperation(msg.getId());
       // System.out.println("new flight created");
        return f;
    }



}
