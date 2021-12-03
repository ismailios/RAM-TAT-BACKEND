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
public class InstantIdentifier implements Serializable {

    @JsonProperty("natKey")
    public NatKey natKey;

    @JsonProperty("surrogateKey")
    public SurrogateKey surrogateKey;

    @JsonProperty("oldNatKey")
    public  NatKey oldNatKey;

    public NatKey getNatKey() {
        return natKey;
    }

    public void setNatKey(NatKey natKey) {
        this.natKey = natKey;
    }

    public SurrogateKey getSurrogateKey() {
        return surrogateKey;
    }

    public void setSurrogateKey(SurrogateKey surrogateKey) {
        this.surrogateKey = surrogateKey;
    }

    public NatKey getOldNatKey() {
        return oldNatKey;
    }

    public void setOldNatKey(NatKey oldNatKey) {
        this.oldNatKey = oldNatKey;
    }
}
