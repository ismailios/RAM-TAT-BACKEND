package ma.itroad.ram.tat.coref.service.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import ma.itroad.ram.tat.coref.service.domain.enumeration.FlightTypeEnum;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A AircraftTypeRef.
 */
@Entity
@Table(name = "aircraft_type_ref")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class AircraftTypeRef implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_aircraft")
    private String idAircraft;

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    @Column(name = "tat_max_duration")
    private Integer tatMaxDuration;

    @Column(name = "drinking_water_tank")
    private Long drinkingWaterTank;

    @Enumerated(EnumType.STRING)
    @Column(name = "air_craft_type")
    private FlightTypeEnum airCraftType;

    @OneToMany(mappedBy = "aircraftTypeRef")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = { "aircraftTypeRef" }, allowSetters = true)
    private Set<AircraftRef> types = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AircraftTypeRef id(Long id) {
        this.id = id;
        return this;
    }

    public String getIdAircraft() {
        return this.idAircraft;
    }

    public AircraftTypeRef idAircraft(String idAircraft) {
        this.idAircraft = idAircraft;
        return this;
    }

    public void setIdAircraft(String idAircraft) {
        this.idAircraft = idAircraft;
    }

    public String getCode() {
        return this.code;
    }

    public AircraftTypeRef code(String code) {
        this.code = code;
        return this;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return this.name;
    }

    public AircraftTypeRef name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTatMaxDuration() {
        return this.tatMaxDuration;
    }

    public AircraftTypeRef tatMaxDuration(Integer tatMaxDuration) {
        this.tatMaxDuration = tatMaxDuration;
        return this;
    }

    public void setTatMaxDuration(Integer tatMaxDuration) {
        this.tatMaxDuration = tatMaxDuration;
    }

    public Long getDrinkingWaterTank() {
        return this.drinkingWaterTank;
    }

    public AircraftTypeRef drinkingWaterTank(Long drinkingWaterTank) {
        this.drinkingWaterTank = drinkingWaterTank;
        return this;
    }

    public void setDrinkingWaterTank(Long drinkingWaterTank) {
        this.drinkingWaterTank = drinkingWaterTank;
    }

    public FlightTypeEnum getAirCraftType() {
        return this.airCraftType;
    }

    public AircraftTypeRef airCraftType(FlightTypeEnum airCraftType) {
        this.airCraftType = airCraftType;
        return this;
    }

    public void setAirCraftType(FlightTypeEnum airCraftType) {
        this.airCraftType = airCraftType;
    }

    public Set<AircraftRef> getTypes() {
        return this.types;
    }

    public AircraftTypeRef types(Set<AircraftRef> aircraftRefs) {
        this.setTypes(aircraftRefs);
        return this;
    }

    public AircraftTypeRef addType(AircraftRef aircraftRef) {
        this.types.add(aircraftRef);
        aircraftRef.setAircraftTypeRef(this);
        return this;
    }

    public AircraftTypeRef removeType(AircraftRef aircraftRef) {
        this.types.remove(aircraftRef);
        aircraftRef.setAircraftTypeRef(null);
        return this;
    }

    public void setTypes(Set<AircraftRef> aircraftRefs) {
        if (this.types != null) {
            this.types.forEach(i -> i.setAircraftTypeRef(null));
        }
        if (aircraftRefs != null) {
            aircraftRefs.forEach(i -> i.setAircraftTypeRef(this));
        }
        this.types = aircraftRefs;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AircraftTypeRef)) {
            return false;
        }
        return id != null && id.equals(((AircraftTypeRef) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "AircraftTypeRef{" +
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
