package ma.itroad.ram.tat.tatBusiness.service.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
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
@Entity
@Table(name="passengerInfo")
public class PassengerInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	
	 @JsonProperty("@xsi:type") 
	 private String xsiType;
	 private int acceptedPtmIn;
	 private int acceptedPtmOut;
	 private int acceptedTotal;
	 private int boardedPtmIn;
	 private int boardedPtmOut;
	 private int boardedTotal;

	 private int expectedInf;
	 private int expectedJ;
	 private int expectedPtmIn;
	 private int expectedPtmOut;
	 private int expectedTotal;
	 private int expectedY;
	 
     @OneToMany(mappedBy = "passengerInfo", cascade = CascadeType.ALL)
     private Set<Passenger> passengers = new HashSet<>();
     
     @OneToOne
     @JoinColumn (name="tat")
     private Tat tat;
	 

	 private int spclCre;
	 private String spclCreDetail;
	 private int spclKid;
	 private String spclKidDetail;
	 private int spclWch;
	 private String spclWchDetail;

	public String getSpclWchDetail() {
		return spclWchDetail;
	}

	public void setSpclWchDetail(String spclWchDetail) {
		this.spclWchDetail = spclWchDetail;
	}

	public String getSpclCreDetail() {
		return spclCreDetail;
	}

	public void setSpclCreDetail(String spclCreDetail) {
		this.spclCreDetail = spclCreDetail;
	}

	public String getSpclKidDetail() {
		return spclKidDetail;
	}

	public void setSpclKidDetail(String spclKidDetail) {
		this.spclKidDetail = spclKidDetail;
	}
}
