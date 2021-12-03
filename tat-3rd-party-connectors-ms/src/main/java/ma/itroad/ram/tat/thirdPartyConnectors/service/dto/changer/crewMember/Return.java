package ma.itroad.ram.tat.thirdPartyConnectors.service.dto.changer.crewMember;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Return {
    @JsonProperty("@xsi:type") 
    public String xsiType;
    public List<CrewRoster> crewRoster;
	
}
