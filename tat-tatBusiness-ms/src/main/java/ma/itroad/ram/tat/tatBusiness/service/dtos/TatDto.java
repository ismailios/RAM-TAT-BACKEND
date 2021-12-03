package ma.itroad.ram.tat.tatBusiness.service.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ma.itroad.ram.tat.tatBusiness.ms.service.dto.changer.onda.OndaInfoDto;
import ma.itroad.ram.tat.tatBusiness.service.domain.FlightSitatx;
import ma.itroad.ram.tat.tatBusiness.service.domain.LoadSheet;
import ma.itroad.ram.tat.tatBusiness.service.domain.OndaInfo;
import ma.itroad.ram.tat.tatBusiness.service.domain.PassengerInfo;
import ma.itroad.ram.tat.tatBusiness.service.dto.changer.passengerList.ReturnDto;
import ma.itroad.ram.tat.tatBusiness.service.dto.changer.sitatx.FlightSitatxDto;
import ma.itroad.ram.tat.tatBusiness.service.dtos.changer.loadSheet.LoadSheetDto;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TatDto implements Serializable {

    @JsonProperty("tatType")
    private String tatType;

    @JsonProperty("id")
    private long id;

    @JsonProperty("autoAffect")
    private boolean autoAssign;

    @JsonProperty("liberate")
    private boolean liberate;

    @JsonProperty("handover")
    private boolean handover;

    @JsonProperty("progress")
    private float progress;

    @JsonProperty("flights")
    private List<FlightDto> flights ;

    @JsonProperty("potentialDelay")
    private int potentialDelay;
    
    @JsonProperty("ondaInfo")
    private OndaInfoDto ondainfo;
    
    @JsonProperty("SitatxInfo")
    private FlightSitatxDto flightSitatx;
    
    @JsonProperty("loadSheetInfo")
    private LoadSheetDto loadSheet;
    
    @JsonProperty("passengerInfo")
    private PassengerInfoDto passengerInfo;
    
    
    
    
    
    
    

    @JsonProperty("startDate")
    private LocalDateTime startDate;

    @JsonProperty("endDate")
    private LocalDateTime endDate;

    @JsonProperty("duration")
    private long duration ;

    @JsonProperty("progressDB")
    private double progressDB;

    public String getTatType() {
        return tatType;
    }

    public void setTatType(String tatType) {
        this.tatType = tatType;
    }

    public long getId() {
        return id;
    }

    public List<FlightDto> getFlights() {
        return flights;
    }

    public void setFlights(List<FlightDto> flights) {
        this.flights = flights;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }
}
