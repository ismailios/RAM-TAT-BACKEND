package ma.itroad.ram.tat.thirdPartyConnectors.service.dto.changer.passengerList;

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
public class PassengerList {

	  @JsonProperty("@xsi:type") 
	  private String xsiType;
	  
	  @JsonProperty("passengers") 
	  private List<Passenger> passengers;
}
