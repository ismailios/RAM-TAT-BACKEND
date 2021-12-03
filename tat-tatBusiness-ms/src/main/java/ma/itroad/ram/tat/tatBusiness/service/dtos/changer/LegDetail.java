package ma.itroad.ram.tat.tatBusiness.service.dtos.changer;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LegDetail {

    @JsonProperty("identifier")
    public InstantIdentifier identifier;

    @JsonProperty("state")
    public String state;

    @JsonProperty("misc")
    public String misc;

    @JsonProperty("changeInfo")
    public ChangeInfo changeInfo;

    @JsonProperty("schedule")
    public Schedule schedule;

    @JsonProperty("performance")
    public Performance performance;

    @JsonProperty("lastUpdate")
    public LastUpdate lastUpdate;

    @JsonProperty("actuals")
    public Actuals actuals;

    @JsonProperty("atcSlot")
    public AtcSlot atcSlot;
}
