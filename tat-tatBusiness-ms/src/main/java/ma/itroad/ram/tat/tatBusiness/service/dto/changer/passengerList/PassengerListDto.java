package ma.itroad.ram.tat.tatBusiness.service.dto.changer.passengerList;

import java.util.List;
import java.util.Set;

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
public class PassengerListDto {

	  @JsonProperty("@xsi:type") 
	  private String xsiType;
	  private Set<PassengerDto> passengers;
}
