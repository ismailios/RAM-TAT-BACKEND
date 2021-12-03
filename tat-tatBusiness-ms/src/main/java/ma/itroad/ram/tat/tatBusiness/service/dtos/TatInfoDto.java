package ma.itroad.ram.tat.tatBusiness.service.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;


public interface TatInfoDto  {

    public Long getId();
    public String getTatType();
    public String getLegType();
    public String getAcSubType();


}
