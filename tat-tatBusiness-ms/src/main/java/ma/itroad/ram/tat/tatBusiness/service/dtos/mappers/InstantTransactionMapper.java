package ma.itroad.ram.tat.tatBusiness.service.dtos.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import ma.itroad.ram.tat.tatBusiness.service.domain.NetlineInstantTransaction;
import ma.itroad.ram.tat.tatBusiness.service.dtos.changer.DelayDto;
import ma.itroad.ram.tat.tatBusiness.service.dtos.changer.InstantMessage;
import ma.itroad.ram.tat.tatBusiness.service.dtos.changer.InstantTransactionDto;

import java.time.LocalDateTime;
import java.util.List;

import static java.time.LocalDateTime.now;

@Mapper(componentModel = "spring")
public interface InstantTransactionMapper extends EntityMapper<InstantTransactionDto, NetlineInstantTransaction> {

    InstantTransactionDto dto = new InstantTransactionDto();

    String legState="java(dto.getMessage().getLegDetail().getState())";
    String misc="java(dto.getMessage().getLegDetail().getMisc())";
    String scheduleAircraftConfiguration="java(dto.getMessage().getLegDetail().getSchedule().getAircraftConfiguration())";
    String scheduleAaircraftOwner="java(dto.getMessage().getLegDetail().getSchedule().getAircraftOwner())";
    String scheduleAircraftSubType="java(dto.getMessage().getLegDetail().getSchedule().getAircraftSubtype())";
    String schduleArrivalAirport="java(dto.getMessage().getLegDetail().getSchedule().getArrivalAirport())";
    String scheduleDepartureAirport="java(dto.getMessage().getLegDetail().getSchedule().getDepartureAirport())";
    String scheduleDepartureTime = "java(dto.getMessage().getLegDetail().getSchedule().getDeparture())";
    String scheduleArrivalTime = "java(dto.getMessage().getLegDetail().getSchedule().getArrival())";
    String scheduleEmployerCabin = "java(dto.getMessage().getLegDetail().getSchedule().getEmployerCabin())";
    String scheduleServiceType = "java(dto.getMessage().getLegDetail().getSchedule().getServiceType())";
    String scheduleEmployerCokpit= "java(dto.getMessage().getLegDetail().getSchedule().getEmployerCockpit())";
    String scheduleLogicalNo= "java(dto.getMessage().getLegDetail().getSchedule().getRotationIdentifier().getLogicalNo())";
    String scheduleAcRegistration= "java(dto.getMessage().getLegDetail().getSchedule().getRotationIdentifier().getRegistration())";

    String dayOfOrigin="java(dto.getMessage().getLegDetail().getIdentifier().getNatKey().getDayOfOrigin())";
    String depApSched="java(dto.getMessage().getLegDetail().getIdentifier().getNatKey().getDepApSched())";
    String fnCarrierr="java(dto.getMessage().getLegDetail().getIdentifier().getNatKey().getFlight().getFnCarrier())";
    String fnNumberr="java(dto.getMessage().getLegDetail().getIdentifier().getNatKey().getFlight().getFnNumber())";
    String legNo="java(dto.getMessage().getLegDetail().getIdentifier().getSurrogateKey().getLegNo())";

    String lastUpdateBy= "java(dto.getMessage().getLegDetail().getLastUpdate().getUserId())";
    String lastUpdateKey="java(dto.getMessage().getLegDetail().getLastUpdate().getUpdateKey())";
    String lastUpdateTimeStamp="java(dto.getMessage().getLegDetail().getLastUpdate().getTimestamp())";
    String lastUpdateNo="java(dto.getMessage().getLegDetail().getLastUpdate().getUpdateNo())";
    String whatIf="java(dto.getMessage().getLegDetail().getIdentifier().getSurrogateKey().getWhatIf())";


