package ma.itroad.ram.tat.coref.service.service.dto;

import java.io.Serializable;
import java.util.Objects;

import ma.itroad.ram.tat.coref.service.domain.enumeration.TatTypeEnum;

/**
 * A DTO for the {@link ma.itroad.ram.tat.coref.service.domain.TatType} entity.
 */
public class TatTypeDTO implements Serializable {

    private Long id;

    private String tat;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTat() {
        return tat;
    }

    public void setTat(String tat) {
        this.tat = tat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof TatTypeDTO)) {
            return false;
        }

        TatTypeDTO tatTypeDTO = (TatTypeDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, tatTypeDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "TatTypeDTO{" +
            "id=" + getId() +
            ", tat='" + getTat() + "'" +
            "}";
    }
}
