package ma.itroad.ram.tat.tatBusiness.service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import ma.itroad.ram.tat.tatBusiness.service.domain.Flight;
import ma.itroad.ram.tat.tatBusiness.service.domain.Tat;
import ma.itroad.ram.tat.tatBusiness.service.proxy.CorefProxy;
import ma.itroad.ram.tat.tatBusiness.service.repository.FlightRepository;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.lang.Math.abs;

@Service
public class TatIdentifier {

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    TatService tatService;

    @Autowired
    CorefProxy corefProxy;

    @Autowired
    TaskService taskService;
    
    @Autowired
    TatUserAssignement tatUserAssignement;
    
    @Autowired
    TatOndaAssignement tatOndaAssignement;
    
    @Autowired
    TatPassengerAssignement tatPassengerAssignement;
    
    @Autowired
    TatSitatxAssignement tatSitatxAssignement;
    
    @Autowired
    TatLoadAssignement tatLoadAssignement;

    @Value("${local-airport}")
    String currentAirport;

    LocalDateTime nowLog =LocalDateTime.now();
    //Create Tat & generate its tasks , these three functions are consumed by makeArrTat,makeDepTat, and makeArrDepTat
    public Tat createArrTat(Flight f){
        Set<Flight> flights= new HashSet<>();
        flights.add(f);
        Tat tat=new Tat("Arr",flights);
        f.setTat(tat);
        tatUserAssignement.AutomaticAssignement(tat);
        tatOndaAssignement.ondaAssignment(tat);
        tatPassengerAssignement.passengerAssignement(tat);
        tatSitatxAssignement.sitatxAssignement(tat);
        tatLoadAssignement.loadAssignement(tat);
        return tat;
    }
    public Tat createDepTat(Flight f){
        Set<Flight> flights= new HashSet<>();
        flights.add(f);
        Tat tat=new Tat("Dep",flights);
        f.setTat(tat);
        tatUserAssignement.AutomaticAssignement(tat);
        tatOndaAssignement.ondaAssignment(tat);
        tatPassengerAssignement.passengerAssignement(tat);
        tatSitatxAssignement.sitatxAssignement(tat);
        tatLoadAssignement.loadAssignement(tat);
        return tat;
    }
    public Tat createArrDepTat(Flight f1,Flight f2){
        Set<Flight> flights= new HashSet<>();
        flights.add(f1);
        flights.add(f2);
        Tat tat=new Tat("ArrDep",flights);
        f1.setTat(tat);
        f2.setTat(tat);
        tatUserAssignement.AutomaticAssignement(tat);
        tatOndaAssignement.ondaAssignment(tat);
        tatPassengerAssignement.passengerAssignement(tat);
        tatSitatxAssignement.sitatxAssignement(tat);
        tatLoadAssignement.loadAssignement(tat);
        return tat;
    }

    //removing a flight from a tat
    public void removeFlightFromTat(Flight flight,Tat tat){
        flight.setTat(null);
        tat.deleteOneFlight(flight);
    }
    //making a Tat obsolete and apply Tat identifier to the flights which were included in it
    public void eraseTat(Tat tat){
        tat.setObsolete(1);
        //System.out.println(nowLog+" tat "+tat.getId()+" is now obsolete");
        if(!tat.getFlights().isEmpty())
        for (Flight flight: tat.getFlights()){
            generateAndStoreTat(flight,currentAirport);
        }
    }

