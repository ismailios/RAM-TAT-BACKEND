package ma.itroad.ram.tat.tatBusiness.service.dtos;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * A AirPortDto.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AirPortDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String shortName;

	private String name;

	private String country;

}
