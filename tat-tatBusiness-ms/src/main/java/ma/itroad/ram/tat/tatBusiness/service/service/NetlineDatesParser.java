package ma.itroad.ram.tat.tatBusiness.service.service;

import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Service
public class NetlineDatesParser {

    public LocalDateTime dateTimeParser(String day, String time){
        String str;
        LocalTime timePart = timeParser(time);
        LocalDate datePart=dateParser(day);

        if(datePart !=null && timePart !=null)
        {LocalDateTime dt = LocalDateTime.of(datePart, timePart);
        return dt;}
        else return null;
    }

    public LocalDate dateParser(String day){
        try{
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
            LocalDate date=LocalDate.parse(day,formatter);
            return date;
        }
        catch(Exception e){
            return null;
        }

    }
    public LocalTime timeParser(String time){
        try{
            String str=null;
            switch(time.length()) {
                case 1:
                    str="00:0"+time.charAt(0);
                    break;
                case 2:
                    str="00:"+time.charAt(0)+time.charAt(1);
                    break;
                case 3:
                    str="0"+time.charAt(0)+":"+time.charAt(1)+time.charAt(2);
                    break;
                case 4:
                    str=time.charAt(0)+""+time.charAt(1)+":"+time.charAt(2)+time.charAt(3);
                    break;
            }
            return LocalTime.parse(str);
        }
        catch(Exception e){
            return null;
        }

    }
    LocalDate parseTransactionDate(String sDate){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(sDate,formatter);
        return date;
    }


}
