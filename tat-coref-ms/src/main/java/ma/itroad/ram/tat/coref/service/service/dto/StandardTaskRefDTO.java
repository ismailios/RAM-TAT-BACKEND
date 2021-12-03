package ma.itroad.ram.tat.coref.service.service.dto;

import java.io.Serializable;
import java.util.Objects;

import ma.itroad.ram.tat.coref.service.domain.enumeration.FlightTypeEnum;

/**
 * A DTO for the {@link ma.itroad.ram.tat.coref.service.domain.StandardTaskRef} entity.
 */
public class StandardTaskRefDTO implements Serializable {

    private Long id;

    private String idStandardTask;

    private FlightTypeEnum flightType;

    private Integer startDateOffset;

    private Integer endDateOffset;

    private Integer duration;

    private TaskRefDTO task;

    private String referenceDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdStandardTask() {
        return idStandardTask;
    }

    public void setIdStandardTask(String idStandardTask) {
        this.idStandardTask = idStandardTask;
    }

    public FlightTypeEnum getFlightType() {
        return flightType;
    }

    public void setFlightType(FlightTypeEnum flightType) {
        this.flightType = flightType;
    }

    public Integer getStartDateOffset() {
        return startDateOffset;
    }

    public void setStartDateOffset(Integer startDateOffset) {
        this.startDateOffset = startDateOffset;
    }

    public Integer getEndDateOffset() {
        return endDateOffset;
    }

    public void setEndDateOffset(Integer endDateOffset) {
        this.endDateOffset = endDateOffset;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getReferenceDate() {
        return referenceDate;
    }

    public void setReferenceDate(String referenceDate) {
        this.referenceDate = referenceDate;
    }

    public TaskRefDTO getTask() {
        return task;
    }

    public void setTask(TaskRefDTO task) {
        this.task = task;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof StandardTaskRefDTO)) {
            return false;
        }

        StandardTaskRefDTO standardTaskRefDTO = (StandardTaskRefDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, standardTaskRefDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "StandardTaskRefDTO{" +
            "id=" + getId() +
            ", idStandardTask='" + getIdStandardTask() + "'" +
            ", flightType='" + getFlightType() + "'" +
            ", startDateOffset=" + getStartDateOffset() +
            ", endDateOffset=" + getEndDateOffset() +
            ", duration=" + getDuration() +
            ", task=" + getTask() +
            "}";
    }
}
