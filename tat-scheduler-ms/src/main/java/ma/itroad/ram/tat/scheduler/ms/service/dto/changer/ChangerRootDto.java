package ma.itroad.ram.tat.scheduler.ms.service.dto.changer;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public class ChangerRootDto implements Serializable {

        @JsonProperty("changes")
        public NetlineInstantChangerDto netlineInstantChangerDto;

        public NetlineInstantChangerDto getNetlineInstantChangerDto() {
            return netlineInstantChangerDto;
        }

        public void setNetlineInstantChangerDto(NetlineInstantChangerDto netlineInstantChangerDto) {
            this.netlineInstantChangerDto = netlineInstantChangerDto;
        }
    }