    @Mapping(target="xsiSchemaLocation",source="xsiSchemaLocation")
    @Mapping(target = "sender",source="sender")
    @Mapping(target = "created",source="created")
    @Mapping(target = "legState",expression=legState)
    @Mapping(target = "misc",expression=misc)
    @Mapping(target="aircraftConfiguration",expression=scheduleAircraftConfiguration)
    @Mapping(target="aircraftOwner",expression=scheduleAaircraftOwner)
    @Mapping(target="aircraftSubtype",expression=scheduleAircraftSubType)
    @Mapping(target="arrivalAirport",expression=schduleArrivalAirport)
    @Mapping(target="arrival",expression=scheduleArrivalTime)
    @Mapping(target="departureAirport",expression=scheduleDepartureAirport)
    @Mapping(target="departure",expression=scheduleDepartureTime)
    @Mapping(target="registration",expression=scheduleAcRegistration)
    @Mapping(target="logicalNo",expression=scheduleLogicalNo)
    @Mapping(target="employerCockpit",expression=scheduleEmployerCokpit)
    @Mapping(target="serviceType",expression=scheduleServiceType)
    @Mapping(target="employerCabin",expression=scheduleEmployerCabin)
    @Mapping(target="dayOfOrigin",expression=dayOfOrigin)
    @Mapping(target="depApSched",expression=depApSched)
    @Mapping(target="fnCarrier",expression=fnCarrierr)
    @Mapping(target="fnNumber",expression=fnNumberr)
    @Mapping(target="legNo",expression=legNo)
    @Mapping(target="lastUpdateUserId",expression=lastUpdateBy)
    @Mapping(target="lastUpdateTimestamp",expression=lastUpdateTimeStamp)
    @Mapping(target="updateKey",expression=lastUpdateKey)
    @Mapping(target="updateNo",expression=lastUpdateNo)
    @Mapping(target="whatIf",expression=whatIf)

    @Mapping(target="estimatedTimeArrival",source="message",qualifiedByName = "mapEstimatedTimeArrival")
    @Mapping(target="airborneTime",source="message",qualifiedByName="actualsAirborneTime")
    @Mapping(target="landingTime",source="message",qualifiedByName="actualsLandingTime")
    @Mapping(target="onblockTime",source="message",qualifiedByName="actualsOnblockTime")
    @Mapping(target="offblockTime",source="message",qualifiedByName="actualsOffBlockTime")
    @Mapping(target="delayCode",source="message",qualifiedByName="actualsDelayCode")
    @Mapping(target="delayTime",source="message",qualifiedByName="actualsDelayTime")
    @Mapping(target="estimatedTimeDeparture",source="message",qualifiedByName = "actualsEstimatedDeparture")
    @Mapping(target="adviseTime",source="message",qualifiedByName = "adviseTIme")
    @Mapping(target="asmActionIdentifier",source="message",qualifiedByName ="asmActionIdentifier" )
    @Mapping(target="changeReason",source="message",qualifiedByName = "changeReason")

    @Mapping(target="hours",source="message",qualifiedByName = "performanceHours")
    @Mapping(target="minutes",source="message",qualifiedByName = "performanceMinutes")
    @Mapping(target="cycles",source="message",qualifiedByName = "performanceCycles")
    @Mapping(target = "oldDayOfOrigin",source = "message",qualifiedByName = "oldDayOfOrigin")
    @Mapping(target = "oldFnNumber",source = "message",qualifiedByName = "oldFnNumber")
    @Mapping(target = "oldFnCarrier",source = "message",qualifiedByName = "oldFnCarrier")
    @Mapping(target = "oldDepApSched",source = "message",qualifiedByName = "oldDepApSched")
    @Mapping(target = "ctot",source="message", qualifiedByName = "ctot")
    @Mapping(target = "callsign",source="message", qualifiedByName = "callsign")
    @Mapping(target = "taxiOutTime",source="message", qualifiedByName = "taxiOutTime")
    @Mapping(target = "natKey",source = "message",qualifiedByName ="natKey")
    @Mapping(target = "oldNatKey",source = "message",qualifiedByName ="oldNatKey")
//    @Mapping(target="logicalNo",source = "message",qualifiedByName = "logicalNo")
//    @Mapping(target="registration",source = "message",qualifiedByName = "registration")


    NetlineInstantTransaction toEntity(InstantTransactionDto dto);

