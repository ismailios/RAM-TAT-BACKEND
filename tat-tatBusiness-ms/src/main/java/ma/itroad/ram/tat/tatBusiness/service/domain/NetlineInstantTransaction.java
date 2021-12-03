package ma.itroad.ram.tat.tatBusiness.service.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="netline_instant_transactions")
public class NetlineInstantTransaction{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("@xsi:schemaLocation")
    @Column(name="schemaLocation")
    public String xsiSchemaLocation;

    @JsonProperty("sender")
    @Column(name="sender")
    public String sender;

    @JsonProperty("created")
    @Column(name="created")
    public LocalDateTime created;

    @JsonProperty("state")
    @Column(name="legState")
    public String legState;

    @JsonProperty("misc")
    @Column(name="misc")
    public String misc;

    @JsonProperty("dayOfOrigin")
    @Column(name="dayOfOrigin")
    public String dayOfOrigin;

    @JsonProperty("depApSched")
    @Column(name="depApSched")
    public String depApSched;

    @JsonProperty("fnCarrier")
    @Column(name="fnCarrier")
    public String fnCarrier;

    @JsonProperty("fnNumber")
    @Column(name="fnNumber")
    public String fnNumber;

    @Column(name="oldDayOfOrigin")
    public String oldDayOfOrigin;

    @Column(name="oldDepApSched")
    public String oldDepApSched;

    @Column(name="oldFnCarrier")
    public String oldFnCarrier;

    @Column(name="oldFnNumber")
    public String oldFnNumber;

    @Column(name="legNo")
    public String legNo;

    @Column(name="whatIf")
    public String whatIf;

    @Column(name="changeReason")
    public String changeReason; //list

    @Column(name="asmActionIdentifier")
    public String asmActionIdentifier;

    @Column(name="departureAirport")
    public String departureAirport;

    @Column(name="departure")
    public LocalDateTime departure;

    @Column(name="arrivalAirport")
    public String arrivalAirport;

    @Column(name="arrival")
    public LocalDateTime arrival;

    @Column(name="serviceType")
    public String serviceType;

    @Column(name="aircraftOwner")
    public String aircraftOwner;

    @Column(name="aircraftSubtype")
    public String aircraftSubtype;

    @Column(name="aircraftConfiguration")
    public String aircraftConfiguration;

    @Column(name="logicalNo")
    public String logicalNo;

    @Column(name="registration")
    public String registration;

    @Column(name="employerCabin")
    public String employerCabin;

    @Column(name="employerCockpit")
    public String employerCockpit;

    @Column(name="flight_cycles")
    public String cycles;

    @Column(name="flight_hours")
    public String hours;

    @Column(name="flight_minutes")
    public String minutes;

    @Column(name="estimatedTimeArrival")
    public LocalDateTime estimatedTimeArrival;

    @Column(name="estimatedTimeDeparture") //// ,??
    public LocalDateTime estimatedTimeDeparture;

    @Column(name="adviseTime")
    public LocalDateTime adviseTime;

    @Column(name="delayCode")
    public String delayCode;

    @Column(name="delayTime")
    public String delayTime;

    @Column(name="airborneTime")
    public LocalDateTime airborneTime;

    @Column(name="landingTime")
    public LocalDateTime landingTime;

    @Column(name= "onblockTime")
    public LocalDateTime onblockTime;

    @Column(name="offblockTime")
    public LocalDateTime offblockTime;

    @Column(name="callsign")
    public String callsign;

    @Column(name="ctot")
    public LocalDateTime ctot;

    @Column(name="taxiOutTime")
    public String taxiOutTime;

    @Column(name="lastUpdateUserId")
    public String lastUpdateUserId;

    @Column(name="lastUpdateTimestamp")
    public LocalDateTime lastUpdateTimestamp;

    @Column(name="updateKey")
    public String updateKey;

    @Column(name="updateNo")
    public String updateNo;

    @Column(name="natKey")
    public String natKey;

    @Column(name="oldNatKey")
    public String oldNatKey;

    @Column(name = "created_date_db", nullable = true, updatable = false)
    @CreatedDate
    public LocalDateTime createdDate;

    public boolean isNewFlight(){
        try{
            return(this.asmActionIdentifier.equals("NEW;"));}
        catch(Exception e){return false;}
    }
    public String generateNatKey(){

        return ""+fnCarrier+fnNumber+"-"+dayOfOrigin.replaceAll("-","")+"-"+depApSched;
    }
    public String generateOldNatKey(){
        if(oldFnCarrier !=null)
            return ""+oldFnCarrier+oldFnNumber+"-"+oldDayOfOrigin.replaceAll("-","")+"-"+oldDepApSched;
        else
            return null;
    }
    public List<String> generateDelayCodes(){
        if(delayCode==null)
            return null;
        else{
            List<String> delayCodes = Arrays.asList(delayCode.split(";"));
            return delayCodes;
        }
    }
    public List<String> generateDelayTimes(){
        if(delayTime==null)
            return null;
        else{
            List<String> delayTimes = Arrays.asList(delayTime.split(";"));
            return delayTimes;
        }
    }

    public LocalDateTime getCreated() {
        return created;
    }

}
