package ma.itroad.ram.tat.coref.service.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link ma.itroad.ram.tat.coref.service.domain.DelayReasonRef} entity.
 */
public class DelayReasonRefDTO implements Serializable {

    private Long id;

    private String code;

    private String name;

    private String description;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DelayReasonRefDTO)) {
            return false;
        }

        DelayReasonRefDTO delayReasonRefDTO = (DelayReasonRefDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, delayReasonRefDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "DelayReasonRefDTO{" +
            "id=" + getId() +
            ", code='" + getCode() + "'" +
            ", name='" + getName() + "'" +
            ", description=" + getDescription() +
            "}";
    }
}
