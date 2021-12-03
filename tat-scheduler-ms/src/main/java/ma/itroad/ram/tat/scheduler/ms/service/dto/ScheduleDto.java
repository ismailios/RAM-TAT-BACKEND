package ma.itroad.ram.tat.scheduler.ms.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleDto {


	private Long id;
    @JsonProperty("departureAirport")
    private String departureAirport;
    @JsonProperty("departure")
    private String departure;
    @JsonProperty("arrivalAirport")
    private String arrivalAirport;
    @JsonProperty("arrival")
    private String arrival;
    @JsonProperty("serviceType")
    private String serviceType;
    @JsonProperty("aircraftOwner")
    private String aircraftOwner;
    @JsonProperty("aircraftSubtype")
    private long aircraftSubtype;
    @JsonProperty("aircraftConfiguration")
    private String aircraftConfiguration;
    @JsonProperty("registration")
    private String registration;
    @JsonProperty("employerCabin")
    private String employerCabin;
    @JsonProperty("employerCockpit")
    private String employerCockpit;

    @Override
    public String toString() {
        return "ScheduleDto{" +
                "departureAirport='" + departureAirport + '\'' +
                ", departure='" + departure + '\'' +
                ", arrivalAirport='" + arrivalAirport + '\'' +
                ", arrival='" + arrival + '\'' +
                ", serviceType='" + serviceType + '\'' +
                ", aircraftOwner='" + aircraftOwner + '\'' +
                ", aircraftSubtype=" + aircraftSubtype +
                ", aircraftConfiguration='" + aircraftConfiguration + '\'' +
                ", registration='" + registration + '\'' +
                ", employerCabin='" + employerCabin + '\'' +
                ", employerCockpit='" + employerCockpit + '\'' +
                '}';
    }
}