    //Check if Tat if Exist , check if it is the right type , if so ok , else erase it and create new one.
    public Tat makeDepTat(Flight flight){
        Tat oldTat = flight.getTat();
        if (oldTat!=null)
        {   if(oldTat.isDep())
            {//System.out.println(nowLog+" Dep Tat already exist for flight "+flight.getUniqueCode());
            return oldTat;}
            else
                {removeFlightFromTat(flight,oldTat);
                eraseTat(oldTat);
                return createDepTat(flight);}
        }
        else {
            return createDepTat(flight);
        }
    }
    public Tat makeArrTat(Flight flight){
        Tat arrTat ;
        Tat oldTat = flight.getTat();
        if (oldTat!=null)
        {   if(oldTat.isArr())
            {   //System.out.println(nowLog+" Arr Tat already exist for flight "+flight.getUniqueCode());
                arrTat= oldTat;}
        else
        {removeFlightFromTat(flight,oldTat);
            eraseTat(oldTat);
            arrTat= createArrTat(flight);}
        }
        else {
            arrTat= createArrTat(flight);
        }
        return arrTat;
    }
    public Tat makeArrDepTat(Flight f1,Flight f2){
            Tat tat1 =f1.getTat();
            Tat tat2 = f2.getTat();
            if(tat1 == null && tat2==null){
                return  createArrDepTat(f1,f2);
            }
            if(tat1==tat2) {
                //System.out.println(nowLog+" ArrDep Tat already exist for flights "+f1.getUniqueCode()+" & "+f2.getUniqueCode());
                return tat1;
            }
            if(tat2!=null && tat1==null ) {
                removeFlightFromTat(f2,tat2);
                eraseTat(tat2);
                Tat newTat = createArrDepTat(f1,f2);
                return newTat;
            }
            if(tat1!=null && tat2==null){
                removeFlightFromTat(f1,tat1);
                eraseTat(tat1);
                Tat newTat = createArrDepTat(f1,f2);
                return newTat;
            }
            if(tat1!= tat2){
                removeFlightFromTat(f1,tat1);
                eraseTat(tat1);
                removeFlightFromTat(f2,tat2);
                eraseTat(tat2);
                Tat newTat = createArrDepTat(f1,f2);
                return newTat;
            }
            else
                return tat1;



    }

    //get the actual arrival time if exist , else the estimated one , else the scheduled one
    public String getFlightDepAirport(Flight f){
        if(f.getDepApActual()!=null)
            return f.getDepApActual();
        else return f.getDepApSched();
    }

    //get the estimated depart time , else the scheduled one ( no actual)
    public String getFlightArrAirport(Flight f){
        if(f.getArrApActual()!=null)
            return f.getArrApActual();
        else return f.getArrApSched();
    }

    // subtype , the client should be notified later about the new subtype
    public long tatMax(Flight f){

        final long defaultTatMax = 60;
        try {
            long tatMax = corefProxy.tatMaxBySubType(f.getAcSubtype());
            //System.out.println(nowLog+" getting tat max for "+f.getAcSubtype()+" from Coref : SUCCESS");
            return tatMax;
             }
        catch (Exception e){
        	//System.out.println(nowLog+" getting tat max for "+f.getAcSubtype()+" from Coref : FAILED , tat max by default value is taken ");
            return defaultTatMax;
        }
    }

    public Flight latestArrival(Flight f){
        List<Flight> flightList = flightRepository.findLatestArrivalOfAircraft(f.getAcRegistration(),getDepDateByLegType(f),currentAirport, PageRequest.of(0,1));
        if (flightList.isEmpty())
            return null;
        else return flightList.get(0);

    }
    public Flight nearestDeparture(Flight f){
        List<Flight> flightList = flightRepository.findNearestDepartureOfAircraft(f.getAcRegistration(),getArrDateByLegType(f),currentAirport,PageRequest.of(0,1));
        if (flightList.isEmpty())
            return null;
        else return flightList.get(0);

    }

    //check if it is a quick return CMN->CMN
    public boolean quickReturn(Flight flight,String airport){
        return (getFlightArrAirport(flight).equals(airport) &&getFlightDepAirport(flight).equals(airport));
    }
    //check if it is outside local airport
    public boolean outsideAirport(Flight flight,String airport){
        return (!getFlightArrAirport(flight).equals(airport) && !getFlightDepAirport(flight).equals(airport));
    }

    // Arr date is onblock time if exist , then estimated if exist , else scheduled
    LocalDateTime getArrDateByLegType(Flight flight){

        if(flight.getOnblockAsDateTime()!=null)
            return flight.getOnblockAsDateTime();

        else if(flight.getArrEstAsDateTime()!=null)
                return flight.getArrEstAsDateTime();
        else return flight.getArrSchedAsDateTime();


    }

