package ma.itroad.ram.tat.coref.service.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import ma.itroad.ram.tat.coref.service.domain.enumeration.LegEnum;

/**
 * A FlightTypeRef.
 */
@Entity
@Table(name = "flight_type_ref")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class FlightTypeRef implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code")
    private String code;

    @Column(name = "label")
    private String label;

    @Enumerated(EnumType.STRING)
    @Column(name = "leg")
    private LegEnum leg;

    @ManyToMany(mappedBy = "refFlightTypes")
    private Set<TaskRef> tasks = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public FlightTypeRef id(Long id) {
        this.id = id;
        return this;
    }

    public String getCode() {
        return this.code;
    }

    public FlightTypeRef code(String code) {
        this.code = code;
        return this;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLabel() {
        return this.label;
    }

    public FlightTypeRef label(String label) {
        this.label = label;
        return this;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public LegEnum getLeg() {
        return this.leg;
    }

    public FlightTypeRef leg(LegEnum leg) {
        this.leg = leg;
        return this;
    }

    public void setLeg(LegEnum leg) {
        this.leg = leg;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof FlightTypeRef)) {
            return false;
        }
        return id != null && id.equals(((FlightTypeRef) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "FlightTypeRef{" +
            "id=" + getId() +
            ", code='" + getCode() + "'" +
            ", label='" + getLabel() + "'" +
            ", leg='" + getLeg() + "'" +
            "}";
    }
}
