package ma.itroad.ram.tat.scheduler.ms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.itroad.ram.tat.scheduler.ms.domain.NetlineInstantTransaction;
import ma.itroad.ram.tat.scheduler.ms.repository.NetlineTransactionRepository;

@Service
public class NetlineInstantTransactionService {

    @Autowired
    NetlineTransactionRepository netlineTransactionRepository;

    public void saveTransaction(NetlineInstantTransaction transaction){
        netlineTransactionRepository.save(transaction);
    }
}
