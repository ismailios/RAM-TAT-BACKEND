package ma.itroad.ram.tat.thirdPartyConnectors.service.dto.changer;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Performance implements Serializable {

    @JsonProperty("flightHours")
    public FlightHours flightHours;

    @JsonProperty("cycles")
    public String cycles;

    public FlightHours getFlightHours() {
        return flightHours;
    }

    public void setFlightHours(FlightHours flightHours) {
        this.flightHours = flightHours;
    }

    public String getCycles() {
        return cycles;
    }

    public void setCycles(String cycles) {
        this.cycles = cycles;
    }
}
