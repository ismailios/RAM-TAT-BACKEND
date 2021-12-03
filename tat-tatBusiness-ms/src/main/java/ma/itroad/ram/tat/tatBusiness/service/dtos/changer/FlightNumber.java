package ma.itroad.ram.tat.tatBusiness.service.dtos.changer;


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
public class FlightNumber implements Serializable {

    @JsonProperty("fnCarrier")
    public String fnCarrier;

    @JsonProperty("fnNumber")
    public String fnNumber;
}
