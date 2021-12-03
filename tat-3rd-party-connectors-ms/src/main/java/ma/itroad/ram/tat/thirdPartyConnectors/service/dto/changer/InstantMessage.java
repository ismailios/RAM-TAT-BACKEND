package ma.itroad.ram.tat.thirdPartyConnectors.service.dto.changer;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InstantMessage {

    @JsonProperty("legDetail")
    public LegDetail legDetail;

    public LegDetail getLegDetail() {
        return legDetail;
    }

    public void setLegDetail(LegDetail legDetail) {
        this.legDetail = legDetail;
    }


}
