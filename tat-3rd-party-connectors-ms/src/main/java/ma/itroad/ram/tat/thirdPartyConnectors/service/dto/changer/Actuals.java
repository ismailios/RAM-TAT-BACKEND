package ma.itroad.ram.tat.thirdPartyConnectors.service.dto.changer;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Actuals implements Serializable {
    ///
    @JsonProperty("estimatedTimeArrival")
    public LocalDateTime estimatedTimeArrival;

    @JsonProperty("estimatedTimeDeparture")
    public LocalDateTime estimatedTimeDeparture;

    @JsonProperty("adviseTime")
    public LocalDateTime adviseTime;

    @JsonProperty("offblockTime")
    public OffblockTime offblockTime;

    @JsonProperty("airborneTime")
    public AirborneTime airborneTime;

    @JsonProperty("landingTime")
    public LandingTime landingTime;

    @JsonProperty("onblockTime")
    public OnblockTime onblockTime;

    @JsonProperty("delay")
    public List<DelayDto> delay;

    public LocalDateTime getEstimatedTimeArrival() {
        return estimatedTimeArrival;
    }

    public void setEstimatedTimeArrival(LocalDateTime estimatedTimeArrival) {
        this.estimatedTimeArrival = estimatedTimeArrival;
    }

    public LocalDateTime getEstimatedTimeDeparture() {
        return estimatedTimeDeparture;
    }

    public void setEstimatedTimeDeparture(LocalDateTime estimatedTimeDeparture) {
        this.estimatedTimeDeparture = estimatedTimeDeparture;
    }

    public LocalDateTime getAdviseTime() {
        return adviseTime;
    }

    public void setAdviseTime(LocalDateTime adviseTime) {
        this.adviseTime = adviseTime;
    }

    public OffblockTime getOffblockTime() {
        return offblockTime;
    }

    public void setOffblockTime(OffblockTime offblockTime) {
        this.offblockTime = offblockTime;
    }

    public AirborneTime getAirborneTime() {
        return airborneTime;
    }

    public void setAirborneTime(AirborneTime airborneTime) {
        this.airborneTime = airborneTime;
    }

    public LandingTime getLandingTime() {
        return landingTime;
    }

    public void setLandingTime(LandingTime landingTime) {
        this.landingTime = landingTime;
    }

    public OnblockTime getOnblockTime() {
        return onblockTime;
    }

    public void setOnblockTime(OnblockTime onblockTime) {
        this.onblockTime = onblockTime;
    }

    public List<DelayDto> getDelay() {
        return delay;
    }

    public void setDelay(List<DelayDto> delay) {
        this.delay = delay;
    }
}
