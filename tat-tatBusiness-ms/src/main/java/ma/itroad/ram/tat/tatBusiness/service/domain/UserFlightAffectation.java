package ma.itroad.ram.tat.tatBusiness.service.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@DynamicUpdate
@Entity
@Table(name="user_flight_affectations")
public class UserFlightAffectation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name="xsi_type")
    private String xsiType;

    @Column(name="CREWCAT")
    private String crewCat;

    @Column(name="DEP")
    private String dep;

    @Column(name="EMPNO")
    private long empNo;

    @Column(name="FLTNBR")
    private long fltNbr;

    @Column(name="ISPASSIVE")
    private int isPassive;

    @Column(name="STARTTIME")
    private LocalDateTime startTime;

    @Column(name="flight_natKey")
    private String flightNatKey="AT"+ fltNbr;  //AT8376-20211018-BOG


}
