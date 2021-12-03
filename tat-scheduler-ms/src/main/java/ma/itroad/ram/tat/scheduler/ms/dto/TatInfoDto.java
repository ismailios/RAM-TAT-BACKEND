package ma.itroad.ram.tat.scheduler.ms.dto;

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
public class TatInfoDto implements Serializable {

    @JsonProperty("id")
    private Long id;
    @JsonProperty("legType")
    private String legType;
    @JsonProperty("acSubType")
    private String acSubType;
    @JsonProperty("tatType")
    private String tatType;

    public String getTatType() {
        return tatType;
    }

    public void setTatType(String tatType) {
        this.tatType = tatType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLegType() {
        return legType;
    }

    public void setLegType(String legType) {
        this.legType = legType;
    }

    public String getAcSubType() {
        return acSubType;
    }

    public void setAcSubType(String acSubType) {
        this.acSubType = acSubType;
    }

    @Override
    public String toString() {
        return "TatInfoDto{" +
                "id=" + id +
                ", tatType='" + tatType + '\'' +
                ", legType='" + legType + '\'' +
                ", acSubType='" + acSubType + '\'' +
                '}';
    }
}
