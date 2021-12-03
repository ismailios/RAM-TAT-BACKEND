package ma.itroad.ram.tat.tatBusiness.service.domain;


import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="tats")
public class Tat {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "tatType")
        private String tatType;

        @Column(name="Obsolete")
        private int obsolete;

        @Column(name="has_tasks", nullable = false)
        private boolean hasTasks = false;

        @Column(name="tat_start_date")
        private LocalDateTime startDate;

        @Column(name="tat_end_date")
        private LocalDateTime endDate;

        @Column(name="duration")
        private long duration =0;

        @Column(name="progress")
        private double progress;

        @Column(name="fuel_quantity")
        public double fuelQuantity;

        @Column(name="trip")
        public double trip;

        @Column(name="taxi")
        public double taxi;

//        @Column(name="has_crew", nullable = false)
//        private boolean hasCrew = false;

        
        @OneToOne
        private OndaInfo ondainfo;
        
        @OneToOne
        private FlightSitatx flightSitatx;
        
        @OneToOne
        private LoadSheet loadSheet;
        
        @OneToOne(mappedBy = "tat" ,cascade = CascadeType.ALL)
        private PassengerInfo passengerInfo;

        
        
        @OneToMany(mappedBy = "tat")
        @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
        @JsonIgnoreProperties(value = { "task" }, allowSetters = true)
        private Set<CrewMember> crewMember = new HashSet<>();
        
        
        

        @JsonIgnore
        @OneToMany( mappedBy = "tat")
         private Set<Flight> flights = new HashSet<>();

         public Set<Flight> getFlights() {return flights;}

         public String getTatType() {
        return tatType;
    }

          public void setTatType(String tatType) {
        this.tatType = tatType;
    }



    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }


    public Tat(String tatType, Set<Flight> flights) {
        this.tatType = tatType;
        this.flights = flights;
    }
    public void clearTat(){
             this.flights.clear();
    }

    public void setFlights(Set<Flight> flights) {
        this.flights = flights;
    }
    public void addOneFlight(Flight flight) {
        this.flights.add(flight);
    }
    public void deleteOneFlight(Flight flight){this.flights.remove(flight);}

    public boolean isDep(){
         return this.tatType.equals("Dep");
    }
    public boolean isArr(){
        return this.tatType.equals("Arr");
    }
    public boolean isArrDep(){return this.tatType.equals("ArrDep");}

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Tat{" +
                "id=" + id +
                ", tatType='" + tatType + '\'' +
                ", obsolete=" + obsolete +'}';
    }









}
