package ma.itroad.ram.tat.tatBusiness.ms.service.dto.changer.onda;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OndaInfoDto {

	
	
	@JsonProperty("SENS") 
	private String sENS;
	@JsonProperty("VOLNO")
	private String vOLNO;
	@JsonProperty("PROV_DEST")
	private String pROV_DEST;
	@JsonProperty("ESCALES")
	private String eSCALES;
	@JsonProperty("PKG")
	private String pKG;
	@JsonProperty("TYPEMAT")
	private String tYPEMAT;
	@JsonProperty("IMMAT")
	private String iMMAT;
	@JsonProperty("DATEMVT")
	private String dATEMVT;
	@JsonProperty("HEUREMVT")
	private String hEUREMVT;
	@JsonProperty("ESTIME")
	private String eSTIME;
	@JsonProperty("HALL")
	private String hALL;
	@JsonProperty("ETAT")
	private String eTAT;
	@JsonProperty("TYPEVOL")
	private String tYPEVOL;
	@JsonProperty("TAPIS")
	private String tAPIS;
	@JsonProperty("PORTE")
	private String pORTE;

}
