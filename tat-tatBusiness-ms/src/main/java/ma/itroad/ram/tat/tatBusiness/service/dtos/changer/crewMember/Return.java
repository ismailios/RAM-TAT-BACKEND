package ma.itroad.ram.tat.tatBusiness.service.dtos.changer.crewMember;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Return {
	@JsonProperty("@xsi:type")
	public String xsiType;
	public List<CrewRoster> crewRoster;

}
