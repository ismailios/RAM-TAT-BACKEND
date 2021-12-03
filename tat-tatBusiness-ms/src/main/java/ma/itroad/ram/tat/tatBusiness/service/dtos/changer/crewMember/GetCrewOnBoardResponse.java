package ma.itroad.ram.tat.tatBusiness.service.dtos.changer.crewMember;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetCrewOnBoardResponse {

	@JsonProperty("return")
	public Return retour;
}
