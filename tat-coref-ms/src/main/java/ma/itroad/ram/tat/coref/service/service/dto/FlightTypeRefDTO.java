package ma.itroad.ram.tat.coref.service.service.dto;

import java.io.Serializable;
import java.util.Objects;

import ma.itroad.ram.tat.coref.service.domain.enumeration.LegEnum;

/**
 * A DTO for the {@link ma.itroad.ram.tat.coref.service.domain.FlightTypeRef} entity.
 */
public class FlightTypeRefDTO implements Serializable {

    private Long id;

    private String code;

    private String label;

    private LegEnum leg;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public LegEnum getLeg() {
        return leg;
    }

    public void setLeg(LegEnum leg) {
        this.leg = leg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof FlightTypeRefDTO)) {
            return false;
        }

        FlightTypeRefDTO flightTypeRefDTO = (FlightTypeRefDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, flightTypeRefDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "FlightTypeRefDTO{" +
            "id=" + getId() +
            ", code='" + getCode() + "'" +
            ", label='" + getLabel() + "'" +
            ", leg='" + getLeg() + "'" +
            "}";
    }
}
