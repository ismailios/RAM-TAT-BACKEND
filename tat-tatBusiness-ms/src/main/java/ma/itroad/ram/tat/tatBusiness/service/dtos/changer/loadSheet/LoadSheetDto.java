package ma.itroad.ram.tat.tatBusiness.service.dtos.changer.loadSheet;

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
public class LoadSheetDto {


    @JsonProperty("DATE_ORIGIN") 
    private String dATEORIGIN;
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
