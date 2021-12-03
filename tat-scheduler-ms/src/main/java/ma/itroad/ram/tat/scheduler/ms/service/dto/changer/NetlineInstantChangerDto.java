package ma.itroad.ram.tat.scheduler.ms.service.dto.changer;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NetlineInstantChangerDto implements Serializable {
    @JsonProperty("transaction")
    public List<InstantTransactionDto> transactions;

    public List<InstantTransactionDto> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<InstantTransactionDto> transactions) {
        this.transactions = transactions;
    }
}
