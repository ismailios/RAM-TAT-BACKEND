package ma.itroad.ram.tat.coref.service.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.DynamicUpdate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * A ResourceRef.
 */
@Getter
@Setter
@DynamicUpdate
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "resource_ref")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class ResourceRef implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "id_resource")
	private String idResource;

	@Column(name = "name")
	private String name;

	@Column(name = "role")
	private String role;

	@OneToOne
	private UserRef userRef;

	// jhipster-needle-entity-add-field - JHipster will add fields here
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ResourceRef id(Long id) {
		this.id = id;
		return this;
	}

	public String getIdResource() {
		return this.idResource;
	}

	public ResourceRef idResource(String idResource) {
		this.idResource = idResource;
		return this;
	}

	public void setIdResource(String idResource) {
		this.idResource = idResource;
	}

	public String getName() {
		return this.name;
	}

	public ResourceRef name(String name) {
		this.name = name;
		return this;
	}

	public void setName(String name) {
		this.name = name;
	}

	// jhipster-needle-entity-add-getters-setters - JHipster will add getters and
	// setters here

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof ResourceRef)) {
			return false;
		}
		return id != null && id.equals(((ResourceRef) o).id);
	}

	@Override
	public int hashCode() {
		// see
		// https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
		return getClass().hashCode();
	}

	// prettier-ignore
	@Override
	public String toString() {
		return "ResourceRef{" + "id=" + getId() + ", idResource='" + getIdResource() + "'" + ", name='" + getName()
				+ "'" + ", role='" + getRole() + "'" + "}";
	}
}
