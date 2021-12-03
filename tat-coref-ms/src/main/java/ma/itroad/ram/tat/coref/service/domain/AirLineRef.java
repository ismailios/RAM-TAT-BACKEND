package ma.itroad.ram.tat.coref.service.domain;

import java.io.Serializable;
import javax.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;



/**
 * A AirLineRef.
 */
@Entity
@Table(name = "air_line_ref")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)

public class AirLineRef implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code_iata")
    private String codeIata;

    @Column(name = "code_oaci")
    private String codeOaci;

    @Column(name = "name")
    private String name;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AirLineRef id(Long id) {
        this.id = id;
        return this;
    }

    public String getCodeIata() {
        return this.codeIata;
    }

    public AirLineRef codeIata(String codeIata) {
        this.codeIata = codeIata;
        return this;
    }

    public void setCodeIata(String codeIata) {
        this.codeIata = codeIata;
    }

    public String getCodeOaci() {
        return this.codeOaci;
    }

    public AirLineRef codeOaci(String codeOaci) {
        this.codeOaci = codeOaci;
        return this;
    }

    public void setCodeOaci(String codeOaci) {
        this.codeOaci = codeOaci;
    }

    public String getName() {
        return this.name;
    }

    public AirLineRef name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AirLineRef)) {
            return false;
        }
        return id != null && id.equals(((AirLineRef) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "AirLineRef{" +
            "id=" + getId() +
            ", codeIata='" + getCodeIata() + "'" +
            ", codeOaci='" + getCodeOaci() + "'" +
            ", name='" + getName() + "'" +
            "}";
    }
}
