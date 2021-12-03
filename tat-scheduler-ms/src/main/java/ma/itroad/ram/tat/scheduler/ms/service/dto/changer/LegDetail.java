package ma.itroad.ram.tat.scheduler.ms.service.dto.changer;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LegDetail {

    @JsonProperty("identifier")
    public InstantIdentifier identifier;

    @JsonProperty("state")
    public String state;

    @JsonProperty("misc")
    public String misc;

    @JsonProperty("changeInfo")
    public ChangeInfo changeInfo;

    @JsonProperty("schedule")
    public Schedule schedule;

    @JsonProperty("performance")
    public Performance performance;

    @JsonProperty("lastUpdate")
    public LastUpdate lastUpdate;

    @JsonProperty("actuals")
    public Actuals actuals;

    @JsonProperty("atcSlot")
    public AtcSlot atcSlot;

    public InstantIdentifier getIdentifier() {
        return identifier;
    }

    public void setIdentifier(InstantIdentifier identifier) {
        this.identifier = identifier;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getMisc() {
        return misc;
    }

    public void setMisc(String misc) {
        this.misc = misc;
    }

    public ChangeInfo getChangeInfo() {
        return changeInfo;
    }

    public void setChangeInfo(ChangeInfo changeInfo) {
        this.changeInfo = changeInfo;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public Performance getPerformance() {
        return performance;
    }

    public void setPerformance(Performance performance) {
        this.performance = performance;
    }

    public LastUpdate getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LastUpdate lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Actuals getActuals() {
        return actuals;
    }

    public void setActuals(Actuals actuals) {
        this.actuals = actuals;
    }

    public AtcSlot getAtcSlot() {
        return atcSlot;
    }

    public void setAtcSlot(AtcSlot atcSlot) {
        this.atcSlot = atcSlot;
    }
}
