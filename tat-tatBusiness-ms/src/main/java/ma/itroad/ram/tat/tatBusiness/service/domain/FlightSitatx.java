package ma.itroad.ram.tat.tatBusiness.service.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

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
@Table(name="sitatx")
public class FlightSitatx {

	@Id
	@GeneratedValue
	private Long id;
	
	@JsonProperty("ARCID")
	private String flightNo;
	@JsonProperty("ADEP")
	private String departure;
	@JsonProperty("EOBD")
	private String dateOfOrigin;
	@JsonProperty("ATFM")
	@Column(columnDefinition="TEXT")
	private String message;

}
