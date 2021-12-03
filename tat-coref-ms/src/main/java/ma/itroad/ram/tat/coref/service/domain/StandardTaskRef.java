package ma.itroad.ram.tat.coref.service.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import ma.itroad.ram.tat.coref.service.domain.enumeration.FlightTypeEnum;

import java.io.Serializable;
import javax.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A StandardTaskRef.
 */
@Entity
@Table(name = "standard_task_ref")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class StandardTaskRef implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_standard_task")
    private String idStandardTask;

    @Enumerated(EnumType.STRING)
    @Column(name = "flight_type")
    private FlightTypeEnum flightType;

    @Column(name = "start_date_offset")
    private Integer startDateOffset;

    @Column(name = "end_date_offset")
    private Integer endDateOffset;

    @Column(name = "duration")
    private Integer duration;

    @Column(name="reference_date")
    private String referenceDate;

    @ManyToOne
    @JsonIgnoreProperties(value = { "refFlightType", "tatTypes", "delayReasons"/*, "roles"*/, "standardTasks" }, allowSetters = true)
    private TaskRef task;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StandardTaskRef id(Long id) {
        this.id = id;
        return this;
    }

    public String getIdStandardTask() {
        return this.idStandardTask;
    }

    public StandardTaskRef idStandardTask(String idStandardTask) {
        this.idStandardTask = idStandardTask;
        return this;
    }

    public void setIdStandardTask(String idStandardTask) {
        this.idStandardTask = idStandardTask;
    }

    public FlightTypeEnum getFlightType() {
        return this.flightType;
    }

    public StandardTaskRef flightType(FlightTypeEnum flightType) {
        this.flightType = flightType;
        return this;
    }

    public void setFlightType(FlightTypeEnum flightType) {
        this.flightType = flightType;
    }

    public Integer getStartDateOffset() {
        return this.startDateOffset;
    }

    public StandardTaskRef startDateOffset(Integer startDateOffset) {
        this.startDateOffset = startDateOffset;
        return this;
    }

    public void setStartDateOffset(Integer startDateOffset) {
        this.startDateOffset = startDateOffset;
    }

    public Integer getEndDateOffset() {
        return this.endDateOffset;
    }

    public StandardTaskRef endDateOffset(Integer endDateOffset) {
        this.endDateOffset = endDateOffset;
        return this;
    }

    public void setEndDateOffset(Integer endDateOffset) {
        this.endDateOffset = endDateOffset;
    }

    public Integer getDuration() {
        return this.duration;
    }

    public StandardTaskRef duration(Integer duration) {
        this.duration = duration;
        return this;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public TaskRef getTask() {
        return this.task;
    }

    public StandardTaskRef task(TaskRef taskRef) {
        this.setTask(taskRef);
        return this;
    }

    public void setTask(TaskRef taskRef) {
        this.task = taskRef;
    }

    public String getReferenceDate() {
        return referenceDate;
    }

    public void setReferenceDate(String referenceDate) {
        this.referenceDate = referenceDate;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof StandardTaskRef)) {
            return false;
        }
        return id != null && id.equals(((StandardTaskRef) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "StandardTaskRef{" +
            "id=" + getId() +
            ", idStandardTask='" + getIdStandardTask() + "'" +
            ", flightType='" + getFlightType() + "'" +
            ", startDateOffset=" + getStartDateOffset() +
            ", endDateOffset=" + getEndDateOffset() +
            ", duration=" + getDuration() +
            "}";
    }
}
