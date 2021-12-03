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
public class Return {

	
	 @JsonProperty("@xsi:type") 
	 private String xsiType;
	 
	 @JsonProperty("acceptedPtmIn") 
	 private int acceptedPtmIn;
	 @JsonProperty("acceptedPtmOut") 
	 private int acceptedPtmOut;
	 @JsonProperty("acceptedTotal") 
	 private int acceptedTotal;
	 @JsonProperty("boardedPtmIn") 
	 private int boardedPtmIn;
	 @JsonProperty("boardedPtmOut") 
	 private int boardedPtmOut;
	 @JsonProperty("boardedTotal") 
	 private int boardedTotal;
	 @JsonProperty("boardingEndTime") 
	 private BoardingEndTime boardingEndTime;
	 @JsonProperty("expectedBoardingTime") 
	 private ExpectedBoardingTime expectedBoardingTime;
	 @JsonProperty("expectedInf") 
	 private int expectedInf;
	 @JsonProperty("expectedJ") 
	 private int expectedJ;
	 @JsonProperty("expectedPtmIn") 
	 private int expectedPtmIn;
	 @JsonProperty("expectedPtmOut") 
	 private int expectedPtmOut;
	 @JsonProperty("expectedTotal") 
	 private int expectedTotal;
	 @JsonProperty("expectedY") 
	 private int expectedY;
	 @JsonProperty("passengerList") 
	 private PassengerList passengerList;
	 @JsonProperty("spclCre") 
	 private int spclCre;
	 @JsonProperty("spclCreDetail") 
	 private Object spclCreDetail;
	 @JsonProperty("spclKid") 
	 private int spclKid;
	 @JsonProperty("spclKidDetail") 
	 private Object spclKidDetail;
	 @JsonProperty("spclWch") 
	 private int spclWch;
	 @JsonProperty("spclWchDetail") 
	 private Object spclWchDetail;
	
}
