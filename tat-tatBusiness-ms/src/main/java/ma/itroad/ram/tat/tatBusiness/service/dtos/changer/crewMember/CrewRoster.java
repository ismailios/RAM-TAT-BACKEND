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
public class CrewRoster {

	@JsonProperty("@xsi:type")
	public String xsiType;
	@JsonProperty("CREWCAT")
	public String cREWCAT;
	@JsonProperty("DEP")
	public String dEP;
	@JsonProperty("EMPNO")
	public int eMPNO;
	@JsonProperty("FLTNBR")
	public int fLTNBR;
	@JsonProperty("ISPASSIVE")
	public int iSPASSIVE;
	@JsonProperty("STARTTIME")
	public String sTARTTIME;
}
