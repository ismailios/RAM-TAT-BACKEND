package ma.itroad.ram.tat.scheduler.ms.service.dto.changer;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NatKey {

    @JsonProperty("flight")
    public FlightNumber flight;

    @JsonProperty("dayOfOrigin")
    public String dayOfOrigin;

    @JsonProperty("depApSched")
    public String depApSched;

    public FlightNumber getFlight() {
        return flight;
    }

    public void setFlight(FlightNumber flight) {
        this.flight = flight;
    }

    public String getDayOfOrigin() {
        return dayOfOrigin;
    }

    public void setDayOfOrigin(String dayOfOrigin) {
        this.dayOfOrigin = dayOfOrigin;
    }

    public String getDepApSched() {
        return depApSched;
    }

    public void setDepApSched(String depApSched) {
        this.depApSched = depApSched;
    }
}