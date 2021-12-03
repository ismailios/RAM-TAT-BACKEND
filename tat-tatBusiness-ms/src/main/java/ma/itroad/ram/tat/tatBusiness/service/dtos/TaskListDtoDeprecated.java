package ma.itroad.ram.tat.tatBusiness.service.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ma.itroad.ram.tat.tatBusiness.service.domain.Task;
import ma.itroad.ram.tat.tatBusiness.service.domain.enums.StatusEnum;
import ma.itroad.ram.tat.tatBusiness.service.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.function.Predicate;

import static ma.itroad.ram.tat.tatBusiness.service.domain.enums.StatusEnum.finished;

@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaskListDtoDeprecated {


    //Alert Type 0 : no alert , 1 minor alert , 2 major alert

    public List<Task> tasks;
    public LocalDateTime startDate ;
    public LocalDateTime endDate ;
    public double listProgress;
    public int alertType ;
    public int finishedTasks;
    public int numberOfTasks;



    public TaskListDtoDeprecated(List<Task> tasks) {
        this.tasks = tasks;
    }

    public int getFinishedTasks() {
        return (int) tasks.stream().filter(task -> finished(task.getStatus())).count();
    }

    public int getNumberOfTasks(){
        return this.tasks.size();
    }

    public LocalDateTime getStartDate() {
        if(tasks.size()>0) {
            //tasks.removeIf(task -> (task.isNotApplicable()));
            try{

            return tasks.stream().map(u -> u.getStartDateCalculated()).min(LocalDateTime::compareTo).get();}
            catch (Exception e){
                return null;
            }
        }
        else
        return null;
    }

    public LocalDateTime getEndDate() {
        if(tasks.size()>0) {
            try {
                return tasks.stream().map(u -> u.getEndDateCalculated()).max(LocalDateTime::compareTo).get();
            } catch (Exception e) {
                return null;
            }
        }
        else
        return null;
    }


    public void add(Task task){
        this.tasks.add(task);

    }

    int sumDurations(){
        int d=0;
        for(Task task : tasks){
            if(!task.isNotApplicable())
            d+=task.getDuration();
        }
        return d;
    }

    public int alertType(long d){
        if(d>=1 && d<5)
            return 1;
        else if (d>=5)
            return 2;
        else return 0;
    }
    public int generateAlertType(Task task) {
        //if(this.notApplicable) return null;
        int alertType=0;
        String status=task.getStatus();
        LocalDateTime endDateCalculated=task.getEndDateCalculated();
        LocalDateTime startDateCalculated=task.getStartDateCalculated();
        LocalDateTime endDateActual=task.getEndDateActual();
        LocalDateTime startDateActual= task.getStartDateActual();
        Instant instant = Instant.now();
        LocalDateTime nowDate = LocalDateTime.ofInstant(instant, ZoneOffset.UTC);
        StatusEnum statusEnum=StatusEnum.valueOf(status);
        switch (statusEnum) {
            case NON_STARTED: {
                if(nowDate.isAfter(startDateCalculated)) {
                    long diff = ChronoUnit.MINUTES.between(startDateCalculated, nowDate);
                    alertType = alertType(diff);
                }
                break;
            }

            case IN_PROGRESS: {
                if (nowDate.isAfter(endDateCalculated)) {
                    long diff = ChronoUnit.MINUTES.between(endDateCalculated, nowDate);
                    alertType = alertType(diff);
                }
                if (startDateActual.isAfter(startDateCalculated) && alertType==0) {
                    long diff = ChronoUnit.MINUTES.between(startDateCalculated, startDateActual);
                    alertType = alertType(diff);
                }
                break;

            }
            case FINISHED : {
                if (endDateActual.isAfter(endDateCalculated)) {
                    long diff = ChronoUnit.MINUTES.between(endDateCalculated, endDateActual);
                    alertType = alertType(diff);
                }
                break;
            }
        }
        task.setAlertType(alertType);
        return alertType;

    }

    public void generateProgressAndAlerts(){
        double p=0;
        int a=0;
        int max=0;
        for(Task task: this.tasks){
            if(!task.isNotApplicable())
            {p+=task.getProgress()*task.getDuration();
            a=generateAlertType(task);
            if(a>max) max=a;
            }
        }
        this.listProgress= p/sumDurations();
        this.alertType=max;
    }






}
