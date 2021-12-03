package ma.itroad.ram.tat.tatBusiness.service.service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ma.itroad.ram.tat.tatBusiness.service.domain.Tat;
import ma.itroad.ram.tat.tatBusiness.service.dtos.TatInfoDto;
import ma.itroad.ram.tat.tatBusiness.service.repository.TaskRepository;
import ma.itroad.ram.tat.tatBusiness.service.repository.TatRepository;

@Service
public class TatService {

    @Autowired
    TatRepository tatRepository;

    @Autowired
    TaskRepository taskRepository;

    @Value("${local-airport}")
    String LOCALAIRPORT;

    @Value("${flight-start}")
    int startDefault;

    @Value("${flight-end}")
    int endDefault;

    public Page<Tat> findTatsByType(String type, Pageable page){
        return tatRepository.findTatsByType(type,page);
    }

    public Tat saveTat(Tat tat){
        tatRepository.save(tat);
        return tat;
    }

    public Page<Tat> findAllTats(Pageable page){
        LocalDateTime startDate= LocalDateTime.now().minusHours(startDefault);
        LocalDateTime endDate= LocalDateTime.now().plusHours(endDefault);
        return tatRepository.findAllValidTats(LOCALAIRPORT,startDate,endDate,page);
    }

    public Page<Tat> filterTats( String[] tatType, String isRam,
                                      String param, LocalDateTime startDate, LocalDateTime endDate,
                                      int interval, Pageable page){
        String tatType0="0";
        String tatType1="1";
        String tatType2="2";

        switch (tatType.length){
             case 0:
                 tatType0="0";
                 tatType1="1";
                 tatType2="2";
                 break;
            case 1:
                tatType0=tatType[0];
                tatType1=tatType[0];
                tatType2="2";
                break;
            case 2:
                tatType0=tatType[0];
                tatType1=tatType[1];
                tatType2=tatType[1];
                break;
            case 3:
                tatType0=tatType[0];
                tatType1=tatType[1];
                tatType2=tatType[2];
                break;

        }



            if(interval >0){
                startDate = LocalDateTime.now();
                endDate = LocalDateTime.now().plusHours(interval)  ;
            }
            else if (interval<0){
                startDate = LocalDateTime.now().minusHours(-interval)  ;
                endDate = LocalDateTime.now();
            }


        Page<Tat> filteredTats = tatRepository.filterTats(tatType0,tatType1,tatType2,isRam,param,
                LOCALAIRPORT,
                startDate,endDate
                ,page);
        return filteredTats;
    }

    public Page<Tat> filterByRegistrationOrFlightNumber(String param,Pageable page){
        return tatRepository.filterbyRegistrationOrFlightNumber(param,page);
    }


    public List<TatInfoDto> getTatsWithNoTasks() {
        return tatRepository.getTatsWithNoTasks();
    }

    public void enableHasTasks(long id) {
        Tat tat=tatRepository.findById(id).get();
        tat.setHasTasks(true);
        tatRepository.save(tat);
        System.out.println("tat with id: "+id+" has now tasks");
    }

    public Tat findTatById(long id) {
        if (tatRepository.findById(id).isPresent())
        return tatRepository.findById(id).get();
        else return null;
    }

    public Page<Tat> filterMyTats( int userId,String[] tatType, String isRam,
                                 String param, LocalDateTime startDate, LocalDateTime endDate,
                                 int interval, Pageable page){
        String tatType0="0";
        String tatType1="1";
        String tatType2="2";

        switch (tatType.length){
            case 0:
                tatType0="0";
                tatType1="1";
                tatType2="2";
                break;
            case 1:
                tatType0=tatType[0];
                tatType1=tatType[0];
                tatType2="2";
                break;
            case 2:
                tatType0=tatType[0];
                tatType1=tatType[1];
                tatType2=tatType[1];
                break;
            case 3:
                tatType0=tatType[0];
                tatType1=tatType[1];
                tatType2=tatType[2];
                break;

        }



        if(interval >0){
            startDate = LocalDateTime.now();
            endDate = LocalDateTime.now().plusHours(interval)  ;
        }
        else if (interval<0){
            startDate = LocalDateTime.now().minusHours(-interval)  ;
            endDate = LocalDateTime.now();
        }


        Page<Tat> filteredTats = tatRepository.filterMyTats(userId,tatType0,tatType1,tatType2,isRam,param,
                LOCALAIRPORT,
                startDate,endDate
                ,page);
        return filteredTats;
    }


    public List<Tat> findNonObsoleteTats() {
        return tatRepository.getAllNonObsoleteTats();
    }

    public float tatProgress(long tatId){

        try {return taskRepository.findTatProgress(tatId);
                //taskRepository.tatProgressDuration(tatId)/ taskRepository.tatDuration(tatId) ;
        }
        catch (Exception e){ return -1;}
    }

    public long findTatDuration(long tatId) {
        return ChronoUnit.MINUTES.between(taskRepository.getStartTat(tatId),taskRepository.getEndTat(tatId));
    }
    public float timeProgress(long tatId) {
        if(taskRepository.getStartTat(tatId)==null)
            return 0;
        long consumedTime=ChronoUnit.MINUTES.between(taskRepository.getStartTat(tatId),LocalDateTime.now());
        float timeProgress= consumedTime/findTatDuration(tatId);
        return 100*timeProgress;
    }
    public int potentialDelay(long tatId){
      if(timeProgress(tatId)<=0)
          return 0;
      else if(timeProgress(tatId)>1 && tatProgress(tatId)<100 )
          return 2;
      else if(timeProgress(tatId)<1 && timeProgress(tatId)>tatProgress(tatId))
          return 1;
      else return 0;
    }
}