    //Dep date is estimated else scheduled
    LocalDateTime getDepDateByLegType(Flight flight){
        if (flight.getDepEstAsDateTime()!=null)
            return flight.getDepEstAsDateTime();
        else return flight.getDepSchedAsDateTime();
    }

    //generate Tat
    @Transactional
    public  Tat generateTatFromFlight(Flight flight,String localAirport){
        //System.out.println(nowLog+"   creating Tat from flight Process Started");
        Tat tat =  flight.getTat();
        long tatMax = tatMax(flight);
        flight.setTatMax(tatMax);
        if(
                (getFlightArrAirport(flight).equals(localAirport) &&getFlightDepAirport(flight).equals(localAirport))
                || flight.getLegState().equals("CNL")||flight.getLegState().equals("RTR")

        ){
            //System.out.println(nowLog+" RTR OR CNL "+flight.getUniqueCode()+" Departure "+getFlightDepAirport(flight)+" /Arrival "+getFlightArrAirport(flight)+" / legState "+flight.getLegState());
            Tat tatToErase =flight.getTat();
            if(tatToErase!=null)
            {
                flight.setTat(null);
                eraseTat(tatToErase);
            }
            return null;
        }
        if((!getFlightArrAirport(flight).equals(localAirport) &&!getFlightDepAirport(flight).equals(localAirport))){
            //System.out.println(nowLog+" OUTSIDE "+flight.getUniqueCode()+"  Departure "+getFlightDepAirport(flight)+" /Arrival  "+getFlightArrAirport(flight));
            Tat tatToErase =flight.getTat();
            if(tatToErase!=null)
            {
                flight.setTat(null);
                eraseTat(tatToErase);
            }
            return null;
        }
        if(getFlightDepAirport(flight).equals(localAirport)){
                Flight previousArrival = latestArrival(flight);
                if(previousArrival==null){
                    return makeDepTat(flight);
                }
                long diff = abs(ChronoUnit.MINUTES.between(getArrDateByLegType(previousArrival), getDepDateByLegType(flight)));
                if(diff>tatMax){
                    //System.out.println(nowLog+" time difference between Arr&Dep  > tatMax  -->  if doesn't already exist , create Dep Tat with flight  "+flight.getUniqueCode());
                    return makeDepTat(flight);
                }
                if(diff<=tatMax){
                    //System.out.println(nowLog+" diff time <= tatMax --> if doesn't already exist, create ArrDep Tat with flights Dep: "+ flight.getUniqueCode()+" & Arr: "+previousArrival.getUniqueCode());
                    return makeArrDepTat(flight,previousArrival);

                }
            }
        if(getFlightArrAirport(flight).equals(localAirport) ){
                Flight nearestDeparture = nearestDeparture(flight);
                if(nearestDeparture==null){
                return makeArrTat(flight);}

                long diff = abs(ChronoUnit.MINUTES.between(getDepDateByLegType(nearestDeparture), getArrDateByLegType(flight)));
                if(diff>tatMax){
                    //System.out.println(nowLog+" diff time > tatMax --> if doesn't already exist , create Arr Tat with flight"+flight.getUniqueCode());
                    return makeArrTat(flight);
                }
                if(diff<=tatMax){
                    //System.out.println(nowLog+" diff time <= tatMax --> if doesn't already exist , create ArrDep Tat with flights Dep "+nearestDeparture.getUniqueCode()+" & Arr "+flight.getUniqueCode());
                    return makeArrDepTat(flight,nearestDeparture);
                }
            }



        return tat;

    }

    //call generate Tat function and return if tat was created or null
    public String generateAndStoreTat(Flight flight,String localAirport){
        ////System.out.println(nowLog+"start Order "+100*Math.random());
        Tat tat = generateTatFromFlight(flight,localAirport);
        
        if(tat!=null)
        {
            ////System.out.println("start assign users to tat");
        	//tatUserAssignement.AutomaticAssignement(tat);

        	tatService.saveTat(tat);
                //System.out.println(nowLog+" tat saved  ");
                return tat.toString();
        }
        else {
                 //System.out.println(nowLog+" no tat created ");
                 return "no tat";
        }

    }

}
