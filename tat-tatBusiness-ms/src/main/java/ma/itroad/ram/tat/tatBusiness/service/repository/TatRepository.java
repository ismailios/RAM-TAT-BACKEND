package ma.itroad.ram.tat.tatBusiness.service.repository;



import ma.itroad.ram.tat.tatBusiness.service.domain.Tat;
import ma.itroad.ram.tat.tatBusiness.service.dtos.TatInfoDto;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TatRepository extends JpaRepository<Tat,Long> {

    @Query("select t from Tat t where t.obsolete=0")
    List<Tat> getAllNonObsoleteTats();
    
    
    @Query("Select t from Tat t  where t.tatType=:type ")
    Page<Tat> findTatsByType(@Param("type") String type, Pageable page);

    @Query(value = "SELECT t FROM Tat t , Flight f  where f.tat = t and " +
            " ( (f.depEstAsDateTime > :startDate and f.depEstAsDateTime < :endDate and t.tatType='Dep' and f.depApActual=:localAirport) OR "+
            " (f.arrEstAsDateTime > :startDate and f.arrEstAsDateTime < :endDate and " +
            " f.arrApActual=:localAirport and  (t.tatType='ArrDep' or t.tatType='Arr')  ) )"+
            "ORDER BY  " +
            "CASE when (t.tatType='Dep' and f.onblockAsDateTime is not null) then f.onblockAsDateTime" +
            " when (t.tatType='Dep' and f.onblockAsDateTime is null and f.depEstAsDateTime is not null) then f.depEstAsDateTime " +
            " when (t.tatType='Dep' and f.onblockAsDateTime is null and f.depEstAsDateTime is null) then f.depSchedAsDateTime" +
            " when ((t.tatType='Arr' or t.tatType='ArrDep') and f.offBlockAsDateTime is not null) then f.offBlockAsDateTime" +
            " when ((t.tatType='Arr' or t.tatType='ArrDep') and f.offBlockAsDateTime is null and f.arrEstAsDateTime is not null) then f.arrEstAsDateTime " +
            " when ((t.tatType='Arr' or t.tatType='ArrDep') and f.offBlockAsDateTime is null and f.arrEstAsDateTime is null) then f.arrSchedAsDateTime  " +
            "else f.depEstAsDateTime end asc " +
            ", f.acRegistration asc "
    )
    Page<Tat> findAllValidTats(            @Param("localAirport") String localAirport,
                                           @Param("startDate") LocalDateTime startDate,
                                           @Param("endDate") LocalDateTime endDate,Pageable page);


    @Query(value ="SELECT t FROM Tat t , Flight f  where f.tat = t and t.tatType is not null and  (" +
            " ( upper(f.acRegistration) like upper(concat('%', :param ,'%')) or upper(f.flightNumber) like upper(concat('%', :param,'%') ))and " +
            " ( (t.tatType like :tatType0 OR :tatType0='0') OR " +
            "   (t.tatType like :tatType1 OR :tatType1='1') OR " +
            "   (t.tatType like :tatType2 OR :tatType2='3')" +
            " ) and "+
            " (f.isRam like %:isRam% ) and "+
            "t in (select t1 from Tat t1,Flight f1 where f1.tat=t1 and "+
            " ( (f1.depEstAsDateTime > :startDate and f1.depEstAsDateTime < :endDate  and f1.depApActual=:localAirport) OR "+
            " (f1.arrEstAsDateTime > :startDate and f1.arrEstAsDateTime < :endDate and f1.arrApActual=:localAirport ) )"+
            ")  " +
            ")"+
            " group by t.tatType,t.id,f.offBlockAsDateTime,f.onblockAsDateTime,f.arrApActual,f.depApActual, " +
            "f.depEstAsDateTime,f.depSchedAsDateTime,f.arrEstAsDateTime,f.arrSchedAsDateTime,f.acRegistration,f.depEstAsDateTime "+
            "ORDER BY  " +

            "CASE when (t.tatType='Dep' and f.offBlockAsDateTime is not null) then f.offBlockAsDateTime" +
            " when (t.tatType='Dep' and f.offBlockAsDateTime is null and f.depEstAsDateTime is not null) then f.depEstAsDateTime " +
            " when (t.tatType='Dep' and f.offBlockAsDateTime is null and f.depEstAsDateTime is null) then f.depSchedAsDateTime" +

            " when ((t.tatType='Arr' ) and f.onblockAsDateTime is not null) then f.onblockAsDateTime" +
            " when ((t.tatType='Arr' ) and f.onblockAsDateTime is null and f.arrEstAsDateTime is not null) then f.arrEstAsDateTime " +
            " when ((t.tatType='Arr' ) and f.onblockAsDateTime is null and f.arrEstAsDateTime is null) then f.arrSchedAsDateTime  " +

            " when (( t.tatType='ArrDep' and f.arrApActual=:localAirport) and f.onblockAsDateTime is not null) then f.onblockAsDateTime" +
            " when (( t.tatType='ArrDep' and f.arrApActual=:localAirport ) and f.onblockAsDateTime is null and f.arrEstAsDateTime is not null) then f.arrEstAsDateTime " +
            " when ((t.tatType='ArrDep' and f.arrApActual=:localAirport ) and f.onblockAsDateTime is null and f.arrEstAsDateTime is null) then f.arrSchedAsDateTime  " +

            " when (( t.tatType='ArrDep' and f.depApActual=:localAirport) and f.offBlockAsDateTime is not null) then f.offBlockAsDateTime" +
            " when (( t.tatType='ArrDep' and f.depApActual=:localAirport ) and f.offBlockAsDateTime is null and f.depEstAsDateTime is not null) then f.depEstAsDateTime " +
            " when ((t.tatType='ArrDep' and f.depApActual=:localAirport ) and f.offBlockAsDateTime is null and f.depEstAsDateTime is null) then f.depSchedAsDateTime  " +
            "else f.depEstAsDateTime end asc " +
            ", f.acRegistration asc "
    )
    Page<Tat> filterTats(
            @Param("tatType0") String tatType0,
            @Param("tatType1") String tatType1,
            @Param("tatType2") String tatType2,
            @Param("isRam") String isRam,
            @Param("param") String param,
            @Param("localAirport") String localAirport,
            @Param("startDate") LocalDateTime startDate,
            @Param("endDate") LocalDateTime endDate,
                         Pageable page );

    @Query(value="select t from Tat t, Flight f where f.tat=t and " +
            "(f.acRegistration like %:param% or f.flightNumber like %:param%)")
    Page<Tat> filterbyRegistrationOrFlightNumber(@Param("param") String param,Pageable page);


    @Query(value="select t.id  as id, t.tatType as tatType, f.legType as legType , f.acSubtype as acSubType " +
            " from Tat t join t.flights f where t.hasTasks = FALSE and t.obsolete=0")
    List<TatInfoDto> getTatsWithNoTasks();


    @Query(value ="SELECT t FROM Tat t , Flight f  where f.tat = t and t.tatType is not null" +
            " and t in (select tat from CrewMember where empNo=:userId )"+
            " and   (" +
            " ( upper(f.acRegistration) like upper(concat('%', :param ,'%')) or upper(f.flightNumber) like upper(concat('%', :param,'%') ))and " +
            " ( (t.tatType like :tatType0 OR :tatType0='0') OR " +
            "   (t.tatType like :tatType1 OR :tatType1='1') OR " +
            "   (t.tatType like :tatType2 OR :tatType2='3')" +
            " ) and "+
            " (f.isRam like %:isRam% ) and "+
            "t in (select t1 from Tat t1,Flight f1 where f1.tat=t1 and "+
            " ( (f1.depEstAsDateTime > :startDate and f1.depEstAsDateTime < :endDate  and f1.depApActual=:localAirport) OR "+
            " (f1.arrEstAsDateTime > :startDate and f1.arrEstAsDateTime < :endDate and f1.arrApActual=:localAirport ) )"+
            ")  " +
            ")"+
            " group by t.tatType,t.id,f.offBlockAsDateTime,f.onblockAsDateTime,f.arrApActual,f.depApActual, " +
            "f.depEstAsDateTime,f.depSchedAsDateTime,f.arrEstAsDateTime,f.arrSchedAsDateTime,f.acRegistration,f.depEstAsDateTime "+
            "ORDER BY  " +

            "CASE when (t.tatType='Dep' and f.offBlockAsDateTime is not null) then f.offBlockAsDateTime" +
            " when (t.tatType='Dep' and f.offBlockAsDateTime is null and f.depEstAsDateTime is not null) then f.depEstAsDateTime " +
            " when (t.tatType='Dep' and f.offBlockAsDateTime is null and f.depEstAsDateTime is null) then f.depSchedAsDateTime" +

            " when ((t.tatType='Arr' ) and f.onblockAsDateTime is not null) then f.onblockAsDateTime" +
            " when ((t.tatType='Arr' ) and f.onblockAsDateTime is null and f.arrEstAsDateTime is not null) then f.arrEstAsDateTime " +
            " when ((t.tatType='Arr' ) and f.onblockAsDateTime is null and f.arrEstAsDateTime is null) then f.arrSchedAsDateTime  " +

            " when (( t.tatType='ArrDep' and f.arrApActual=:localAirport) and f.onblockAsDateTime is not null) then f.onblockAsDateTime" +
            " when (( t.tatType='ArrDep' and f.arrApActual=:localAirport ) and f.onblockAsDateTime is null and f.arrEstAsDateTime is not null) then f.arrEstAsDateTime " +
            " when ((t.tatType='ArrDep' and f.arrApActual=:localAirport ) and f.onblockAsDateTime is null and f.arrEstAsDateTime is null) then f.arrSchedAsDateTime  " +

            " when (( t.tatType='ArrDep' and f.depApActual=:localAirport) and f.offBlockAsDateTime is not null) then f.offBlockAsDateTime" +
            " when (( t.tatType='ArrDep' and f.depApActual=:localAirport ) and f.offBlockAsDateTime is null and f.depEstAsDateTime is not null) then f.depEstAsDateTime " +
            " when ((t.tatType='ArrDep' and f.depApActual=:localAirport ) and f.offBlockAsDateTime is null and f.depEstAsDateTime is null) then f.depSchedAsDateTime  " +
            "else f.depEstAsDateTime end asc " +
            ", f.acRegistration asc "
    )
    Page<Tat> filterMyTats(
            @Param("userId") int userId,
            @Param("tatType0") String tatType0,
            @Param("tatType1") String tatType1,
            @Param("tatType2") String tatType2,
            @Param("isRam") String isRam,
            @Param("param") String param,
            @Param("localAirport") String localAirport,
            @Param("startDate") LocalDateTime startDate,
            @Param("endDate") LocalDateTime endDate,
            Pageable page );


}
//value="select new ma.itroad.ram.tat.tatBusiness.service.dtos.TatInfoDto(t.id  as id, t.tatType as tatType, f.legType as legType , f.acSubtype as acSubtype)

