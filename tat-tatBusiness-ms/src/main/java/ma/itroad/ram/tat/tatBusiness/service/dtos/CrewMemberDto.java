package ma.itroad.ram.tat.tatBusiness.service.dtos;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.DynamicUpdate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ma.itroad.ram.tat.tatBusiness.service.domain.Tat;


@Getter
@Setter
@DynamicUpdate
@AllArgsConstructor
@NoArgsConstructor
public class CrewMemberDto {

	private Long id;

	private String xsiType;

	private String crewCat;

	private String dep;

	private long empNo;

	private long fltNbr;

	private int isPassive;

	private String startTime;

	private String flightNatKey = "AT" + fltNbr; // AT8376-20211018-BOG
	
	private String type;

	private Tat tat;

}
