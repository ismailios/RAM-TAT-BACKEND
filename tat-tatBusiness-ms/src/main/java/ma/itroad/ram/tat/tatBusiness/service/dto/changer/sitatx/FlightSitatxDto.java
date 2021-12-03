package ma.itroad.ram.tat.tatBusiness.service.dto.changer.sitatx;

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
public class FlightSitatxDto {

	@JsonProperty("ARCID")
	private String flightNo;
	@JsonProperty("ADEP")
	private String departure;
	@JsonProperty("EOBD")
	private String dateOfOrigin;
	@JsonProperty("ATFM")
	private String message;

}
