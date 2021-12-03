package ma.itroad.ram.tat.tatBusiness.service.dtos.changer;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Schedule {
    @JsonProperty("departureAirport")
    public String departureAirport;

    @JsonProperty("departure")
    public LocalDateTime departure;

    @JsonProperty("arrivalAirport")
    public String arrivalAirport;

    @JsonProperty("arrival")
    public LocalDateTime arrival;

    @JsonProperty("serviceType")
    public String serviceType;

    @JsonProperty("aircraftOwner")
    public String aircraftOwner;

    @JsonProperty("aircraftSubtype")
    public String aircraftSubtype;

    @JsonProperty("aircraftConfiguration")
    public String aircraftConfiguration;

    @JsonProperty("rotationIdentifier")
    public RotationIdentifier rotationIdentifier;

    @JsonProperty("employerCabin")
    public String employerCabin;

    @JsonProperty("employerCockpit")
    public String employerCockpit;
    
}
