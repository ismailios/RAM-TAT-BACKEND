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
public class InstantIdentifier implements Serializable {

    @JsonProperty("natKey")
    public NatKey natKey;

    @JsonProperty("surrogateKey")
    public SurrogateKey surrogateKey;

    @JsonProperty("oldNatKey")
    public  NatKey oldNatKey;
}
