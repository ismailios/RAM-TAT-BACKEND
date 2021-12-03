package ma.itroad.ram.tat.scheduler.ms.service.dto.changer;

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
public class FlightNumber implements Serializable {

    @JsonProperty("fnCarrier")
    public String fnCarrier;

    @JsonProperty("fnNumber")
    public String fnNumber;

    public String getFnCarrier() {
        return fnCarrier;
    }

    public void setFnCarrier(String fnCarrier) {
        this.fnCarrier = fnCarrier;
    }

    public String getFnNumber() {
        return fnNumber;
    }

    public void setFnNumber(String fnNumber) {
        this.fnNumber = fnNumber;
    }
}