package ma.itroad.ram.tat.tatBusiness.service.dtos.changer;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Actuals implements Serializable {

    @JsonProperty("estimatedTimeArrival")
    public LocalDateTime estimatedTimeArrival;

    @JsonProperty("estimatedTimeDeparture")
    public LocalDateTime estimatedTimeDeparture;

    @JsonProperty("adviseTime")
    public LocalDateTime adviseTime;

    @JsonProperty("offblockTime")
    public OffblockTime offblockTime;

    @JsonProperty("airborneTime")
    public AirborneTime airborneTime;

    @JsonProperty("landingTime")
    public LandingTime landingTime;

    @JsonProperty("onblockTime")
    public OnblockTime onblockTime;

    @JsonProperty("delay")
    public List<DelayDto> delay;


}
