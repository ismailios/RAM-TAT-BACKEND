package ma.itroad.ram.tat.tatBusiness.service.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ma.itroad.ram.tat.tatBusiness.service.domain.Flight;

import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight,Long>  {

   @Query("SELECT DISTINCT f FROM Flight f  WHERE f.uniqueCode = :code order by dayOfOrigin desc ")
   List<Flight> findingFlightByUniqueCode(@Param("code") String code);


   @Query("SELECT  f FROM Flight f  WHERE f.acRegistration = :code and arrApActual=:localAirport " +
           "and legState!='CNL' and legState!='RTR' " +
           "and depApActual!=:localAirport " +
           "and (arrEstAsDateTime<:dateTime OR onblockAsDateTime<:dateTime ) " +
           "order by case when onblockAsDateTime is not null then onblockAsDateTime else arrEstAsDateTime end desc, " +
           "arrSchedAsDateTime desc")
   List<Flight> findLatestArrivalOfAircraft(@Param("code") String code,
                                            @Param("dateTime") LocalDateTime dateTime,
                                            @Param("localAirport") String localAirport,
                                            Pageable page);


   @Query(  "SELECT  f FROM Flight f  WHERE f.acRegistration = :code and f.depApActual=:localAirport " +
           "and legState!='CNL' and legState!='RTR' " +
           "and f.arrApActual!=:localAirport " +
           "and (f.depEstAsDateTime>:dateTime )" +
           "order by depEstAsDateTime asc, " +
           "depSchedAsDateTime asc ")
   List<Flight> findNearestDepartureOfAircraft(@Param("code") String code,
                                               @Param("dateTime") LocalDateTime dateTime,
                                               @Param("localAirport")String localAirport,
                                               Pageable page);

   @Query("SELECT f FROM Flight f  where f.tat is not null and f.legState != 'CNL' and " +
           "(( f.depEstAsDateTime>:startDate and f.depEstAsDateTime <:endDate and depApActual=:localAirport) OR"+
           "(f.arrEstAsDateTime>:startDate and f.arrEstAsDateTime <:endDate and arrApActual=:localAirport)) "+
           "GROUP BY depApActual , id " +
           "ORDER BY  " +
           "CASE when (depApActual=:localAirport) then depEstAsDateTime " +
           " when (arrApActual=:localAirport) then arrEstAsDateTime else depEstAsDateTime end asc " +
           ", acRegistration asc ")
   Page<Flight> findAllFLights(@Param("startDate")LocalDateTime startDate,
                               @Param("endDate")LocalDateTime endDate,
                               @Param("localAirport") String localAirport,
                               Pageable pageable);

      //filtering flights
   @Query("SELECT f FROM Flight f WHERE :tatType is null and f.tat is not null and " +
           "((:ac_registration is null OR f.acRegistration like %:ac_registration% ) "
          // + "AND (f.tat in "
           //+ "(SELECT t FROM tats t WHERE (:tatType is null OR t.tatType like %:tatType% )"
           //+ ")"
           //+ ")"
           + "AND(:fncarrier is null OR f.fnCarrier like %:fncarrier%)"
           + "AND(:fnNumber is null OR f.fnNumber like %:fnNumber%)"
           + "AND(:isram is null OR f.isRam like %:isram%)"
           + "AND ( (:datedebut2 is null and :datefin2 is null) "
          // + "OR ("
          // + "(f.depEstAsDateTime >= :datedebut2) AND ( f.depEstAsDateTime <= :datefin2 )"
          // + ")"
           //+ "OR ("
           //+ "(f.arrEstAsDateTime >= :datedebut2) AND (f.arrEstAsDateTime  <= :datefin2)"
           //+ ")"
           + ")"
           + "AND( (:Curentdate2 is null and :date2 is null )"
           //+ "OR ("
           //+ "(f.arrEstAsDateTime  >= :Curentdate2) AND (f.arrEstAsDateTime <= :date2)"
           //+ ")"
           //+ "OR ("
           //+ "(f.depEstAsDateTime >=  :Curentdate2) AND (f.depEstAsDateTime <= :date2)"
           //+ ")"
           + ")"
           + ")"

   )
   List<Flight> findUserByParams(
           @Param("ac_registration") String ac_registration ,
           @Param("tatType") String tatType,
           @Param("fncarrier") String fncarrier,
           @Param("fnNumber")String fnNumber,
           @Param("datedebut2") LocalDateTime datedebut2,
           @Param("datefin2") LocalDateTime datefin2,
           @Param("Curentdate2") LocalDateTime Curentdate2,
           @Param("date2") LocalDateTime date2,
           @Param("isram") String isram );


   //filtering flights
   @Query(value = "SELECT f FROM Flight f  where f.tat is not null and " +
           " f.acRegistration like %:acRegistration% and " +
           " f.tat.tatType like %:tatType% and "+
           " f.isRam like %:isRam% and "+
           " f.flightNumber like %:flightNumber% and "+
           " f.fnCarrier like %:fnCarrier% and "+
           " f.fnNumber like %:fnNumber% and "+
           "(( f.depEstAsDateTime>:startDate and f.depEstAsDateTime <:endDate and depApActual=:localAirport) OR "+// OR"+
           "(f.arrEstAsDateTime>:startDate and f.arrEstAsDateTime <:endDate and arrApActual=:localAirport)) AND "+
           "(( f.depEstAsDateTime>:customStart and f.depEstAsDateTime <:customEnd and depApActual=:localAirport) OR "+// OR"+
           "(f.arrEstAsDateTime>:customStart and f.arrEstAsDateTime <:customEnd and arrApActual=:localAirport)) "+
           "GROUP BY depApActual , id " +
           "ORDER BY  " +
           "CASE when (depApActual=:localAirport) then depEstAsDateTime " +
           " when (arrApActual=:localAirport) then arrEstAsDateTime else depEstAsDateTime end asc " +
           ", acRegistration asc ")

   Page<Flight> filterFlights(
           @Param("acRegistration") String acRegistration,
           @Param("tatType") String tatType,
           @Param("isRam") String isRam,
           @Param("flightNumber") String flightNumber,
           @Param("fnCarrier") String fnCarrier,
           @Param("fnNumber") String fnNumber,
           @Param("startDate") LocalDateTime startDate,
           @Param("endDate") LocalDateTime endDate,
           @Param("customStart") LocalDateTime customStart,
           @Param("customEnd") LocalDateTime customEnd,
           @Param("localAirport") String localAirport,
           Pageable page );





}
