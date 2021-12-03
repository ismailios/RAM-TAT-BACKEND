package ma.itroad.ram.tat.tatBusiness.service.dtos;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaskStandardDto implements Serializable {

    @JsonProperty("idStandardTask")
    private String idStandardTask;

    @JsonProperty("flightType")
    private String flightType;

    @JsonProperty("startDateOffset")
    private int startDateOffset;

    @JsonProperty("endDateOffset")
    private int endDateOffset;

    @JsonProperty("duration")
    private int duration;

    @JsonProperty("task")
    public TaskDtoCoref task;

    @JsonProperty("referenceDate")
    private String referenceDate;

    @Override
    public String toString() {
        return "TaskStandardDto{" +
                "idStandardTask='" + idStandardTask + '\'' +
                ", flightType='" + flightType + '\'' +
                ", startDateOffset=" + startDateOffset +
                ", endDateOffset=" + endDateOffset +
                ", duration=" + duration +
//                ", task=" + task.toString()+
                '}';
    }
}
