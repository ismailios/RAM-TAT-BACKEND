package ma.itroad.ram.tat.scheduler.ms.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NatKeyDto {

	private Long id;
    @JsonProperty("fnCarrier")
    private String fnCarrier;

    @JsonProperty("fnNumber")
    private long  fnNumber;

    @JsonProperty("dayOfOrigin")
    private String dayOfOrigin;

    @JsonProperty("depApSched")
    private String depApSched;

    @Override
    public String toString() {
        return "" + fnCarrier + + fnNumber + "-" + dayOfOrigin + "-" +  depApSched ;
    }

}
