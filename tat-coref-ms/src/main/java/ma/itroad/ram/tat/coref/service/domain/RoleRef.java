package ma.itroad.ram.tat.coref.service.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import ma.itroad.ram.tat.coref.service.domain.enumeration.RoleEnum;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A RoleRef.
 */
@Entity
@Table(name = "role_ref")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class RoleRef implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "task_name", nullable = false)
    private String taskName;

    @Column(name = "scope")
    private String scope;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private RoleEnum role;

    @ManyToMany(mappedBy = "roles")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = { "refFlightType", "tatTypes", "delayReasons", "roles", "standardTasks" }, allowSetters = true)
    private Set<TaskRef> tasks = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RoleRef id(Long id) {
        this.id = id;
        return this;
    }

    public String getTaskName() {
        return this.taskName;
    }

    public RoleRef taskName(String taskName) {
        this.taskName = taskName;
        return this;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getScope() {
        return this.scope;
    }

    public RoleRef scope(String scope) {
        this.scope = scope;
        return this;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public RoleEnum getRole() {
        return this.role;
    }

    public RoleRef role(RoleEnum role) {
        this.role = role;
        return this;
    }

    public void setRole(RoleEnum role) {
        this.role = role;
    }

    public Set<TaskRef> getTasks() {
        return this.tasks;
    }

    public RoleRef tasks(Set<TaskRef> taskRefs) {
        this.setTasks(taskRefs);
        return this;
    }

    public RoleRef addTask(TaskRef taskRef) {
        this.tasks.add(taskRef);
        taskRef.getRoles().add(this);
        return this;
    }

    public RoleRef removeTask(TaskRef taskRef) {
        this.tasks.remove(taskRef);
        taskRef.getRoles().remove(this);
        return this;
    }

    public void setTasks(Set<TaskRef> taskRefs) {
        if (this.tasks != null) {
            this.tasks.forEach(i -> i.removeRole(this));
        }
        if (taskRefs != null) {
            taskRefs.forEach(i -> i.addRole(this));
        }
        this.tasks = taskRefs;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RoleRef)) {
            return false;
        }
        return id != null && id.equals(((RoleRef) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "RoleRef{" +
            "id=" + getId() +
            ", taskName='" + getTaskName() + "'" +
            ", scope='" + getScope() + "'" +
            ", role='" + getRole() + "'" +
            "}";
    }
}
