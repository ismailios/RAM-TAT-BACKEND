package ma.itroad.ram.tat.thirdPartyConnectors.service.dto.changer;


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

    public String getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(String departureAirport) {
        this.departureAirport = departureAirport;
    }

    public LocalDateTime getDeparture() {
        return departure;
    }

    public void setDeparture(LocalDateTime departure) {
        this.departure = departure;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(String arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    public LocalDateTime getArrival() {
        return arrival;
    }

    public void setArrival(LocalDateTime arrival) {
        this.arrival = arrival;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getAircraftOwner() {
        return aircraftOwner;
    }

    public void setAircraftOwner(String aircraftOwner) {
        this.aircraftOwner = aircraftOwner;
    }

    public String getAircraftSubtype() {
        return aircraftSubtype;
    }

    public void setAircraftSubtype(String aircraftSubtype) {
        this.aircraftSubtype = aircraftSubtype;
    }

    public String getAircraftConfiguration() {
        return aircraftConfiguration;
    }

    public void setAircraftConfiguration(String aircraftConfiguration) {
        this.aircraftConfiguration = aircraftConfiguration;
    }

    public RotationIdentifier getRotationIdentifier() {
        return rotationIdentifier;
    }

    public void setRotationIdentifier(RotationIdentifier rotationIdentifier) {
        this.rotationIdentifier = rotationIdentifier;
    }

    public String getEmployerCabin() {
        return employerCabin;
    }

    public void setEmployerCabin(String employerCabin) {
        this.employerCabin = employerCabin;
    }

    public String getEmployerCockpit() {
        return employerCockpit;
    }

    public void setEmployerCockpit(String employerCockpit) {
        this.employerCockpit = employerCockpit;
    }
}
