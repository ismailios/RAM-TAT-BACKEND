package ma.itroad.ram.tat.tatBusiness.service.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="ref_id")
    public Long refId;

    @Column(name="idTask")
    public String idTask;

    @Column(name="code")
    public String code;

    @Column(name="name")
    public String name;

    @Column(name="groupTask")
    public String groupTask;

    @Column(name="order_") //order is reserved word for postgre
    public String order;

    @Column(name="refPreviousTask")
    public String refPreviousTask;

    @Column(name="refRelatedTask")
    public String refRelatedTask;

    @Column(name="type")
    public String type;

    @Column(name="isCritical")
    public boolean isCritical;

    @Column(name="isActif")
    public boolean isActif;

    @Column(name="phase")
    public String phase;

    @Column(name="tatType")
    public String tatType;

    @Column(name="flightType")
    public String flightType;

    @Column(name="referenceDate")
    public String referenceDate;

    @Column(name="description")
    public String description;

    @Column(name="idStandardTask")
    public String idStandardTask;

//    @Column(name="flightType")
//    private String aircraftType;

    @Column(name="startDateOffset")
    public int startDateOffset;

    @Column(name="startDateCalculated")
    public LocalDateTime startDateCalculated;

    @Column(name="startDateActual")
    public LocalDateTime startDateActual;

    @Column(name="endDateCalculated")
    public LocalDateTime endDateCalculated;

    @Column(name="endDateActual")
    public LocalDateTime endDateActual;

    @Column(name="endDateOffset")
    public int endDateOffset;

    @Column(name="duration")
    public int duration;

    @Column(name="task_order")
    public int taskOrder;

    @Column(name="progress")
    public int progress;

    @Column(name="start_delay")
    public long startDelay;

    @Column(name="end_delay")
    public long endDelay;

    @Column(name="exceeding")
    public long exceeding;

    @Column(name="started_by")
    public String startedBy;

    @Column(name="owner")
    public String owner;

    @Column(name="ownerRole")
    public String ownerRole;

    @Column(name="finished_by")
    public String finishedBy;

    @Column(name="not_applicable")
    public boolean notApplicable=false;

    @Column(name="tat_id")
    public Long tatId;

    @Column(name="status")
    public String status;

    @Column(name="alert_type")
    public int alertType;

    @Column(name="shared")
    public boolean shared;

    @Column(name="starting_roles")
    public String startingRoles;

    @Column(name="finishing_roles")
    public String finishingRoles;

    @Column(name="task_to_finish")
    public Long taskToFinish;

    @Column(name="delay_reason")
    public String delayReason;

    @Column(name="delay_reason_precision")
    public String delayReasonPrecision;

    @Column(name="comment")
    public String comment;

    @Column(name="fuel_quantity")
    public double fuelQuantity;

    @Column(name="trip")
    public double trip;

    @Column(name="taxi")
    public double taxi;

    @Column(name="drinking_water")
    public double drinkingWater;

    @Column(name="remaining_drinking_water")
    public double remainingDrinkingWater;

    @Column(name="task_to_create")
    public Long taskToCreate;

    @Column(name="task_input")
    public String taskInput;


    @ManyToMany
    @JoinTable(
            name = "task_roles",
            joinColumns = @JoinColumn(name = "task_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    public Set<Role> roles;



    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", idTask='" + idTask + '\'' +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", groupTask='" + groupTask + '\'' +
                ", order='" + order + '\'' +
                ", refPreviousTask='" + refPreviousTask + '\'' +
                ", refRelatedTask='" + refRelatedTask + '\'' +
                ", type='" + type + '\'' +
                ", isCritical=" + isCritical +
                ", isActif=" + isActif +
                ", phase='" + phase + '\'' +
                ", tatType='" + tatType + '\'' +
                ", flightType='" + flightType + '\'' +
                ", referenceDate='" + referenceDate + '\'' +
                ", description='" + description + '\'' +
                ", idStandardTask='" + idStandardTask + '\'' +
                ", startDateOffset=" + startDateOffset +
                ", startDateCalculated=" + startDateCalculated +
                ", startDateActual=" + startDateActual +
                ", endDateCalculated=" + endDateCalculated +
                ", endDateActual=" + endDateActual +
                ", endDateOffset=" + endDateOffset +
                ", duration=" + duration +
                ", taskOrder=" + taskOrder +
                ", progress=" + progress +
                ", tatId=" + tatId +
                ", status='" + status + '\'' +
                ", roles=" + roles +
                '}';
    }

    public Task(String idTask, String name, String groupTask, String type,
                String phase, String description, String idStandardTask, int duration, int taskOrder,
                String startedBy, String owner, String ownerRole, Long tatId, String status, List<Role> roles) {
        this.idTask = idTask;
        this.name = name;
        this.groupTask = groupTask;
        this.order = order;
        this.type = type;
        this.phase = phase;
        this.description = description;
        this.idStandardTask = idStandardTask;
        this.duration = duration;
        this.taskOrder = taskOrder;
        this.startedBy = startedBy;
        this.owner = owner;
        this.ownerRole = ownerRole;
        this.tatId = tatId;
        this.status = status;
        this.roles.addAll(roles);
    }

    public List<String> generateRoles() {
        List<String> roleString=new ArrayList<>();
        if(this.roles!=null){
            for(Role role : this.roles){
                roleString.add(role.getName());
            }
        }
        return roleString;

    }


}
