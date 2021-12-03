package ma.itroad.ram.tat.tatBusiness.service.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {


    @JsonProperty("username")
    private String username;

    @JsonProperty("empno")
    private String empno;

    @JsonProperty("role")
    private String role;

    @JsonProperty("firstName")
    private String firstName;

    @JsonProperty("lastName")
    private String lastName;

    @Override
    public String toString() {
        return "UserDto{" +
                "username='" + username + '\'' +
                ", empno='" + empno + '\'' +
                ", role='" + role + '\'' +
                '}';
    }


	
}
