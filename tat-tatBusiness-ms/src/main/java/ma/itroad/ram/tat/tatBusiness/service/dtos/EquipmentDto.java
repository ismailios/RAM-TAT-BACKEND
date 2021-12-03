package ma.itroad.ram.tat.tatBusiness.service.dtos;

import java.io.Serializable;

import org.hibernate.annotations.DynamicUpdate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@DynamicUpdate
@AllArgsConstructor
@NoArgsConstructor
public class EquipmentDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String idMaterial;

	private String code;

	private String name;

}
