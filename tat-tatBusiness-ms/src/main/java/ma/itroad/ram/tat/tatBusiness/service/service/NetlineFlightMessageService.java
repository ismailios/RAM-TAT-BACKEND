package ma.itroad.ram.tat.tatBusiness.service.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.itroad.ram.tat.tatBusiness.service.domain.NetlineFlightMessage;
import ma.itroad.ram.tat.tatBusiness.service.repository.NetlineFlightMessageRepository;

import java.util.List;

@Service
public class NetlineFlightMessageService {

    @Autowired
    NetlineFlightMessageRepository netlineFlightMessageRepository;

    public void saveNetlineFlightMessage(NetlineFlightMessage message){
        netlineFlightMessageRepository.save(message);
    }
    public List<NetlineFlightMessage> findAllNetlineMessages(){
        return netlineFlightMessageRepository.findAll();
    }
}
