package ma.itroad.ram.tat.coref.service.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ma.itroad.ram.tat.coref.service.domain.enumeration.AirFlightTypeEnum;
import ma.itroad.ram.tat.coref.service.domain.enumeration.GroupTaskEnum;
import ma.itroad.ram.tat.coref.service.domain.enumeration.PhaseEnum;
import ma.itroad.ram.tat.coref.service.domain.enumeration.ReferenceDateEnum;
import ma.itroad.ram.tat.coref.service.domain.enumeration.TatTypeEnum;
import ma.itroad.ram.tat.coref.service.domain.enumeration.TypeEnum;

/**
 * A TaskRef.
 */

@Getter
@Setter
@DynamicUpdate
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "task_ref")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class TaskRef implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "id_task")
	private String idTask;

	@NotNull
	@Column(name = "code", nullable = false)
	private String code;

	@NotNull
	@Column(name = "name", nullable = false)
	private String name;

	@Enumerated(EnumType.STRING)
	@Column(name = "group_task")
	private GroupTaskEnum groupTask;

	@Column(name = "jhi_order")
	private String order;

	@Column(name = "ref_previous_task")
	private String refPreviousTask;

	@Column(name = "ref_related_task")
	private String refRelatedTask;

	@Enumerated(EnumType.STRING)
	@Column(name = "type")
	private TypeEnum type;

	@Column(name = "is_critical")
	private Boolean isCritical;

	@NotNull
	@Column(name = "is_actif", nullable = false)
	private Boolean isActif;

	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name = "phase", nullable = false)
	private PhaseEnum phase;

	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name = "tat_type", nullable = false)
	private TatTypeEnum tatType;

	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name = "flight_type", nullable = false)
	private AirFlightTypeEnum flightType;

	@Column(name = "task_order")
	private int taskOrder;

	@Column(name = "task_to_finish")
	private Long taskToFinish;

	@Column(name = "task_to_start")
	private Long taskToStart;

	@Column(name = "task_to_create")
	private Long taskToCreate;

	@Column(name = "shared_task")
	private boolean sharedTask;

	@Column(name = "starting_roles")
	private String startingRoles;

	@Column(name = "finishing_roles")
	private String finishingRoles;

	@Column(name = "task_input")
	private String taskInput;

	public AirFlightTypeEnum getFlightType() {
		return flightType;
	}

	public void setFlightType(AirFlightTypeEnum flightType) {
		this.flightType = flightType;
	}

	public TatTypeEnum getTatType() {
		return tatType;
	}

	public void setTatType(TatTypeEnum tatType) {
		this.tatType = tatType;
	}

	@Enumerated(EnumType.STRING)

    @Column(name = "reference_date")
    private ReferenceDateEnum referenceDate;

    @Column(name = "description")
    private String description;

    @ManyToMany
    @JoinTable(name="rel_task_ref__flight_type",
            joinColumns = @JoinColumn(name = "task_ref_id"),
            inverseJoinColumns = @JoinColumn(name = "flight_type_id"))
    private Set<FlightTypeRef> refFlightTypes;

    @ManyToMany
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JoinTable(
        name = "rel_task_ref__tat_type",
        joinColumns = @JoinColumn(name = "task_ref_id"),
        inverseJoinColumns = @JoinColumn(name = "tat_type_id")
    )
    @JsonIgnoreProperties(value = { "tasks" }, allowSetters = true)
    private Set<TatType> tatTypes = new HashSet<>();

    @OneToMany(mappedBy = "task")
    private Set<DelayReasonRef> delayReasons = new HashSet<>();

    @ManyToMany
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JoinTable(
        name = "rel_task_ref__role",
        joinColumns = @JoinColumn(name = "task_ref_id"),
        inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    @JsonIgnoreProperties(value = { "tasks" }, allowSetters = true)
    private Set<RoleRef> roles = new HashSet<>();

    @OneToMany(mappedBy = "task")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = { "task" }, allowSetters = true)
    private Set<StandardTaskRef> standardTasks = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TaskRef id(Long id) {
        this.id = id;
        return this;
    }

    public String getIdTask() {
        return this.idTask;
    }

    public TaskRef idTask(String idTask) {
        this.idTask = idTask;
        return this;
    }

    public void setIdTask(String idTask) {
        this.idTask = idTask;
    }

    public String getCode() {
        return this.code;
    }

    public TaskRef code(String code) {
        this.code = code;
        return this;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return this.name;
    }

    public TaskRef name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GroupTaskEnum getGroupTask() {
        return this.groupTask;
    }

    public TaskRef groupTask(GroupTaskEnum groupTask) {
        this.groupTask = groupTask;
        return this;
    }

    public void setGroupTask(GroupTaskEnum groupTask) {
        this.groupTask = groupTask;
    }

    public String getOrder() {
        return this.order;
    }

    public TaskRef order(String order) {
        this.order = order;
        return this;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getRefPreviousTask() {
        return this.refPreviousTask;
    }

    public TaskRef refPreviousTask(String refPreviousTask) {
        this.refPreviousTask = refPreviousTask;
        return this;
    }

    public void setRefPreviousTask(String refPreviousTask) {
        this.refPreviousTask = refPreviousTask;
    }

    public String getRefRelatedTask() {
        return this.refRelatedTask;
    }

    public TaskRef refRelatedTask(String refRelatedTask) {
        this.refRelatedTask = refRelatedTask;
        return this;
    }

    public void setRefRelatedTask(String refRelatedTask) {
        this.refRelatedTask = refRelatedTask;
    }

    public TypeEnum getType() {
        return this.type;
    }

    public TaskRef type(TypeEnum type) {
        this.type = type;
        return this;
    }

    public void setType(TypeEnum type) {
        this.type = type;
    }

    public Boolean getIsCritical() {
        return this.isCritical;
    }

    public TaskRef isCritical(Boolean isCritical) {
        this.isCritical = isCritical;
        return this;
    }

    public void setIsCritical(Boolean isCritical) {
        this.isCritical = isCritical;
    }

    public Boolean getIsActif() {
        return this.isActif;
    }

    public TaskRef isActif(Boolean isActif) {
        this.isActif = isActif;
        return this;
    }

    public void setIsActif(Boolean isActif) {
        this.isActif = isActif;
    }

    public PhaseEnum getPhase() {
        return this.phase;
    }

    public TaskRef phase(PhaseEnum phase) {
        this.phase = phase;
        return this;
    }

    public void setPhase(PhaseEnum phase) {
        this.phase = phase;
    }

    public ReferenceDateEnum getReferenceDate() {
        return this.referenceDate;
    }

    public TaskRef referenceDate(ReferenceDateEnum referenceDate) {
        this.referenceDate = referenceDate;
        return this;
    }

    public void setReferenceDate(ReferenceDateEnum referenceDate) {
        this.referenceDate = referenceDate;
    }

    public String getDescription() {
        return this.description;
    }

    public TaskRef description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<FlightTypeRef> getRefFlightType() {
        return this.refFlightTypes;
    }

    public TaskRef refFlightType(Set<FlightTypeRef>flightTypeRef) {
        this.setRefFlightType(flightTypeRef);
        return this;
    }

    public void setRefFlightType(Set<FlightTypeRef> flightTypeRef) {
        this.refFlightTypes = flightTypeRef;
    }

    public Set<TatType> getTatTypes() {
        return this.tatTypes;
    }

    public TaskRef tatTypes(Set<TatType> tatTypes) {
        this.setTatTypes(tatTypes);
        return this;
    }

    public TaskRef addTatType(TatType tatType) {
        this.tatTypes.add(tatType);
        tatType.getTasks().add(this);
        return this;
    }

    public TaskRef removeTatType(TatType tatType) {
        this.tatTypes.remove(tatType);
        tatType.getTasks().remove(this);
        return this;
    }

    public void setTatTypes(Set<TatType> tatTypes) {
        this.tatTypes = tatTypes;
    }

    public Set<DelayReasonRef> getDelayReasons() {
        return this.delayReasons;
    }

    public TaskRef delayReasons(Set<DelayReasonRef> delayReasonRefs) {
        this.setDelayReasons(delayReasonRefs);
        return this;
    }


    public void setDelayReasons(Set<DelayReasonRef> delayReasonRefs) {
        this.delayReasons = delayReasonRefs;
    }

    public Set<RoleRef> getRoles() {
        return this.roles;
    }

    public TaskRef roles(Set<RoleRef> roleRefs) {
        this.setRoles(roleRefs);
        return this;
    }

    public TaskRef addRole(RoleRef roleRef) {
        this.roles.add(roleRef);
        roleRef.getTasks().add(this);
        return this;
    }

    public TaskRef removeRole(RoleRef roleRef) {
        this.roles.remove(roleRef);
        roleRef.getTasks().remove(this);
        return this;
    }

    public void setRoles(Set<RoleRef> roleRefs) {
        this.roles = roleRefs;
    }

    public Set<StandardTaskRef> getStandardTasks() {
        return this.standardTasks;
    }

    public TaskRef standardTasks(Set<StandardTaskRef> standardTaskRefs) {
        this.setStandardTasks(standardTaskRefs);
        return this;
    }

    public TaskRef addStandardTask(StandardTaskRef standardTaskRef) {
        this.standardTasks.add(standardTaskRef);
        standardTaskRef.setTask(this);
        return this;
    }

    public TaskRef removeStandardTask(StandardTaskRef standardTaskRef) {
        this.standardTasks.remove(standardTaskRef);
        standardTaskRef.setTask(null);
        return this;
    }

    public int getTaskOrder() {
        return taskOrder;
    }

    public void setTaskOrder(int taskOrder) {
        this.taskOrder = taskOrder;
    }

    public void setStandardTasks(Set<StandardTaskRef> standardTaskRefs) {
        if (this.standardTasks != null) {
            this.standardTasks.forEach(i -> i.setTask(null));
        }
        if (standardTaskRefs != null) {
            standardTaskRefs.forEach(i -> i.setTask(this));
        }
        this.standardTasks = standardTaskRefs;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof TaskRef)) {
            return false;
        }
        return id != null && id.equals(((TaskRef) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    public Boolean getCritical() {
        return isCritical;
    }

    public void setCritical(Boolean critical) {
        isCritical = critical;
    }

    public Boolean getActif() {
        return isActif;
    }

    public void setActif(Boolean actif) {
        isActif = actif;
    }

    public Long getTaskToEnd() {
        return taskToFinish;
    }

    public void setTaskToEnd(Long taskToEnd) {
        this.taskToFinish = taskToEnd;
    }

    public Long getTaskToStart() {
        return taskToStart;
    }

    public void setTaskToStart(Long taskToStart) {
        this.taskToStart = taskToStart;
    }

    public Long getTaskToCreate() {
        return taskToCreate;
    }

    public void setTaskToCreate(Long taskToCreate) {
        this.taskToCreate = taskToCreate;
    }

    public boolean isSharedTask() {
        return sharedTask;
    }

    public void setSharedTask(boolean sharedTask) {
        this.sharedTask = sharedTask;
    }

    public String getStartingRoles() {
        return startingRoles;
    }

    public void setStartingRoles(String startingRoles) {
        this.startingRoles = startingRoles;
    }

    public String getFinishingRoles() {
        return finishingRoles;
    }

    public void setFinishingRoles(String finishingRoles) {
        this.finishingRoles = finishingRoles;
    }

    public Long getTaskToFinish() {
        return taskToFinish;
    }

    public void setTaskToFinish(Long taskToFinish) {
        this.taskToFinish = taskToFinish;
    }

    public String getTaskInput() {
        return taskInput;
    }

    public void setTaskInput(String taskInput) {
        this.taskInput = taskInput;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "TaskRef{" +
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
            "}";
    }

}
