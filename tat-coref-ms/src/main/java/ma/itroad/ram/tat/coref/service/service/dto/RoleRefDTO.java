package ma.itroad.ram.tat.coref.service.service.dto;

import java.io.Serializable;
import java.util.Objects;
import javax.validation.constraints.*;

import ma.itroad.ram.tat.coref.service.domain.enumeration.RoleEnum;

/**
 * A DTO for the {@link ma.itroad.ram.tat.coref.service.domain.RoleRef} entity.
 */
public class RoleRefDTO implements Serializable {

    private Long id;

    @NotNull
    private String taskName;

    private String scope;

    private RoleEnum role;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public RoleEnum getRole() {
        return role;
    }

    public void setRole(RoleEnum role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RoleRefDTO)) {
            return false;
        }

        RoleRefDTO roleRefDTO = (RoleRefDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, roleRefDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "RoleRefDTO{" +
            "id=" + getId() +
            ", taskName='" + getTaskName() + "'" +
            ", scope='" + getScope() + "'" +
            ", role='" + getRole() + "'" +
            "}";
    }
}
