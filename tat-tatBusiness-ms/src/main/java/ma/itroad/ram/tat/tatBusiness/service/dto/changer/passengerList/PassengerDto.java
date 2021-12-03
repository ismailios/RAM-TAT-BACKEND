package ma.itroad.ram.tat.tatBusiness.service.dto.changer.passengerList;

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

public class PassengerDto {

	
    @JsonProperty("@xsi:type") 
    private String xsiType;
    private String classe;
    private String firstName;
    private String lastName;
    private String pnr;
    private String seat;
    private String secNumber;
    private Object specialReq;
    private String status;
	
}
