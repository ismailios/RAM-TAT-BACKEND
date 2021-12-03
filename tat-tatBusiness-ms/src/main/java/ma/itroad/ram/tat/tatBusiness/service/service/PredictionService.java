package ma.itroad.ram.tat.tatBusiness.service.service;

import ma.itroad.ram.tat.tatBusiness.service.domain.Flight;
import ma.itroad.ram.tat.tatBusiness.service.domain.Tat;
import ma.itroad.ram.tat.tatBusiness.service.domain.TatPredict;
import ma.itroad.ram.tat.tatBusiness.service.proxy.CorefProxy;
import ma.itroad.ram.tat.tatBusiness.service.repository.TatPredictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import static java.lang.Math.abs;

@Service
public class PredictionService {

    @Value("${local-airport}")
    String LOCALAIRPORT;

    @Autowired
    CorefProxy corefProxy;

    @Autowired
    TatPredictRepository tatPredictRepository;

    public int timeOfDay(LocalDateTime date){
        int hour= date.getHour();
        if(hour>=4 && hour<=9)
            return  1;//"MORNING";
        else if (hour>=10 && hour<=14)
            return 2;//"MIDDAY";
        else if(hour>=15 && hour<=19)
            return 3; //EVENING
        else
            return 4; // NIGHT;
    }

    public int  taskNumberDeparture(Flight flight){
        String acSubType=flight.getAcSubtype();
        switch (acSubType){
            case "73G": case "73H": case "788": case "789":
                return 26;
            case "76Y":
                return 18;
            case "AT7":
                return 23;
            default:
                return 0;
        }
    }

    public int taskNumberTouchDown(Flight flight){
        String acSubType=flight.getAcSubtype();
        switch (acSubType){
            case "73G": case "73H": case "788": case "789":
                return 39;
            case "76Y":
                return 25;
            case "AT7":
                return 36;
            default:
                return 0;
        }

    }

    public String ownerCategory(Flight flight){
        if(flight.getFnCarrier().equals("AT"))
        {
            if(flight.getAcOwner().equals("AT")||flight.getAcOwner().equals("RXP"))
                return "RAM_RAM";
            else return "RAM_AFF";
        }
        else return "NO_RAM";

    }

    public String aircraftType(Flight flight) {
        if(flight.getAcSubtype().equals("AT7"))
            return "AT7";
        else
        return corefProxy.getAircraftTypeBySUbType(flight.getAcSubtype());
    }

    public String seasonOfMonth(int month){
        String[]seasons= {"WINTER","WINTER","MID-SEASON","MID-SEASON","SUMMER","SUMMER","SUMMER","SUMMER","MID-SEASON","MID-SEASON","WINTER","WINTER"};
        return seasons[month-1];
    }

    public String flightCategory(Flight flight){
        String legType=flight.getLegType();
        switch(legType){
            case "J": case"S": case"U":/*case"G":case"B":case"R":case"C":case"O":*/case"L":case"D":case"E": case"W":
                return "CPAX";
            case "F": case"V": case"M": case"Q": /*case"G": case"B": case"A": case"R": case"C": case"O":*/ case"H":
                return "CCAR";
            case"G":case"B":case"R":case"C": case"O" :
                return "CPAX-CCAR";
            case "T":
                return "VEES";
            case "K":
                return "VETRA";
            case "P":
                {
                    if(flight.getAcSubtype().equals("T"))
                        return "MEPP";
                    else if(flight.getAcSubtype().equals("P"))
                        return "F";
                }
            default:return null;
        }

    }

