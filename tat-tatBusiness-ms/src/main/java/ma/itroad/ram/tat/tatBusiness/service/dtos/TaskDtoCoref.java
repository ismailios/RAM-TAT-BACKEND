package ma.itroad.ram.tat.tatBusiness.service.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ma.itroad.ram.tat.tatBusiness.service.domain.Role;

import javax.persistence.Column;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaskDtoCoref {
    @JsonProperty
    private long id;

    @JsonProperty("idTask")
    private String idTask;

    @JsonProperty("code")
    private String code;

    @JsonProperty("name")
    private String name;

    @JsonProperty("groupTask")
    private String groupTask;

    @JsonProperty("order")
    private String order;

    @JsonProperty("refPreviousTask")
    private String refPreviousTask;

    @JsonProperty("refRelatedTask")
    private String refRelatedTask;

    @JsonProperty("type")
    private String type;

    @JsonProperty("isCritical")
    private boolean isCritical;

    @JsonProperty("isActif")
    private boolean isActif;

    @JsonProperty("phase")
    private String phase;

    @JsonProperty("tatType")
    private String tatType;

    @JsonProperty("flightType")
    private String flightType;

    @JsonProperty("referenceDate")
    private String referenceDate;

    @JsonProperty("description")
    private String description;

    @JsonProperty("taskOrder")
    private int taskOrder;

    @JsonProperty("taskToFinish")
    private Long taskToFinish;

    @JsonProperty("taskToStart")
    private Long taskToStart;

    @JsonProperty("taskToCreate")
    private Long taskToCreate;

    @JsonProperty("sharedTask")
    private boolean sharedTask;

    @JsonProperty("startingRoles")
    private String startingRoles;

    @JsonProperty("finishingRoles")
    private String finishingRoles;

    @JsonProperty("taskInput")
    private String taskInput;

    @JsonProperty("roles")
    Set<RoleRefDto> roles;

    @JsonProperty("delayReasons")
    List<DelayReasonDto> delayReasons;

    @Override
    public String toString() {
        return "TaskDto{" +
                "idTask='" + idTask + '\'' +
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
                '}';
    }
}
