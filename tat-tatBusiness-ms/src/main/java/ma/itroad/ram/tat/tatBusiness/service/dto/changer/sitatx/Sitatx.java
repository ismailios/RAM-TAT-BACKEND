package ma.itroad.ram.tat.tatBusiness.service.dto.changer.sitatx;

import java.util.List;

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
public class Sitatx {

	@JsonProperty("flights")
	private List<FlightSitatxDto> flights;
}
