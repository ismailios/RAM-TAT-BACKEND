package ma.itroad.ram.tat.coref.service.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A AircraftRef.
 */
@Entity
@Table(name = "aircraft_ref")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class AircraftRef implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code")
    private String code;

    @ManyToOne
    @JsonIgnoreProperties(value = { "types" }, allowSetters = true)
    private AircraftTypeRef aircraftTypeRef;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AircraftRef id(Long id) {
        this.id = id;
        return this;
    }

    public String getCode() {
        return this.code;
    }

    public AircraftRef code(String code) {
        this.code = code;
        return this;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public AircraftTypeRef getAircraftTypeRef() {
        return this.aircraftTypeRef;
    }

    public AircraftRef aircraftTypeRef(AircraftTypeRef aircraftTypeRef) {
        this.setAircraftTypeRef(aircraftTypeRef);
        return this;
    }

    public void setAircraftTypeRef(AircraftTypeRef aircraftTypeRef) {
        this.aircraftTypeRef = aircraftTypeRef;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AircraftRef)) {
            return false;
        }
        return id != null && id.equals(((AircraftRef) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "AircraftRef{" +
            "id=" + getId() +
            ", code='" + getCode() + "'" +
            "}";
    }
}
