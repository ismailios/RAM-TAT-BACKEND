package ma.itroad.ram.tat.tatBusiness.service.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@DynamicUpdate
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="onda")
public class OndaInfo {

	@Id
	@GeneratedValue
	private Long id;
	
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
