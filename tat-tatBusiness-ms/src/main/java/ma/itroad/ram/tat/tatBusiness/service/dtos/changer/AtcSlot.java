package ma.itroad.ram.tat.tatBusiness.service.dtos.changer;

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

}
