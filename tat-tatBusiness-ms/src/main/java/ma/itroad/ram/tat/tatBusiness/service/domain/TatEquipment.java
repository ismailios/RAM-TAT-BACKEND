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
@Table(name="tatId_equipmentId")
public class TatEquipment {

	@Id
	@GeneratedValue
	private Long id;
	
	
	@Column(name = "tat_id")
	private Long tatId;
	
	@Column(name = "equipment_id")
	private Long equipmentId;
}
