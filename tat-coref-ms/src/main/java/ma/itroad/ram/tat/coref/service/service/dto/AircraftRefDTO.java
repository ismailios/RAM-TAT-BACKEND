package ma.itroad.ram.tat.coref.service.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link ma.itroad.ram.tat.coref.service.domain.AircraftRef} entity.
 */
public class AircraftRefDTO implements Serializable {

    private Long id;

    private String code;

    private AircraftTypeRefDTO aircraftTypeRef;

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

    public AircraftTypeRefDTO getAircraftTypeRef() {
        return aircraftTypeRef;
    }

    public void setAircraftTypeRef(AircraftTypeRefDTO aircraftTypeRef) {
        this.aircraftTypeRef = aircraftTypeRef;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AircraftRefDTO)) {
            return false;
        }

        AircraftRefDTO aircraftRefDTO = (AircraftRefDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, aircraftRefDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "AircraftRefDTO{" +
            "id=" + getId() +
            ", code='" + getCode() + "'" +
            ", aircraftTypeRef=" + getAircraftTypeRef() +
            "}";
    }
}
