package ma.itroad.ram.tat.tatBusiness.ms.service.dto.changer.onda;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ListeVols {

	 @JsonProperty("Vol") 
    public List<OndaInfoDto> vol;
	
	
}
