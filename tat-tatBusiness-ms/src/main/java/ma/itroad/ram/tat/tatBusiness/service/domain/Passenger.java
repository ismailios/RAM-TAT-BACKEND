package ma.itroad.ram.tat.tatBusiness.service.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ma.itroad.ram.tat.tatBusiness.service.dto.changer.passengerList.SpecialReq;


@Getter
@Setter
@DynamicUpdate
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="passenger")
public class Passenger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("@xsi:type") 
    private String xsiType;
    private String classe;
    private String firstName;
    private String lastName;
    private String pnr;
    private String seat;
    private String secNumber;
    private String specialReq;
    private String status;
    
	@ManyToOne
	private PassengerInfo passengerInfo;
	
	
}
