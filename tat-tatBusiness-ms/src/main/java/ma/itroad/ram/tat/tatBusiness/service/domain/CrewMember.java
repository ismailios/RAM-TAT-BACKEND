package ma.itroad.ram.tat.tatBusiness.service.domain;

import javax.persistence.*;

import ma.itroad.ram.tat.tatBusiness.service.domain.enums.PhaseEnum;
import org.hibernate.annotations.DynamicUpdate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

import static ma.itroad.ram.tat.tatBusiness.service.domain.enums.PhaseEnum.ARRIVEE;
import static ma.itroad.ram.tat.tatBusiness.service.domain.enums.PhaseEnum.DEPART;

@Getter
@Setter
@DynamicUpdate
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "crew_member")
public class CrewMember {


	@Transient
	private static String LOCALAIRPORT="CMN";

	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "xsi_type")
	private String xsiType;

	@Column(name = "CREWCAT")
	private String crewCat;

	@Column(name = "DEP")
	private String dep;

	@Column(name = "EMPNO")
	private int empNo;

	@Column(name = "FLTNBR")
	private int fltNbr;

	@Column(name = "ISPASSIVE")
	private int isPassive;

	@Column(name = "STARTTIME")
	private String startTime;

	//@Column(name = "flight_natKey")
	//private String flightNatKey = "AT" + fltNbr; // AT8376-20211018-BOG


	@Column(name="phase")
	private String phase;

	@Column(name="type")
	private String type;
	
	
	
	@ManyToOne
	private Tat tat;

	public CrewMember(String crewCat, String dep, int empNo, int fltNbr, int isPassive, String startTime) {
		super();
		this.crewCat = crewCat;
		this.dep = dep;
		this.empNo = empNo;
		this.fltNbr = fltNbr;
		this.isPassive = isPassive;
		this.startTime = startTime;
		if(dep.equals(LOCALAIRPORT))
			this.phase= DEPART.getValue();
		else
			this.phase= ARRIVEE.getValue();
	}
	
	

	public CrewMember(String crewCat, String dep, int empNo, int fltNbr, int isPassive, String startTime, Tat tat) {
		super();
		this.crewCat = crewCat;
		this.dep = dep;
		this.empNo = empNo;
		this.fltNbr = fltNbr;
		this.isPassive = isPassive;
		this.startTime = startTime;
		this.tat = tat;
		if(dep.equals(LOCALAIRPORT))
			this.phase= DEPART.getValue();
		else
			this.phase= ARRIVEE.getValue();
	}



	public CrewMember(String crewCat, String dep, int empNo, int fltNbr, int isPassive, String startTime, String type,
			Tat tat) {
		super();
		this.crewCat = crewCat;
		this.dep = dep;
		this.empNo = empNo;
		this.fltNbr = fltNbr;
		this.isPassive = isPassive;
		this.startTime = startTime;
		this.type = type;
		this.tat = tat;
		if(dep.equals(LOCALAIRPORT))
			this.phase= DEPART.getValue();
		else
			this.phase= ARRIVEE.getValue();
	}


}
