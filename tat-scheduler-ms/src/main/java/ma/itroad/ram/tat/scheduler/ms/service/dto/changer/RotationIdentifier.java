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
public class RotationIdentifier implements Serializable {

    @JsonProperty("logicalNo")
    public String logicalNo;

    @JsonProperty("registration")
    public String registration;

    public String getLogicalNo() {
        return logicalNo;
    }

    public void setLogicalNo(String logicalNo) {
        this.logicalNo = logicalNo;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }
}
