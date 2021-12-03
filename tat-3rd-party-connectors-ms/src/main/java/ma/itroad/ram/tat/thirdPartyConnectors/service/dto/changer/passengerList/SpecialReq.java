package ma.itroad.ram.tat.thirdPartyConnectors.service.dto.changer.passengerList;

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
public class SpecialReq {

	@JsonProperty("@xsi:nil")
    private String xsiNil;
	
}
