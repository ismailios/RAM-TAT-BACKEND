package ma.itroad.ram.tat.coref.service.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import ma.itroad.ram.tat.coref.service.domain.enumeration.TatTypeEnum;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A TatType.
 */
@Entity
@Table(name = "tat_type")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class TatType implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Enumerated(EnumType.STRING)
//    @Column(name = "tat")
    private String tat;



    @ManyToMany(mappedBy = "tatTypes")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(
            value = { "refFlightType", "tatTypes", "delayReasons", "roles", "standardTasks" },
            allowSetters = true)
    private Set<TaskRef> tasks = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TatType id(Long id) {
        this.id = id;
        return this;
    }

    public String getTat() {
        return this.tat;
    }

    public TatType tat(String tat) {
        this.tat = tat;
        return this;
    }

    public void setTat(String tat) {
        this.tat = tat;
    }

    public Set<TaskRef> getTasks() {
        return this.tasks;
    }

    public TatType tasks(Set<TaskRef> taskRefs) {
        this.setTasks(taskRefs);
        return this;
    }

    public TatType addTask(TaskRef taskRef) {
        this.tasks.add(taskRef);
        taskRef.getTatTypes().add(this);
        return this;
    }

    public TatType removeTask(TaskRef taskRef) {
        this.tasks.remove(taskRef);
        taskRef.getTatTypes().remove(this);
        return this;
    }

    public void setTasks(Set<TaskRef> taskRefs) {
        if (this.tasks != null) {
            this.tasks.forEach(i -> i.removeTatType(this));
        }
        if (taskRefs != null) {
            taskRefs.forEach(i -> i.addTatType(this));
        }
        this.tasks = taskRefs;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof TatType)) {
            return false;
        }
        return id != null && id.equals(((TatType) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "TatType{" +
            "id=" + getId() +
            ", tat='" + getTat() + "'" +
            "}";
    }
}
