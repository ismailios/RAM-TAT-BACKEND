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
public class SurrogateKey implements Serializable {

    @JsonProperty("legNo")
    public String legNo;

    @JsonProperty("whatIf")
    public String whatIf;

    public String getLegNo() {
        return legNo;
    }

    public void setLegNo(String legNo) {
        this.legNo = legNo;
    }

    public String getWhatIf() {
        return whatIf;
    }

    public void setWhatIf(String whatIf) {
        this.whatIf = whatIf;
    }
}
