package ma.itroad.ram.tat.scheduler.ms.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import ma.itroad.ram.tat.scheduler.ms.dto.TatInfoDto;
import ma.itroad.ram.tat.scheduler.ms.proxy.BusinessProxy;
import ma.itroad.ram.tat.scheduler.ms.proxy.CorefProxy;
import ma.itroad.ram.tat.scheduler.ms.proxy.TaskBusinessProxy;

import java.util.HashMap;
import java.util.List;

@Configuration
@EnableScheduling
@ConditionalOnProperty(name="sheduling.enabled",matchIfMissing = true)
public class ScheduledTasks {

    @Autowired
    BusinessProxy businessProxy;

    @Autowired
    CorefProxy corefProxy;




    @Scheduled(fixedDelayString = "PT1M")


    void affectTasksToTat(){
        try {
            //List<TatInfoDto> listTat = businessProxy.getTatsWithNoTasks();
           // System.out.println("first tat");
            //System.out.println(listTat.get(0));
            System.out.println("started task affectation");
            businessProxy.postTats();
            //System.out.println("listTat get OK , number of TAts "+listTat.size());
            //HashMap<TatInfoDto,List<Object>> tatMap = new HashMap<>();
        }
        catch (Exception e )
        {
            System.out.println(e);
        }

        //CALL COREF getTasks and Standards by TatType,FlightType & aircraftType




        //CALL TASK_BUSINESS to Affect tasks to Tat

    }

}