    @Named("mapEstimatedTimeArrival")
    default LocalDateTime mapEstimatedTimeArrival(InstantMessage msg){
        try{
            return msg.getLegDetail().getActuals().getEstimatedTimeArrival();
        }
        catch(Exception e){
            return null;}

    }
    @Named("actualsEstimatedDeparture")
    default LocalDateTime mapEstimatedTimeDeparture(InstantMessage msg){
        try{
            return msg.getLegDetail().getActuals().getEstimatedTimeDeparture(); //
        }
        catch(Exception e){
            return null;}

    }
    @Named("adviseTIme")
    default LocalDateTime mapAdviseTime(InstantMessage msg){
        try{
            return msg.getLegDetail().getActuals().getAdviseTime(); //
        }
        catch(Exception e){
            return null;}

    }

    @Named("actualsAirborneTime")
    default LocalDateTime MapAirborneTime(InstantMessage msg){
        try{
            return msg.getLegDetail().getActuals().getAirborneTime().getDate();
        }
        catch(Exception e){
            return null;}

    }
    @Named("actualsLandingTime")
    default LocalDateTime mapLandingTime(InstantMessage msg){
        try{
            return msg.getLegDetail().getActuals().getLandingTime().getDate();
        }
        catch(Exception e){
            return null;}

    }
    @Named("actualsOnblockTime")
    default LocalDateTime mapOnblockTime(InstantMessage msg){
        try{
            return msg.getLegDetail().getActuals().getOnblockTime().getDate();
        }
        catch(Exception e){
            return null;}

    }
    @Named("actualsOffBlockTime")
    default LocalDateTime mapOffblockTime(InstantMessage msg){
        try{
            return msg.getLegDetail().getActuals().getOffblockTime().getDate();
        }
        catch(Exception e){
            return null;}

    }
    @Named("actualsDelayCode")
    default String mapDelayCode(InstantMessage msg){
        try{
            String s="";
            List<DelayDto> delays = msg.getLegDetail().getActuals().getDelay();
            for(DelayDto delay : delays){
                if(delay!=null){
                    if(delay.getDelayCode()!=null && !delay.getDelayCode().equals(" ") && !delay.getDelayCode().equals(""))
                    {
                    s=s+delay.getDelayCode()+";";
                    }
                }
            }
            return s;
        }
        catch(Exception e){
            return null;}

    }
    @Named("actualsDelayTime")
    default String mapDelayTime (InstantMessage msg){
        try{
            String s="";
            List<DelayDto> delays = msg.getLegDetail().getActuals().getDelay();
            for(DelayDto delay : delays){
                if(delay!=null) {
                   if(delay.getDelayTime()!=null && !delay.getDelayTime().equals(" ") && !delay.getDelayTime().equals("")){
                    s =s+delay.getDelayTime()+";";}

                }
            }
            return s;
        }
        catch(Exception e){
            return null;}

    }
    @Named(("changeReason"))
    default String mapChangeReason(InstantMessage msg){
        try{
            List<String> reasons =msg.getLegDetail().getChangeInfo().getChangeReason();
            String s="";
            for(String reason : reasons){
                if(!reason.equals("") && !reason.equals(" ") &&reason!=null) s =s+reason+";";
            }
            return s;
        }
        catch (Exception e )
        {return null;}
    }
    @Named(("asmActionIdentifier"))
    default String mapAsmActionIdentifier(InstantMessage msg){
        try{
            List<String> asmActions =msg.getLegDetail().getChangeInfo().getAsmActionIdentifier();
            String s="";
            for(String asmAction : asmActions){
                if(!asmAction.equals("") && !asmAction.equals(" ") && asmAction!=null) s =s+asmAction+";";
            }
            return s;
        }
        catch (Exception e )
        {return null;}
    }
    @Named("performanceHours")
    default String mapPerformanceHours(InstantMessage msg){
        try{
            String  s = msg.getLegDetail().getPerformance().getFlightHours().getHours();
            return s;
        }
        catch (Exception e){return null;}
    }
    @Named("performanceMinutes")
    default String mapPerformanceMinutes(InstantMessage msg){
        try{
            String  s = msg.getLegDetail().getPerformance().getFlightHours().getMinutes();
            return s;
        }
        catch (Exception e){return null;}
    }
    @Named("performanceCycles")
    default String mapPerformanceCycles(InstantMessage msg){
        try{
            String  s = msg.getLegDetail().getPerformance().getCycles();
            return s;
        }
        catch (Exception e){return null;}
    }
    @Named("oldDayOfOrigin")
    default String mapOldDayOfOrigin(InstantMessage msg){
        try{
            String  s = msg.getLegDetail().getIdentifier().getOldNatKey().getDayOfOrigin();
            return s;
        }
        catch (Exception e ) {return null;}
    }
    @Named("oldDepApSched")
    default String mapOldDepSched(InstantMessage msg){
        try{
            String  s = msg.getLegDetail().getIdentifier().getOldNatKey().getDepApSched();
            return s;
        }
        catch (Exception e ) {return null;}
    }
    @Named("oldFnCarrier")
    default String mapOldFnCarrier(InstantMessage msg){
        try{
            String  s = msg.getLegDetail().getIdentifier().getOldNatKey().getFlight().getFnCarrier();
            return s;
        }
        catch (Exception e ) {return null;}
    }
    @Named("oldFnNumber")
    default String mapOldFnNUmber(InstantMessage msg){
        try{
            String  s = msg.getLegDetail().getIdentifier().getOldNatKey().getFlight().getFnNumber();
            return s;
        }
        catch (Exception e ) {return null;}
    }
    @Named("logicalNo")
    default String mapLogicalNo(InstantMessage msg){
        try{
            String s =msg.getLegDetail().getSchedule().getRotationIdentifier().getLogicalNo();
            return s;
        }
        catch(Exception e) {return null;}
    }
    @Named("registration")
    default String mapRegistration(InstantMessage msg){
        try{
            String s =msg.getLegDetail().getSchedule().getRotationIdentifier().getRegistration();
            return s;
        }
        catch(Exception e) {return null;}
    }

