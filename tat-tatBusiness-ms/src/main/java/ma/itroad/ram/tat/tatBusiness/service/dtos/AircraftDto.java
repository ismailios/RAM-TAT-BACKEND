package ma.itroad.ram.tat.tatBusiness.service.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class AircraftDto implements Serializable {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("code")
    private String code;

    @JsonProperty("aircraft_type_ref_id")
    private String typeAircraft;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTypeAircraft() {
        return typeAircraft;
    }

    public void setTypeAircraft(String typeAircraft) {
        this.typeAircraft = typeAircraft;
    }


    public AircraftDto() {
    }

    public AircraftDto(Long id, String code, String typeAircraft) {
        this.id = id;
        this.code = code;
        this.typeAircraft = typeAircraft;
    }
}
