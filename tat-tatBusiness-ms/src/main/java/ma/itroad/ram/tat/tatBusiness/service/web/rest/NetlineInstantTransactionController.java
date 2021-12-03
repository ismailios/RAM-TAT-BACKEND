package ma.itroad.ram.tat.tatBusiness.service.web.rest;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ma.itroad.ram.tat.tatBusiness.service.domain.NetlineInstantTransaction;
import ma.itroad.ram.tat.tatBusiness.service.dtos.changer.ChangerRootDto;
import ma.itroad.ram.tat.tatBusiness.service.dtos.changer.InstantTransactionDto;
import ma.itroad.ram.tat.tatBusiness.service.dtos.changer.NetlineInstantChangerDto;
import ma.itroad.ram.tat.tatBusiness.service.dtos.mappers.InstantTransactionMapper;
import ma.itroad.ram.tat.tatBusiness.service.repository.NetlineInstantTransactionRepository;
import ma.itroad.ram.tat.tatBusiness.service.service.NetlineInstantTransactionService;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/tatBusiness")
public class NetlineInstantTransactionController {

    @Autowired
    NetlineInstantTransactionService netlineInstantTransactionService;

    @Autowired
    InstantTransactionMapper instantTransactionMapper;

    @Autowired
    NetlineInstantTransactionRepository netlineInstantTransactionRepository;

    LocalDateTime nowLog = LocalDateTime.now();

    @RequestMapping(value="/insertInstantMessage",method= RequestMethod.POST)
    public List<InstantTransactionDto> storeInstantMessage(@RequestBody NetlineInstantChangerDto dto){

          List<InstantTransactionDto> transactionDtos = dto.getTransactions();
          List<NetlineInstantTransaction>  transactions = instantTransactionMapper.toEntity(transactionDtos);
//
//        for(NetlineInstantTransaction transaction : transactions){
//            netlineInstantTransactionService.applyInstantChanges(transaction);
//        }
            return transactionDtos;
            //return transactions;
        }
        //the used one
        @RequestMapping(value="/transactionChange",method= RequestMethod.POST)
        public ResponseEntity<String>storeInstantMessage2(@RequestBody ChangerRootDto dto){
            if (dto.getNetlineInstantChangerDto()==null)
                return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body("unvalid change message");
            else
                {List<InstantTransactionDto> transactionDtos = dto.getNetlineInstantChangerDto().getTransactions();
                if(transactionDtos !=null) {
                    List<NetlineInstantTransaction> transactions = instantTransactionMapper.toEntity(transactionDtos);

                    transactions=netlineInstantTransactionService.sortTransactions(transactions);
                    int created = 0;
                    int updated=0;
                    int noAction=0;
                    for (NetlineInstantTransaction transaction : transactions) {
                        System.out.println(nowLog+" Start :");
                    netlineInstantTransactionRepository.save(transaction);
                    System.out.println(nowLog+" transaction saved at db (legNO: "+transaction.getLegNo()+ ")");
                    String s = netlineInstantTransactionService.applyInstantChanges(transaction);
                    if(s.equals("UPDATE"))
                        updated++;
                    else if(s.equals("CREATE"))
                        created++;
                    else if (s.equals("NO_ACTION"))
                        noAction++;;

                    }
                    System.out.println(nowLog+" number of transactions : "+transactions.size());
                    System.out.println(nowLog+ " number of updated flights:  "+updated);
                    System.out.println(nowLog+ " number of new created flights: "+created);
                    System.out.println(nowLog+ " number of ignored transactions: "+noAction);
                return ResponseEntity.status(HttpStatus.CREATED).body("created");
                 }
                 else
                    return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body("unvalid change message");
            }
        }

}
