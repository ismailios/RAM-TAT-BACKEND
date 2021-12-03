package ma.itroad.ram.tat.thirdPartyConnectors.service.dto.changer;

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
public class InstantTransactionDto implements Serializable {

    @JsonProperty("@xsi:schemaLocation")
    public String xsiSchemaLocation;

    @JsonProperty("sender")
    public String sender;

    @JsonProperty("created")
    public LocalDateTime created;

    @JsonProperty("messages")
    public InstantMessage message;

    public String getXsiSchemaLocation() {
        return xsiSchemaLocation;
    }

    public void setXsiSchemaLocation(String xsiSchemaLocation) {
        this.xsiSchemaLocation = xsiSchemaLocation;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public InstantMessage getMessage() {
        return message;
    }

    public void setMessage(InstantMessage message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "InstantTransactionDto{" +
                "xsiSchemaLocation='" + xsiSchemaLocation + '\'' +
                ", sender='" + sender + '\'' +
                ", created=" + created +
                '}';
    }
}