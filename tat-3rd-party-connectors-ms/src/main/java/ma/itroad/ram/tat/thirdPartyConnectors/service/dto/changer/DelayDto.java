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
public class DelayDto implements Serializable {

    @JsonProperty("delayCode")
    public String delayCode;

    @JsonProperty("delayTime")
    public String delayTime;

    public String getDelayCode() {
        return delayCode;
    }

    public void setDelayCode(String delayCode) {
        this.delayCode = delayCode;
    }

    public String getDelayTime() {
        return delayTime;
    }

    public void setDelayTime(String delayTime) {
        this.delayTime = delayTime;
    }
}
