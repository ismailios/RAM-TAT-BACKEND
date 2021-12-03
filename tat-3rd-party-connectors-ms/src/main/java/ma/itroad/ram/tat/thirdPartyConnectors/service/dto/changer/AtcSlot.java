package ma.itroad.ram.tat.thirdPartyConnectors.service.dto.changer;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AtcSlot  implements Serializable {


    @JsonProperty("callsign")
    public String callsign;

    @JsonProperty("ctot")
    public LocalDateTime ctot;

    @JsonProperty("taxiOutTime")
    public String taxiOutTime;

    public String getCallsign() {
        return callsign;
    }

    public void setCallsign(String callsign) {
        this.callsign = callsign;
    }

    public LocalDateTime getCtot() {
        return ctot;
    }

    public void setCtot(LocalDateTime ctot) {
        this.ctot = ctot;
    }

    public String getTaxiOutTime() {
        return taxiOutTime;
    }

    public void setTaxiOutTime(String taxiOutTime) {
        this.taxiOutTime = taxiOutTime;
    }
}