    public String generateTatPredict(Tat tat) {
        if(!tat.isArr()) {
            try{
                TatPredict tatPredict = new TatPredict();
                Flight arrFlight = new Flight();
                Flight depFlight = new Flight();

                for (Flight flight : tat.getFlights()) {
                    if (flight.getArrApActual().equals(LOCALAIRPORT))
                        arrFlight = flight;
                    else
                        depFlight = flight;
                }


                //TAT_TYPE
                if (tat.getTatType().equals("ArrDep")){
                    tatPredict.setTatType("ARR_DEP");
                    //ARR_REF
                    String arrRef= arrFlight.getFnCarrier()+arrFlight.getFnNumber()+arrFlight.getDepApActual()+arrFlight.getDayOfOrigin();
                    tatPredict.setArrRef(arrRef);
                    //ARR_AP_ACTUAL
                    tatPredict.setArrApActual(LOCALAIRPORT);

                    //SCHEDULED_TAT
                    long scheduled=15+ abs(ChronoUnit.MINUTES.between(arrFlight.getArrSchedAsDateTime(),depFlight.getDepSchedAsDateTime()));
                    tatPredict.setScheduledTat(scheduled);

                    //AVAILABLE_TAT
                    long available=abs(ChronoUnit.MINUTES.between(arrFlight.getOnblockAsDateTime(),depFlight.getDepSchedAsDateTime()));
                    tatPredict.setAvailableTat(available);

                    //task number
                    tatPredict.setTaskNUmber(taskNumberTouchDown(depFlight));


                }
                else {
                    //TAT_TYPE
                    tatPredict.setTatType("DEP");

                    //ARR_AP_ACTUAL
                    tatPredict.setArrApActual(depFlight.getArrApActual());

                    //SCHEDULED_TAT /AVAILABLE
                    if(aircraftType(depFlight).equals("AT7")||aircraftType(depFlight).equals("MP"))
                    {   tatPredict.setScheduledTat(50);
                        tatPredict.setAvailableTat(50);}
                    else if(aircraftType(depFlight).equals("GP"))
                    {   tatPredict.setScheduledTat(75);
                        tatPredict.setAvailableTat(75);}

                    //task number
                    tatPredict.setTaskNUmber(taskNumberDeparture(depFlight));





                }

                //DEP_REF
                String depRef= depFlight.getFnCarrier()+depFlight.getFnNumber()+depFlight.getDepApActual()+depFlight.getDayOfOrigin();
                tatPredict.setDepRef(depRef);

                //DEP APP ACTUAL
                tatPredict.setDepApActual(LOCALAIRPORT);

                //FN_NUMBER
                int fnNumber=Integer.parseInt(depFlight.getFnNumber());
                tatPredict.setFnNUmber(fnNumber );

                //AC Registration
                tatPredict.setAcRegistration(depFlight.getAcRegistration());

                //AC_SUBTYPE
                tatPredict.setAcSubType(depFlight.getAcSubtype());

                // AC_OWNER
                tatPredict.setAcOwner(depFlight.getAcOwner());

                //TAT_OWNER_CATEGORY
                tatPredict.setOwnerCategory(ownerCategory(depFlight));

                //leg_type
                tatPredict.setLegType(depFlight.getLegType());

                //tat_year
                tatPredict.setYear(depFlight.getDayOfOriginAsDate().getYear());

                //tat_month
                tatPredict.setMonth(depFlight.getDayOfOriginAsDate().getMonthValue());

                //tat_season
                tatPredict.setSeason(seasonOfMonth(depFlight.getDayOfOriginAsDate().getMonthValue()));

                //tat_day_of_week
                tatPredict.setDayOfTheWeek(depFlight.getOffBlockAsDateTime().getDayOfWeek().getValue());

                //tat_time_of_day
                tatPredict.setTimeOfDay(timeOfDay(depFlight.getOffBlockAsDateTime()));

                //AIRCRAFT_TYPE
                tatPredict.setAircraftType(aircraftType(depFlight));

                //FLIGHT_CATEGORY
                tatPredict.setFlightCategory(flightCategory(depFlight));

                //TAT DELAY
                tatPredict.setDelay(ChronoUnit.MINUTES.between(depFlight.getDepSchedAsDateTime(),depFlight.getOffBlockAsDateTime()));


                if (tatPredict!=null)
                    tatPredictRepository.save(tatPredict);
                return "";
            }
            catch (Exception e){
                String s=" \n err tat "+tat.getId();
                return s;
            }


        }
        else
        return "";




    }




}
