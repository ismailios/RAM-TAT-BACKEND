package ma.itroad.ram.tat.thirdPartyConnectors.service.dto.changer.crewMember;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

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
