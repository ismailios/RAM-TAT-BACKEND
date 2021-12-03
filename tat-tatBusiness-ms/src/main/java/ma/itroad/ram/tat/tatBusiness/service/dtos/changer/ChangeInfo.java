package ma.itroad.ram.tat.tatBusiness.service.dtos.changer;

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

}
