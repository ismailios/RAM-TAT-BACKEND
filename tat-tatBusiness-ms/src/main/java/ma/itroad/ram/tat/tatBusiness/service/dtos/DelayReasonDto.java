package ma.itroad.ram.tat.tatBusiness.service.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Convert;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DelayReasonDto implements Serializable {
    
    @JsonProperty( "code")
    private String code;

    @JsonProperty( "name")
    private String name;

    @JsonProperty( "description")
    private String description;

    @JsonProperty("type")
    public String type;

    @JsonProperty("detailList")
    //@Convert(converter = ArrayListToStringConverter.class)
    public List<String> detailList;

    @Override
    public String toString() {
        return this== null ? "null" : "DelayReasonDto{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", type='" + type + '\'' +
                ", detailList=" + detailList +
                '}';
    }

    public DelayReasonDto(String name) {
        this.name = name;
    }
}
