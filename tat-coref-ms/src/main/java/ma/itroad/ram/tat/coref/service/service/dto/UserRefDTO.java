package ma.itroad.ram.tat.coref.service.service.dto;

import java.io.Serializable;
import java.util.Objects;
import javax.validation.constraints.*;

import ma.itroad.ram.tat.coref.service.domain.enumeration.RoleEnum;

/**
 * A DTO for the {@link ma.itroad.ram.tat.coref.service.domain.RoleRef} entity.
 */
public class UserRefDTO implements Serializable {

    private Long id;

    @NotNull
    private String username;

    private String role;

    private String empno;

   
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getEmpno() {
		return empno;
	}

	public void setEmpno(String empno) {
		this.empno = empno;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof UserRefDTO)) {
            return false;
        }

        UserRefDTO userRefDTO = (UserRefDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, userRefDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "UserRefDTO{" +
            "id=" + getId() +
            ", username='" + getUsername() + "'" +
            ", empno='" + getEmpno() + "'" +
            ", role='" + getRole() + "'" +
            "}";
    }
}

