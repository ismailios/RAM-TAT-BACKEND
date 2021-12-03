package ma.itroad.ram.tat.scheduler.ms.service.dto.changer.sitatx;

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
public class RootSitatx {

	@JsonProperty("sitatx")
	private Sitatx sitatx;

}
