package ma.itroad.ram.tat.tatBusiness.service.dtos.changer;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LastUpdate implements Serializable {

    @JsonProperty("userId")
    public String userId;

    @JsonProperty("timestamp")
    public LocalDateTime timestamp;

    @JsonProperty("updateKey")
    public String updateKey;

    @JsonProperty("updateNo")
    public String updateNo;
}
