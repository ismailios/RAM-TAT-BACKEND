package ma.itroad.ram.tat.scheduler.ms.service.dto.changer;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChangeInfo implements Serializable {

    @JsonProperty("changeReason")
    public List<String> changeReason;

    @JsonProperty("asmActionIdentifier")
    public List<String> asmActionIdentifier;

    public List<String> getChangeReason() {
        return changeReason;
    }

    public void setChangeReason(List<String> changeReason) {
        this.changeReason = changeReason;
    }

    public List<String> getAsmActionIdentifier() {
        return asmActionIdentifier;
    }

    public void setAsmActionIdentifier(List<String> asmActionIdentifier) {
        this.asmActionIdentifier = asmActionIdentifier;
    }
}