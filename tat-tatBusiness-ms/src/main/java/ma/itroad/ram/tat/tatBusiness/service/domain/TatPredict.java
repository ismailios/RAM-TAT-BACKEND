package ma.itroad.ram.tat.tatBusiness.service.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="tat_predict")
public class TatPredict {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "tat_type")
    public String tatType;

    @Column(name="tat_arr_ref")
    public String arrRef;

    @Column(name="tat_dep_ref")
    public String depRef;

    @Column(name="tat_fn_number")
    public int fnNUmber;

    @Column(name="tat_ac_registration")
    public String acRegistration;

    @Column(name="tat_ac_subtype")
    public String acSubType;

    @Column(name="tat_ac_owner")
    public String acOwner;

    @Column(name="tat_owner_category")
    public String ownerCategory;

    @Column(name="tat_leg_type")
    public String legType;

    @Column(name="tat_flight_category")
    public String flightCategory;

    @Column(name="tat_aircraft_type")
    public String  aircraftType;

    @Column(name="tat_arr_ap_actual")
    public String arrApActual;

    @Column(name="tat_dep_ap_actual")
    public String depApActual;

    @Column(name="tat_year")
    public int year;

    @Column(name="tat_month")
    public int month;

    @Column(name="tat_season")
    public String season;

    @Column(name="tat_day_of_the_week")
    public int dayOfTheWeek;

    @Column(name="tat_time_of_day")
    public int timeOfDay;

    @Column(name="scheduled_Tat")
    public long scheduledTat;

    @Column(name="available_tat")
    public long availableTat;

    @Column(name="tat_task_number")
    public int taskNUmber;

    @Column(name="tat_delay")
    public long delay;

    @Column(name="tat_aircraft_capacity")
    public int capacity;

    @Column(name="tat_filling_out")
    public int fillingOut;
    @Column(name="tat_filling_out_j")
    public int fillingOutJ;
    @Column(name="tat_filling_out_y")
    public int fillingOutY;

    @Column(name="tat_filling_in")
    public int fillingIn;
    @Column(name="tat_filling_in_j")
    public int fillingInJ;
    @Column(name="tat_filling_in_y")
    public int fillingInY;

    @Column(name="luggage_out_kg")
    public  int luggageOutKg;
    @Column(name="luggage_out_unit")
    public  int luggageOutUnit;

    @Column(name="luggage_in_kg")
    public  int luggageIntKg;
    @Column(name="luggage_in_unit")
    public  int luggageInUnit;


}