    @Named("ctot")
    default LocalDateTime mapCtot(InstantMessage msg){
        try{
            LocalDateTime dt =msg.getLegDetail().getAtcSlot().getCtot();
            return dt;
        }
        catch(Exception e) {return null;}
    }
    @Named("callsign")
    default String mapCallSign(InstantMessage msg){
        try{
            String s =msg.getLegDetail().getAtcSlot().getCallsign();
            return s;
        }
        catch(Exception e) {return null;}
    }
    @Named("taxiOutTime")
    default String mapTaxiOutTime(InstantMessage msg){
        try{
            String s =msg.getLegDetail().getAtcSlot().getTaxiOutTime();
            return s;
        }
        catch(Exception e) {return null;}
    }
    @Named("natKey")
    default String mapNatKey(InstantMessage msg){
        try{
            String s= msg.getLegDetail().getIdentifier().getNatKey().getFlight().getFnCarrier()+
                      msg.getLegDetail().getIdentifier().getNatKey().getFlight().getFnNumber()+"-"+
                    msg.getLegDetail().getIdentifier().getNatKey().getDayOfOrigin().replaceAll("-","")+"-"+
                    msg.getLegDetail().getIdentifier().getNatKey().getDepApSched();
            return s;
        }
        catch(Exception e){return null;}
    }
    @Named("oldNatKey")
    default String mapOldNatKey(InstantMessage msg){
        if(msg.getLegDetail().getIdentifier().getOldNatKey()==null)
            return null;
        try{
            String s= msg.getLegDetail().getIdentifier().getOldNatKey().getFlight().getFnCarrier()+
                    msg.getLegDetail().getIdentifier().getOldNatKey().getFlight().getFnNumber()+"-"+
                    msg.getLegDetail().getIdentifier().getOldNatKey().getDayOfOrigin().replaceAll("-","")+"-"+
                    msg.getLegDetail().getIdentifier().getOldNatKey().getDepApSched();
            return s;
        }
        catch(Exception e){return null;}
    }
}
