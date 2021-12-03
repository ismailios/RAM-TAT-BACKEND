package ma.itroad.ram.tat.coref.service.service.dto;

import java.io.Serializable;
import java.util.Objects;
import javax.validation.constraints.*;

/**
 * A DTO for the {@link ma.itroad.ram.tat.coref.service.domain.EquipmentRef} entity.
 */
public class EquipmentRefDTO implements Serializable {

    private Long id;

    private String idMaterial;

    @NotNull
    private String code;

    @NotNull
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(String idMaterial) {
        this.idMaterial = idMaterial;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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
        if (!(o instanceof EquipmentRefDTO)) {
            return false;
        }

        EquipmentRefDTO equipmentRefDTO = (EquipmentRefDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, equipmentRefDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "EquipmentRefDTO{" +
            "id=" + getId() +
            ", idMaterial='" + getIdMaterial() + "'" +
            ", code='" + getCode() + "'" +
            ", name='" + getName() + "'" +
            "}";
    }
}
