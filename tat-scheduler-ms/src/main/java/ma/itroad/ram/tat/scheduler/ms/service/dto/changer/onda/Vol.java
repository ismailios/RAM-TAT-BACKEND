package ma.itroad.ram.tat.scheduler.ms.service.dto.changer.onda;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Vol {

    @JsonProperty("SENS") 
    public String sENS;
    @JsonProperty("VOLNO") 
    public String vOLNO;
    @JsonProperty("PROV_DEST") 
    public String pROV_DEST;
    @JsonProperty("ESCALES") 
    public String eSCALES;
    @JsonProperty("PKG") 
    public String pKG;
    @JsonProperty("TYPEMAT") 
    public String tYPEMAT;
    @JsonProperty("IMMAT") 
    public String iMMAT;
    @JsonProperty("DATEMVT") 
    public String dATEMVT;
    @JsonProperty("HEUREMVT") 
    public String hEUREMVT;
    @JsonProperty("ESTIME") 
    public String eSTIME;
    @JsonProperty("HALL") 
    public String hALL;
    @JsonProperty("ETAT") 
    public String eTAT;
    @JsonProperty("TYPEVOL") 
    public String tYPEVOL;
    @JsonProperty("TAPIS") 
    public String tAPIS;
    @JsonProperty("PORTE") 
    public String pORTE;
	
}
