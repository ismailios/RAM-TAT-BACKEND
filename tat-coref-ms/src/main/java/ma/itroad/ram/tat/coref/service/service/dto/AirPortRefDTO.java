package ma.itroad.ram.tat.coref.service.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link ma.itroad.ram.tat.coref.service.domain.AirPortRef} entity.
 */
public class AirPortRefDTO implements Serializable {

    private Long id;

    private String shortName;

    private String name;

    private String country;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AirPortRefDTO)) {
            return false;
        }

        AirPortRefDTO airPortRefDTO = (AirPortRefDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, airPortRefDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "AirPortRefDTO{" +
            "id=" + getId() +
            ", shortName='" + getShortName() + "'" +
            ", name='" + getName() + "'" +
            ", country='" + getCountry() + "'" +
            "}";
    }
}
