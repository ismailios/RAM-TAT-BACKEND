package ma.itroad.ram.tat.tatBusiness.service.dtos.jepessen;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MemberFlightDto {

    @JsonProperty("@xsi:type")
    private String xsiType;

    @JsonProperty("CREWCAT")
    private String crewCat;

    @JsonProperty("DEP")
    private String dep;

    @JsonProperty("EMPNO")
    private long empNo;

    @JsonProperty("FLTNBR")
    private long fltNbr;

    @JsonProperty("ISPASSIVE")
    private int isPassive;

    @JsonProperty("STARTTIME")
    private LocalDateTime startTime;

}
