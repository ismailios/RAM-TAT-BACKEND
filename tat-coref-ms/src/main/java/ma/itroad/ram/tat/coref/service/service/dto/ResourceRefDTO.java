package ma.itroad.ram.tat.coref.service.service.dto;

import java.io.Serializable;
import java.util.Objects;

import org.hibernate.annotations.DynamicUpdate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ma.itroad.ram.tat.coref.service.domain.UserRef;
import ma.itroad.ram.tat.coref.service.domain.enumeration.ResourceRoleEnum;

/**
 * A DTO for the {@link ma.itroad.ram.tat.coref.service.domain.ResourceRef} entity.
 */

@Getter
@Setter
@DynamicUpdate
@AllArgsConstructor
@NoArgsConstructor
public class ResourceRefDTO implements Serializable {

    private Long id;

    private String idResource;

    private String name;

    private String role;
    
    private UserRef userRef;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdResource() {
        return idResource;
    }

    public void setIdResource(String idResource) {
        this.idResource = idResource;
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
        if (!(o instanceof ResourceRefDTO)) {
            return false;
        }

        ResourceRefDTO resourceRefDTO = (ResourceRefDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, resourceRefDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ResourceRefDTO{" +
            "id=" + getId() +
            ", idResource='" + getIdResource() + "'" +
            ", name='" + getName() + "'" +
            ", role='" + getRole() + "'" +
            "}";
    }
}
