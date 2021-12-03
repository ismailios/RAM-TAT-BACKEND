package ma.itroad.ram.tat.coref.service.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

import ma.itroad.ram.tat.coref.service.domain.converters.ArrayListToStringConverter;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A DelayReasonRef.
 */
@Entity
@Table(name = "delay_reason_ref")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class DelayReasonRef implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name="type")
    public String type;

    @Column(name="detail_list")
    @Convert(converter = ArrayListToStringConverter.class)
    public List<String> detailList;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="task_id",referencedColumnName = "id")
    private TaskRef task = new TaskRef();

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DelayReasonRef id(Long id) {
        this.id = id;
        return this;
    }

    public String getCode() {
        return this.code;
    }

    public DelayReasonRef code(String code) {
        this.code = code;
        return this;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return this.name;
    }

    public DelayReasonRef name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public DelayReasonRef description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DelayReasonRef)) {
            return false;
        }
        return id != null && id.equals(((DelayReasonRef) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "DelayReasonRef{" +
            "id=" + getId() +
            ", code='" + getCode() + "'" +
            ", name='" + getName() + "'" +
            ", description=" + getDescription() +
            "}";
    }
}
