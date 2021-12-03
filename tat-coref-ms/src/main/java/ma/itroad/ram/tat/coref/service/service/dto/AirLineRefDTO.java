package ma.itroad.ram.tat.coref.service.service.dto;

import java.io.Serializable;
import java.util.Objects;



/**
 * A DTO for the {@link ma.itroad.ram.tat.coref.service.domain.AirLineRef} entity.
 */


public class AirLineRefDTO implements Serializable {

    private Long id;

    private String codeIata;

    private String codeOaci;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodeIata() {
        return codeIata;
    }

    public void setCodeIata(String codeIata) {
        this.codeIata = codeIata;
    }

    public String getCodeOaci() {
        return codeOaci;
    }

    public void setCodeOaci(String codeOaci) {
        this.codeOaci = codeOaci;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AirLineRefDTO)) {
            return false;
        }

        AirLineRefDTO airLineRefDTO = (AirLineRefDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, airLineRefDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "AirLineRefDTO{" +
            "id=" + getId() +
            ", codeIata='" + getCodeIata() + "'" +
            ", codeOaci='" + getCodeOaci() + "'" +
            ", name='" + getName() + "'" +
            "}";
    }
}
