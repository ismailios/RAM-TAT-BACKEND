package ma.itroad.ram.tat.thirdPartyConnectors.service.dto.changer.loadSheet;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LoadSheet {

	

	    @JsonProperty("DATE_ORIGIN") 
	    private String dATE_ORIGIN;
	    @JsonProperty("FLIGHT") 
	    private String fLIGHT;
	    @JsonProperty("ESCALE") 
	    private String eSCALE;
	    @JsonProperty("LOAD") 
	    private String lOAD;
	    @JsonProperty("MACZFW") 
	    private String mACZFW;
	    @JsonProperty("DATE") 
	    private String dATE;
	    @JsonProperty("TIME") 
	    private String tIME;
	    @JsonProperty("AGENT") 
	    private String aGENT;
	    @JsonProperty("VERSION") 
	    private String vERSION;
	}
	

