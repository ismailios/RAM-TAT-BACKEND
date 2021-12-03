package ma.itroad.ram.tat.tatBusiness.service.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RoleRefDto {
    @JsonProperty("role")
    public String role;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
