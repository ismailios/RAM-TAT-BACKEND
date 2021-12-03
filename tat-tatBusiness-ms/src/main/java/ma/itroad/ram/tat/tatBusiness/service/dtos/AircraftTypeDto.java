package ma.itroad.ram.tat.tatBusiness.service.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class AircraftTypeDto implements Serializable {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("idAircraft")
    private String idAircraft;

    @JsonProperty("code")
    private String code;

    @JsonProperty("name")
    private String name;

    @JsonProperty("tatMaxDuration")
    private Integer tatMaxDuration;

    @JsonProperty("drinkingWaterTank")
    private Long drinkingWaterTank;

    @JsonProperty( "airCraftType")
    private String airCraftType;

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

    public String getAirCraftType() {
        return airCraftType;
    }

    public void setAirCraftType(String airCraftType) {
        this.airCraftType = airCraftType;
    }

    public AircraftTypeDto() {
    }

    public AircraftTypeDto(Long id, String idAircraft, String code, String name, Integer tatMaxDuration, Long drinkingWaterTank, String airCraftType) {
        this.id = id;
        this.idAircraft = idAircraft;
        this.code = code;
        this.name = name;
        this.tatMaxDuration = tatMaxDuration;
        this.drinkingWaterTank = drinkingWaterTank;
        this.airCraftType = airCraftType;
    }
}
