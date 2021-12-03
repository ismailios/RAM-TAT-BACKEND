package ma.itroad.ram.tat.coref.service.service.dto;

import java.io.Serializable;
import java.util.Objects;

import ma.itroad.ram.tat.coref.service.domain.enumeration.FlightTypeEnum;

/**
 * A DTO for the {@link ma.itroad.ram.tat.coref.service.domain.AircraftTypeRef} entity.
 */
public class AircraftTypeRefDTO implements Serializable {

    private Long id;

    private String idAircraft;

    private String code;

    private String name;

    private Integer tatMaxDuration;

    private Long drinkingWaterTank;

    private FlightTypeEnum airCraftType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdAircraft() {
        return idAircraft;
    }

    public void setIdAircraft(String idAircraft) {
        this.idAircraft = idAircraft;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTatMaxDuration() {
        return tatMaxDuration;
    }

    public void setTatMaxDuration(Integer tatMaxDuration) {
        this.tatMaxDuration = tatMaxDuration;
    }

    public Long getDrinkingWaterTank() {
        return drinkingWaterTank;
    }

    public void setDrinkingWaterTank(Long drinkingWaterTank) {
        this.drinkingWaterTank = drinkingWaterTank;
    }

    public FlightTypeEnum getAirCraftType() {
        return airCraftType;
    }

    public void setAirCraftType(FlightTypeEnum airCraftType) {
        this.airCraftType = airCraftType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AircraftTypeRefDTO)) {
            return false;
        }

        AircraftTypeRefDTO aircraftTypeRefDTO = (AircraftTypeRefDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, aircraftTypeRefDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "AircraftTypeRefDTO{" +
            "id=" + getId() +
            ", idAircraft='" + getIdAircraft() + "'" +
            ", code='" + getCode() + "'" +
            ", name='" + getName() + "'" +
            ", tatMaxDuration=" + getTatMaxDuration() +
            ", drinkingWaterTank=" + getDrinkingWaterTank() +
            ", airCraftType='" + getAirCraftType() + "'" +
            "}";
    }
}
