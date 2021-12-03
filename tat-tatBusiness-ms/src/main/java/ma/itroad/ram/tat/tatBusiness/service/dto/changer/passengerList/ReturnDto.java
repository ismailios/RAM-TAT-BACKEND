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
public class ReturnDto {

	
	 @JsonProperty("@xsi:type") 
	 private String xsiType;
	 private int acceptedPtmIn;
	 private int acceptedPtmOut;
	 private int acceptedTotal;
	 private int boardedPtmIn;
	 private int boardedPtmOut;
	 private int boardedTotal;
	 private BoardingEndTime boardingEndTime;
	 private ExpectedBoardingTime expectedBoardingTime;
	 private int expectedInf;
	 private int expectedJ;
	 private int expectedPtmIn;
	 private int expectedPtmOut;
	 private int expectedTotal;
	 private int expectedY;
	 private PassengerListDto passengerList;
	 private int spclCre;
	 private Object spclCreDetail;
	 private int spclKid;
	 private Object spclKidDetail;
	 private int spclWch;
	 private Object spclWchDetail;
	
}
