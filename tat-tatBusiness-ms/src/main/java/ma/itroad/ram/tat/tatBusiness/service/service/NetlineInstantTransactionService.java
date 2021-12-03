package ma.itroad.ram.tat.tatBusiness.service.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import ma.itroad.ram.tat.tatBusiness.service.domain.Flight;
import ma.itroad.ram.tat.tatBusiness.service.domain.NetlineInstantTransaction;
import ma.itroad.ram.tat.tatBusiness.service.domain.Tat;
import ma.itroad.ram.tat.tatBusiness.service.repository.FlightRepository;
import ma.itroad.ram.tat.tatBusiness.service.repository.TatRepository;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.*;

@Service
public class NetlineInstantTransactionService {


    @Autowired
    FlightService flightService;

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    TatIdentifier tatIdentifier;

    @Autowired
    NetlineDatesParser dateParser;

    @Autowired
    TatRepository tatRepository;

    @Autowired
    TatUserAssignement tatUserAssignement;

    @Autowired
    TaskService taskService;

    @Value("${local-airport}")
    String currentAirport;



    public List<NetlineInstantTransaction> sortTransactions(List<NetlineInstantTransaction> listTransactions)
    {
        Collections.sort(listTransactions, Comparator.comparing(NetlineInstantTransaction::getCreated));
        return listTransactions;
    }

    public String applyInstantChanges(NetlineInstantTransaction netlineInstantTransaction){
        LocalDateTime nowLog = LocalDateTime.now();
        System.out.println(nowLog+" update operation started ");
        LocalDate threeDaysAhead = LocalDate.now().plusDays(3);
        LocalDate transactionDate = dateParser.parseTransactionDate(netlineInstantTransaction.getDayOfOrigin());


        if(!transactionDate.isAfter(threeDaysAhead) && netlineInstantTransaction.getRegistration()!=null){
                List<Flight> flights = flightRepository.findingFlightByUniqueCode(netlineInstantTransaction.generateNatKey());
                if (!flights.isEmpty()) {
                    Flight f = flights.get(0);
                    Instant legInstant =f.getLegDateTime();
                    LocalDateTime legDateTime ;
                    if(legInstant!=null)  legDateTime = LocalDateTime.ofInstant(legInstant, ZoneOffset.UTC);
                    else legDateTime = f.getModifiedDate();
                        System.out.println(nowLog+" last update on transactions is (GMT) : " + netlineInstantTransaction.getLastUpdateTimestamp());
                        System.out.println(nowLog+" existing leg date is (GMT) : " + legDateTime);

                        //checking if msg date is before or after existing leg date
                        if (netlineInstantTransaction.getLastUpdateTimestamp().isAfter(legDateTime)) {
                            System.out.println(nowLog+" transaction date is after leg date, change DONE ");
                            f = flightService.updateFlightWithInstantNatKey(f, netlineInstantTransaction);
                            Tat tat = tatIdentifier.generateTatFromFlight(f, currentAirport);
                            flightRepository.save(f);
                            if(tat != null)
                            {
                               if(tat.isHasTasks())
                               {
                                   taskService.updateNonStartedTaskStandards(tat);
                               }
                                tatRepository.save(tat);
                            }
                            return "UPDATE";
                        } else System.out.println(nowLog+" transaction date is BEFORE leg date ;; NO changes applied , message ignored");
                            return "NO_ACTION";

                }
                else if(netlineInstantTransaction.isNewFlight())   {
                    System.out.println(nowLog+" creating a new flight from transaction");
                    Flight f = flightService.createFlightFromInstantMessage(netlineInstantTransaction);
                    System.out.println(f.toString());
                    Tat tat = tatIdentifier.generateTatFromFlight(f, currentAirport);
                    flightRepository.save(f);
                    if(tat !=null) {tatRepository.save(tat);}
                    System.out.println(nowLog+" NEW Flight created from transaction: "+f.getUniqueCode() );
                    return "CREATE";

                }
                else {
                    if (netlineInstantTransaction.generateOldNatKey() != null) {
                        System.out.println(nowLog+" searching for flight with old natKey");
                        List<Flight> oldFlights = flightRepository.findingFlightByUniqueCode(netlineInstantTransaction.generateOldNatKey());
                        if (!oldFlights.isEmpty()) {
                            Flight f = flights.get(0);
                            Instant legInstant =f.getLegDateTime();
                            LocalDateTime legDateTime ;
                            if(legInstant!=null)  legDateTime = LocalDateTime.ofInstant(legInstant, ZoneOffset.UTC);
                            else legDateTime = f.getModifiedDate(); //checking if msg date is before or after existing leg date
                            if(netlineInstantTransaction.getLastUpdateTimestamp().isAfter(legDateTime)) {

                                f = flightService.updateFlightWithInstantNatKey(f, netlineInstantTransaction);
                                Tat tat = tatIdentifier.generateTatFromFlight(f, currentAirport);
                                flightRepository.save(f);
                                if(tat != null) {
                                    if(tat.isHasTasks())
                                    {
                                        taskService.updateNonStartedTaskStandards(tat);
                                    }
                                    tatRepository.save(tat);}
                                System.out.println(nowLog+" transaction date is after leg date , change DONE , natKey updated ");
                                return "UPDATE";

                            }
                            else {System.out.println(nowLog+" transaction date is BEFORE leg date ;; no changes applied");
                                    return "NO_ACTION";}
                        }
                        else{
                            System.out.println(nowLog+" old NatKey "+netlineInstantTransaction.generateOldNatKey()+" not found in db");
                            return "NO_ACTION";
                        }
                    }
                    else{
                        System.out.println(nowLog+" natKey not found in db : natKey  "+netlineInstantTransaction.generateNatKey());
                        System.out.println(nowLog+" old NatKey is null: old natKey "+netlineInstantTransaction.generateOldNatKey());
                        System.out.println(nowLog+" state is not new : state : "+netlineInstantTransaction.getLegState());
                        System.out.println(nowLog+" state is not new : asmActionIdentifier : "+netlineInstantTransaction.getAsmActionIdentifier());
                        System.out.println(nowLog+" result : no action taken ");
                        return "NO_ACTION";
                    }
                }


        }

        else {
            System.out.println(nowLog+" Date After Three days or registration is null");
            System.out.println(nowLog+" day of origin: "+transactionDate+" ac registration: "+netlineInstantTransaction.getRegistration());
            System.out.println(nowLog+" transaction message ignored");
            return "NO_ACTION";
        }


    }


}
