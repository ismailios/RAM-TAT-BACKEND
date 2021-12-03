package ma.itroad.ram.tat.tatBusiness.service.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ma.itroad.ram.tat.tatBusiness.service.domain.Role;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaskFrontDto {


    public long id;

    @JsonProperty("idTask")
    public String idTask;

    @JsonProperty("refId")
    public Long refId;

    @JsonProperty("code")
    public String code;

    @JsonProperty("name")
    public String name;

    @JsonProperty("groupTask")
    public String groupTask;

    @JsonProperty("order") //order is reserved word for postgre
    public String order;

    @JsonProperty("refPreviousTask")
    public String refPreviousTask;

    @JsonProperty("refRelatedTask")
    public String refRelatedTask;

    @JsonProperty("type")
    public String type;

    @JsonProperty("isCritical")
    public boolean isCritical;

    @JsonProperty("isActif")
    public boolean isActif;

    @JsonProperty("phase")
    public String phase;

    @JsonProperty("tatType")
    public String tatType;

    @JsonProperty("flightType")
    public String flightType;

    @JsonProperty("referenceDate")
    public String referenceDate;

    @JsonProperty("description")
    public String description;

    @JsonProperty("idStandardTask")
    public String idStandardTask;

//    @JsonProperty("flightType")
//    private String aircraftType;

    @JsonProperty("startDateOffset")
    public int startDateOffset;

    @JsonProperty("startDateCalculated")
    public LocalDateTime startDateCalculated;

    @JsonProperty("startDateActual")
    public LocalDateTime startDateActual;

    @JsonProperty("endDateCalculated")
    public LocalDateTime endDateCalculated;

    @JsonProperty("endDateActual")
    public LocalDateTime endDateActual;

    @JsonProperty("endDateOffset")
    public int endDateOffset;

    @JsonProperty("duration")
    public int duration;

    @JsonProperty("taskOrder")
    public int taskOrder;

    @JsonProperty("progress")
    public int progress;

    @JsonProperty("startDelay")
    public long startDelay;

    @JsonProperty("endDelay")
    public long endDelay;

    @JsonProperty("exceeding")
    public long exceeding;

    @JsonProperty("startedBy")
    public String startedBy;

    @JsonProperty("finishedBy")
    public String finishedBy;

    @JsonProperty("notApplicable")
    public boolean notApplicable=false;

    @JsonProperty("allowNotApplicableButton")
    public boolean allowNotApplicableButton;

    @JsonProperty("tatId")
    public Long tatId;


    //Status
    @JsonProperty("status")
    public String status="NON_STARTED";

    @JsonProperty("roles")
    public Set<RoleDto> roles;

    @JsonProperty("owner")
    public String owner;

    @JsonProperty("ownerRole")
    public String ownerRole;

    @JsonProperty("alert_type")
    public int alertType;

    @JsonProperty("shared")
    public boolean shared;

    @JsonProperty("starting_roles")
    public String startingRoles;

    @JsonProperty("finishing_roles")
    public String finishingRoles;

    @JsonProperty("comment")
    public String comment;

    @JsonProperty("allowStart")
    public boolean allowStart;

    @JsonProperty("allowFinish")
    public boolean allowFinish;

    @JsonProperty("delay_reaons")
    public List<DelayReasonDto> delayReasons;

    public List<String> generateStartingRoles(){
        if(this.startingRoles!=null)
        try{
        return Arrays.asList(this.startingRoles.split("-"));}
        catch (Exception e){
            return null;
        }
        return null;
    }
    public List<String> generateFinishingRoles(){
        if(this.finishingRoles!=null)
            try{
                return Arrays.asList(this.finishingRoles.split("-"));}
            catch (Exception e){
                return null;
            }
        return null;
    }


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

    public Long getRefId() {
        return refId;
    }

    public void setRefId(Long refId) {
        this.refId = refId;
    }
}
