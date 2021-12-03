package ma.itroad.ram.tat.coref.service.service.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.validation.constraints.*;

import ma.itroad.ram.tat.coref.service.domain.enumeration.AirFlightTypeEnum;
import ma.itroad.ram.tat.coref.service.domain.enumeration.GroupTaskEnum;
import ma.itroad.ram.tat.coref.service.domain.enumeration.PhaseEnum;
import ma.itroad.ram.tat.coref.service.domain.enumeration.ReferenceDateEnum;
import ma.itroad.ram.tat.coref.service.domain.enumeration.TatTypeEnum;
import ma.itroad.ram.tat.coref.service.domain.enumeration.TypeEnum;

/**
 * A DTO for the {@link ma.itroad.ram.tat.coref.service.domain.TaskRef} entity.
 */
public class TaskRefDTO implements Serializable {

    private Long id;

    private String idTask;

    @NotNull
    private String code;

    @NotNull
    private String name;

    private GroupTaskEnum groupTask;

    private String order;

    private String refPreviousTask;

    private String refRelatedTask;

    private TypeEnum type;

    private Boolean isCritical;

    @NotNull
    private Boolean isActif;

    @NotNull
    private PhaseEnum phase;
    
    @NotNull
    private TatTypeEnum tatType;
    
    @NotNull
    private AirFlightTypeEnum flightType;

    public TatTypeEnum getTatType() {
		return tatType;
	}

	public void setTatType(TatTypeEnum tatType) {
		this.tatType = tatType;
	}

	private ReferenceDateEnum referenceDate;

    private String description;

    //private FlightTypeRefDTO refFlightType;

    private Set<TatTypeDTO> tatTypes = new HashSet<>();

    private Set<DelayReasonRefDTO> delayReasons = new HashSet<>();

    private Set<RoleRefDTO> roles = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdTask() {
        return idTask;
    }

    public void setIdTask(String idTask) {
        this.idTask = idTask;
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

    public GroupTaskEnum getGroupTask() {
        return groupTask;
    }

    public void setGroupTask(GroupTaskEnum groupTask) {
        this.groupTask = groupTask;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getRefPreviousTask() {
        return refPreviousTask;
    }

    public void setRefPreviousTask(String refPreviousTask) {
        this.refPreviousTask = refPreviousTask;
    }

    public String getRefRelatedTask() {
        return refRelatedTask;
    }

    public void setRefRelatedTask(String refRelatedTask) {
        this.refRelatedTask = refRelatedTask;
    }

    public TypeEnum getType() {
        return type;
    }

    public void setType(TypeEnum type) {
        this.type = type;
    }

    public Boolean getIsCritical() {
        return isCritical;
    }

    public void setIsCritical(Boolean isCritical) {
        this.isCritical = isCritical;
    }

    public Boolean getIsActif() {
        return isActif;
    }

    public void setIsActif(Boolean isActif) {
        this.isActif = isActif;
    }

    public PhaseEnum getPhase() {
        return phase;
    }

    public void setPhase(PhaseEnum phase) {
        this.phase = phase;
    }

    public ReferenceDateEnum getReferenceDate() {
        return referenceDate;
    }

    public void setReferenceDate(ReferenceDateEnum referenceDate) {
        this.referenceDate = referenceDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    public FlightTypeRefDTO getRefFlightType() {
//        return refFlightType;
//    }
//
//    public void setRefFlightType(FlightTypeRefDTO refFlightType) {
//        this.refFlightType = refFlightType;
//    }

    public Set<TatTypeDTO> getTatTypes() {
        return tatTypes;
    }

    public void setTatTypes(Set<TatTypeDTO> tatTypes) {
        this.tatTypes = tatTypes;
    }

    public Set<DelayReasonRefDTO> getDelayReasons() {
        return delayReasons;
    }

    public void setDelayReasons(Set<DelayReasonRefDTO> delayReasons) {
        this.delayReasons = delayReasons;
    }

    public Set<RoleRefDTO> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleRefDTO> roles) {
        this.roles = roles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof TaskRefDTO)) {
            return false;
        }

        TaskRefDTO taskRefDTO = (TaskRefDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, taskRefDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "TaskRefDTO{" +
            "id=" + getId() +
            ", idTask='" + getIdTask() + "'" +
            ", code='" + getCode() + "'" +
            ", name='" + getName() + "'" +
            ", groupTask='" + getGroupTask() + "'" +
            ", order='" + getOrder() + "'" +
            ", refPreviousTask='" + getRefPreviousTask() + "'" +
            ", refRelatedTask='" + getRefRelatedTask() + "'" +
            ", type='" + getType() + "'" +
            ", isCritical='" + getIsCritical() + "'" +
            ", isActif='" + getIsActif() + "'" +
            ", phase='" + getPhase() + "'" +
            ", referenceDate='" + getReferenceDate() + "'" +
            ", description='" + getDescription() + "'" +
           // ", refFlightType=" + getRefFlightType() +
            ", tatTypes=" + getTatTypes() +
            ", delayReasons=" + getDelayReasons() +
            ", roles=" + getRoles() +
            "}";
    }

	public AirFlightTypeEnum getFlightType() {
		return flightType;
	}

	public void setFlightType(AirFlightTypeEnum flightType) {
		this.flightType = flightType;
	}
}
