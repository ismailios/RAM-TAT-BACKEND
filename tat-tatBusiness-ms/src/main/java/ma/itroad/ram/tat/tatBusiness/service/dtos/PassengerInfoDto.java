package ma.itroad.ram.tat.tatBusiness.service.dtos;

import java.util.Set;

import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ma.itroad.ram.tat.tatBusiness.service.dto.changer.passengerList.BoardingEndTime;
import ma.itroad.ram.tat.tatBusiness.service.dto.changer.passengerList.ExpectedBoardingTime;
import ma.itroad.ram.tat.tatBusiness.service.dto.changer.passengerList.PassengerDto;
import ma.itroad.ram.tat.tatBusiness.service.dto.changer.passengerList.PassengerListDto;


@Getter
@Setter
@DynamicUpdate
@AllArgsConstructor
@NoArgsConstructor
public class PassengerInfoDto {

	
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
	 private Set<PassengerDto> passengers;
	 private int spclCre;
	 private String spclCreDetail;
	 private int spclKid;
	 private String spclKidDetail;
	 private int spclWch;
	 private String spclWchDetail;
}
