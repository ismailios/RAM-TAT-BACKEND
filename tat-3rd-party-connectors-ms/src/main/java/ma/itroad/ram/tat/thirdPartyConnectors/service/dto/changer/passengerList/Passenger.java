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
public class Passenger {

	
    @JsonProperty("@xsi:type") 
    private String xsiType;
    @JsonProperty("classe") 
    private String classe;
    @JsonProperty("firstName") 
    private String firstName;
    @JsonProperty("lastName") 
    private String lastName;
    @JsonProperty("pnr") 
    private String pnr;
    @JsonProperty("seat") 
    private String seat;
    @JsonProperty("secNumber") 
    private String secNumber;
    @JsonProperty("specialReq") 
    private Object specialReq;
    @JsonProperty("status") 
    private String status;
	
}
