package ma.itroad.ram.tat.tatBusiness.service.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoleDto {

    @JsonProperty("name")
    public String name;

    public String getName() {
        return name;
    }

    public String generateName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
