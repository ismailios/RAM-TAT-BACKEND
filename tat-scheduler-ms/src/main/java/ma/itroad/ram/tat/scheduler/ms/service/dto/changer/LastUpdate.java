package ma.itroad.ram.tat.scheduler.ms.service.dto.changer;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LastUpdate implements Serializable {

    @JsonProperty("userId")
    public String userId;

    @JsonProperty("timestamp")
    public LocalDateTime timestamp;

    @JsonProperty("updateKey")
    public String updateKey;

    @JsonProperty("updateNo")
    public String updateNo;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getUpdateKey() {
        return updateKey;
    }

    public void setUpdateKey(String updateKey) {
        this.updateKey = updateKey;
    }

    public String getUpdateNo() {
        return updateNo;
    }

    public void setUpdateNo(String updateNo) {
        this.updateNo = updateNo;
    }
}
