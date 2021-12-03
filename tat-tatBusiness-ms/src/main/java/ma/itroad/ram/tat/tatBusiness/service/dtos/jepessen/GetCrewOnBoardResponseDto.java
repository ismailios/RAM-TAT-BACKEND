package ma.itroad.ram.tat.tatBusiness.service.dtos.jepessen;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetCrewOnBoardResponseDto {

    @JsonProperty("return")
    public MemberFlightDto memberFlight;
}
