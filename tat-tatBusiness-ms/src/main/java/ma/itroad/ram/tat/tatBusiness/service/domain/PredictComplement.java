package ma.itroad.ram.tat.tatBusiness.service.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
@Getter
@Setter
@DynamicUpdate
public class PredictComplement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="flight")
    private String flight;

    @Column(name="flight_number")
    private String flightNumber;

    @Column(name="departure_date")
    private LocalDate departureDate;

    @Column(name="nat_key")
    private String natKey;

    @Column(name="aircraft_subtype")
    private String aircraftSubtype;

    @Column(name="board_point")
    private String departure;

    @Column(name="off_point")
    private String arrival;

    @Column(name="capacity_y")
    private int capacityEco;

    @Column(name="capacity_j")
    private int capacityBusiness;

    @Column(name="total_capacity")
    private int totalCapacity;

    @Column(name="filling_y")
    private int filingEco;

    @Column(name="filling_j")
    private int fillingBusiness;

    @Column(name="total_filling")
    private int totalFilling;

    @Column(name="luggage_kg")
    private int luggageKg;

    @Column(name="luggage_unit")
    private int luggageUnit;

    @Column(name="vip")
    private boolean vip;




}
