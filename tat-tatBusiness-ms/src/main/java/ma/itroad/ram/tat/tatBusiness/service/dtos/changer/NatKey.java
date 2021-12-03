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
public class NatKey {

    @JsonProperty("flight")
    public FlightNumber flight;

    @JsonProperty("dayOfOrigin")
    public String dayOfOrigin;

    @JsonProperty("depApSched")
    public String depApSched;


}
