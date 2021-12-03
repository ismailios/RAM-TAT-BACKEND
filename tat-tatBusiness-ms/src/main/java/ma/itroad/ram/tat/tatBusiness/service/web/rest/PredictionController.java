package ma.itroad.ram.tat.tatBusiness.service.web.rest;

import ma.itroad.ram.tat.tatBusiness.service.domain.Tat;
import ma.itroad.ram.tat.tatBusiness.service.domain.TatPredict;
import ma.itroad.ram.tat.tatBusiness.service.repository.TatPredictRepository;
import ma.itroad.ram.tat.tatBusiness.service.service.PredictionService;
import ma.itroad.ram.tat.tatBusiness.service.service.TatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("tatBusiness")
public class PredictionController {

    @Autowired
    PredictionService predictionService;

    @Autowired
    TatService tatService;

    @Autowired
    TatPredictRepository tatPredictRepository;

    @GetMapping("/prediction")
    public String makeTatPrediction(){
        List<Tat> tatList = new ArrayList<Tat>();
        tatList=tatService.findNonObsoleteTats();
        String s="";
        for (Tat tat: tatList){
            String op=predictionService.generateTatPredict(tat);
            s+=op;

        }
        return s;


   }
}
