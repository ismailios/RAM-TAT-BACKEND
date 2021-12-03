package ma.itroad.ram.tat.scheduler.ms.service.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public class NetlineFlightChangerDto {

	private Long id;
    @JsonProperty("natKey")
    private NatKeyDto natKey;

    @JsonProperty("oldNatKey")
    private NatKeyDto oldNatKey;

    @JsonProperty("state")
    private String state;

    @JsonProperty("asmActionIdentifier")
    private String asmActionIdentifier;

    @JsonProperty("changeReason")
    private String changeReason;

    @JsonProperty("schedule")
    private ScheduleDto schedule;

    @JsonProperty("estimatedTimeDeparture")
    private LocalDateTime estimatedTimeDeparture;

    @JsonProperty("estimatedTimeArrival")
    private LocalDateTime estimatedTimeArrival;

    
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public NatKeyDto getNatKey() {
		return natKey;
	}

	public void setNatKey(NatKeyDto natKey) {
		this.natKey = natKey;
	}

	public NatKeyDto getOldNatKey() {
		return oldNatKey;
	}

	public void setOldNatKey(NatKeyDto oldNatKey) {
		this.oldNatKey = oldNatKey;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getAsmActionIdentifier() {
		return asmActionIdentifier;
	}

	public void setAsmActionIdentifier(String asmActionIdentifier) {
		this.asmActionIdentifier = asmActionIdentifier;
	}

	public String getChangeReason() {
		return changeReason;
	}

	public void setChangeReason(String changeReason) {
		this.changeReason = changeReason;
	}

	public ScheduleDto getSchedule() {
		return schedule;
	}

	public void setSchedule(ScheduleDto schedule) {
		this.schedule = schedule;
	}

	public LocalDateTime getEstimatedTimeDeparture() {
		return estimatedTimeDeparture;
	}

	public void setEstimatedTimeDeparture(LocalDateTime estimatedTimeDeparture) {
		this.estimatedTimeDeparture = estimatedTimeDeparture;
	}

	public LocalDateTime getEstimatedTimeArrival() {
		return estimatedTimeArrival;
	}

	public void setEstimatedTimeArrival(LocalDateTime estimatedTimeArrival) {
		this.estimatedTimeArrival = estimatedTimeArrival;
	}

	public NetlineFlightChangerDto(Long id, NatKeyDto natKey, NatKeyDto oldNatKey, String state,
			String asmActionIdentifier, String changeReason, ScheduleDto schedule, LocalDateTime estimatedTimeDeparture,
			LocalDateTime estimatedTimeArrival) {
		super();
		this.id = id;
		this.natKey = natKey;
		this.oldNatKey = oldNatKey;
		this.state = state;
		this.asmActionIdentifier = asmActionIdentifier;
		this.changeReason = changeReason;
		this.schedule = schedule;
		this.estimatedTimeDeparture = estimatedTimeDeparture;
		this.estimatedTimeArrival = estimatedTimeArrival;
	}

	public NetlineFlightChangerDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
    public String toString() {
        return "NetlineFlightChangerDto{" +
                "natKey=" + natKey +
                ", oldNatKey=" + oldNatKey.toString() +
                ", state='" + state + '\'' +
                ", asmActionIdentifier='" + asmActionIdentifier + '\'' +
                ", changeReason='" + changeReason + '\'' +
                ", schedule=" + schedule.toString() +
                ", estimatedTimeDeparture=" + estimatedTimeDeparture +
                ", estimatedTimeArrival=" + estimatedTimeArrival +
                '}';
    }
}
