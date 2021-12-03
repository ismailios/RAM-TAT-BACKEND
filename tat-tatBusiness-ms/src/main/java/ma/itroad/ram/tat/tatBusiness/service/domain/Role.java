package ma.itroad.ram.tat.tatBusiness.service.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    public String name ;

    @ManyToMany(mappedBy = "roles")
    @JsonIgnore
    Set<Task> taskSet;

    public Role(String name) {

        this.name = name;
    }
}
