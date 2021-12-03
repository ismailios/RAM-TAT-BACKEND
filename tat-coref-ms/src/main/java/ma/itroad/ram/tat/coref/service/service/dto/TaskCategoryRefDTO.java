package ma.itroad.ram.tat.coref.service.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link ma.itroad.ram.tat.coref.service.domain.TaskCategoryRef} entity.
 */
public class TaskCategoryRefDTO implements Serializable {

    private Long id;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        if (!(o instanceof TaskCategoryRefDTO)) {
            return false;
        }

        TaskCategoryRefDTO taskCategoryRefDTO = (TaskCategoryRefDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, taskCategoryRefDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "TaskCategoryRefDTO{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            "}";
    }
}
