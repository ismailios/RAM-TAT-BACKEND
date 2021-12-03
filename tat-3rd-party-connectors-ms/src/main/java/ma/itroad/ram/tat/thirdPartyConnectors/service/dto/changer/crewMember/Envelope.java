package ma.itroad.ram.tat.thirdPartyConnectors.service.dto.changer.crewMember;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Envelope {

	
    @JsonProperty("Header") 
    public Object header;
    @JsonProperty("Body") 
    public Body body;
}
