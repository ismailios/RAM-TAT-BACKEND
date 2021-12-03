package ma.itroad.ram.tat.tatBusiness.service.domain;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@DynamicUpdate
@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name="flights")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="LEG_NO")
    @JsonProperty("LEG_NO")
    private String legNo;



    @Column(name="FN_CARRIER")
    @JsonProperty("FN_CARRIER")
    private String fnCarrier;

    @Column(name="FN_NUMBER")
    @JsonProperty("FN_NUMBER")
    private String fnNumber;

    @Column(name="FLIGHT_NUMBER")
    @JsonProperty("FLIGHT_NUMBER")
    private String flightNumber;

    @Column(name="FN_SUFFIX")
    @JsonProperty("FN_SUFFIX")
    private String fnSuffix;

    @Column(name="JOINT_FN_CARRIER_1")
    @JsonProperty("JOINT_FN_CARRIER_1")
    private String jointFnCarrier1;

    @Column(name="JOINT_FN_CARRIER_2")
    @JsonProperty("JOINT_FN_CARRIER_2")
    private String jointFnCarrier2;

    @Column(name="JOINT_FN_CARRIER_3")
    @JsonProperty("JOINT_FN_CARRIER_3")
    private String jointFnCarrier3;

    @Column(name="DAY_OF_ORIGIN")
    @JsonProperty("DAY_OF_ORIGIN")
    private String dayOfOrigin;

    @Column(name="DAY_OF_ORIGIN_DATE")
    @JsonProperty("DAY_OF_ORIGIN_DATE")
    private LocalDate dayOfOriginAsDate;

    @Column(name="AC_OWNER")
    @JsonProperty("AC_OWNER")
    private String acOwner;

    @Column(name="AC_SUBTYPE")
    @JsonProperty("AC_SUBTYPE")
    private String acSubtype;

    @Column(name="AC_LOGICAL_NO")
    @JsonProperty("AC_LOGICAL_NO")
    private String acLogicalNo;

    @Column(name="AC_VERSION")
    @JsonProperty("AC_VERSION")
    private String acVersion;

    @Column(name="AC_PRBD")
    @JsonProperty("AC_PRBD")
    private String acPrbd;

    @Column(name="IS_RAM")
    @JsonProperty("IS_RAM")
    private String isRam;

    @NotNull
    @Column(name="AC_REGISTRATION")
    @JsonProperty("AC_REGISTRATION")
    private String acRegistration;

    @Column(name="DEP_AP_SCHED")
    @JsonProperty("DEP_AP_SCHED")
    private String depApSched;

    @Column(name="ARR_AP_SCHED")
    @JsonProperty("ARR_AP_SCHED")
    private String arrApSched;

    @Column(name="DEP_AP_ACTUAL")
    @JsonProperty("DEP_AP_ACTUAL")
    private String depApActual;

    @Column(name="ARR_AP_ACTUAL")
    @JsonProperty("ARR_AP_ACTUAL")
    private String arrApActual;

    @Column(name="LEG_STATE")
    @JsonProperty("LEG_STATE")
    private String legState;

    @Column(name="LEG_TYPE")
    @JsonProperty("LEG_TYPE")
    private String legType;

    @Column(name="DEP_DAY_SCHED")
    @JsonProperty("DEP_DAY_SCHED")
    private String depDaySched;

    @Column(name="DEP_TIME_SCHED")
    @JsonProperty("DEP_TIME_SCHED")
    private String depTimeSched;

    @Column(name="DEP_SCHED_DATE")
    @JsonProperty("DEP_SCHED_DATE")
    private LocalDateTime depSchedAsDateTime;

    @Column(name="ARR_DAY_SCHED")
    @JsonProperty("ARR_DAY_SCHED")
    private String arrDaySched;

    @Column(name="ARR_TIME_SCHED")
    @JsonProperty("ARR_TIME_SCHED")
    private String arrTimeSched;

    @Column(name="ARR_SCHED_DATE")
    @JsonProperty("ARR_SCHED_DATE")
    private LocalDateTime arrSchedAsDateTime;

    @Column(name="DEP_DAY_EST")
    @JsonProperty("DEP_DAY_EST")
    private String depDayEst;

    @Column(name="DEP_TIME_EST")
    @JsonProperty("DEP_TIME_EST")
    private String depTimeEst;

    @Column(name="DEP_EST_DATE")
    @JsonProperty("DEP_EST_DATE")
    private LocalDateTime depEstAsDateTime;

    @Column(name="ARR_DAY_EST")
    @JsonProperty("ARR_DAY_EST")
    private String arrDayEst;

    @Column(name="ARR_TIME_EST")
    @JsonProperty("ARR_TIME_EST")
    private String arrTimeEst;

    @Column(name="ARR_EST_DATE")
    @JsonProperty("ARR_EST_DATE")
    private LocalDateTime arrEstAsDateTime;

    @Column(name="NEXT_INFO_DAY")
    @JsonProperty("NEXT_INFO_DAY")
    private String nextInfoDay;

    @Column(name="NEXT_INFO_TIME")
    @JsonProperty("NEXT_INFO_TIME")
    private String nextInfoTime;

    @Column(name="NEXT_INFO_AS_DATE")
    @JsonProperty("NEXT_INFO_AS_DATE")
    private LocalDateTime nextInfoAsDayTime;

    @Column(name="OFFBLOCK_DAY")
    @JsonProperty("OFFBLOCK_DAY")
    private String offBlockDay;

    @Column(name="OFFBLOCK_TIME")
    @JsonProperty("OFFBLOCK_TIME")
    private String offBlockTime;

    @Column(name="OFFBLOCK_DATE")
    @JsonProperty("OFFBLOCK_DATE")
    private LocalDateTime offBlockAsDateTime;

    @Column(name="AIRBORNE_DAY")
    @JsonProperty("AIRBORNE_DAY")
    private String airborneDay;

    @Column(name="AIRBORNE_TIME")
    @JsonProperty("AIRBORNE_TIME")
    private String airborneTime;

    @Column(name="AIRBORNE_DATE")
    @JsonProperty("AIRBORNE_DATE")
    private LocalDateTime airborneAsDateTime;

    @Column(name="LANDING_DAY")
    @JsonProperty("LANDING_DAY")
    private String landingDay;

    @Column(name="LANDING_TIME")
    @JsonProperty("LANDING_TIME")
    private String landingTime;

    @Column(name="LANDING_DATE")
    @JsonProperty("LANDING_DATE")
    private LocalDateTime landingAsDAteTime;

    @Column(name="ONBLOCK_DAY")
    @JsonProperty("ONBLOCK_DAY")
    private String onBlockDay;

    @Column(name="ONBLOCK_TIME")
    @JsonProperty("ONBLOCK_TIME")
    private String onBlockTime;

    @Column(name="ONBLOCK_DATE")
    @JsonProperty("ONBLOCK_DATE")
    private LocalDateTime onblockAsDateTime;

    @Column(name="DELAY_CODE_01")
    @JsonProperty("DELAY_CODE_01")
    private String delayCode01;


    @Column(name="DELAY_TIME_01")
    @JsonProperty("DELAY_TIME_01")
    private String delayTime01;

    @Column(name="DELAY_CODE_02")
    @JsonProperty("DELAY_CODE_02")
    private String delayCode02;


    @Column(name="DELAY_TIME_02")
    @JsonProperty("DELAY_TIME_02")
    private String delayTime02;

    @Column(name="DELAY_CODE_03")
    @JsonProperty("DELAY_CODE_03")
    private String delayCode03;


    @Column(name="DELAY_TIME_03")
    @JsonProperty("DELAY_TIME_03")
    private String delayTime03;

    @Column(name="UNIQUE_CODE", unique = true  )
    @JsonProperty("UNIQUE_CODE")
    private String uniqueCode;

    @Column(name = "created_date", nullable = false, updatable = false)
    @CreatedDate
    private LocalDateTime createdDate;

    @Column(name = "modified_date")
    @LastModifiedDate
    private LocalDateTime modifiedDate;

    @Column(name="last_transaction_id")
    private Long lastTransaction;

    @Column(name="last_leg_message_id")
    private Long lastLegMessage;

    @Column(name="last_operation_id")
    private Long lastOperation;

    @Column(name="tat_max")
    private long tatMax;

    @Column(name="leg_export_date")
    private Instant legDateTime;

    @Column(name="extra")
    private String extra;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="tat_id",referencedColumnName = "id")
    private Tat tat;


    public String getDepDaySched() {
        return depDaySched;
    }

    public void setDepDaySched(String depDaySched) {
        this.depDaySched = depDaySched;
    }

    public String getDepTimeSched() {
        return depTimeSched;
    }

    public void setDepTimeSched(String depTimeSched) {
        this.depTimeSched = depTimeSched;
    }

    public String getArrDaySched() {
        return arrDaySched;
    }

    public void setArrDaySched(String arrDaySched) {
        this.arrDaySched = arrDaySched;
    }

    public String getArrTimeSched() {
        return arrTimeSched;
    }

    public void setArrTimeSched(String arrTimeSched) {
        this.arrTimeSched = arrTimeSched;
    }

    public String getDepDayEst() {
        return depDayEst;
    }

    public void setDepDayEst(String depDayEst) {
        this.depDayEst = depDayEst;
    }

    public String getDepTimeEst() {
        return depTimeEst;
    }

    public void setDepTimeEst(String depTimeEst) {
        this.depTimeEst = depTimeEst;
    }

    public String getArrDayEst() {
        return arrDayEst;
    }

    public void setArrDayEst(String arrDayEst) {
        this.arrDayEst = arrDayEst;
    }

    public String getArrTimeEst() {
        return arrTimeEst;
    }

    public void setArrTimeEst(String arrTimeEst) {
        this.arrTimeEst = arrTimeEst;
    }

    public String getNextInfoDay() {
        return nextInfoDay;
    }

    public void setNextInfoDay(String nextInfoDay) {
        this.nextInfoDay = nextInfoDay;
    }

    public String getNextInfoTime() {
        return nextInfoTime;
    }

    public void setNextInfoTime(String nextInfoTime) {
        this.nextInfoTime = nextInfoTime;
    }

    public String getOffBlockDay() {
        return offBlockDay;
    }

    public void setOffBlockDay(String offBlockDay) {
        this.offBlockDay = offBlockDay;
    }

    public String getOffBlockTime() {
        return offBlockTime;
    }

    public void setOffBlockTime(String offBlockTime) {
        this.offBlockTime = offBlockTime;
    }

    public String getAirborneDay() {
        return airborneDay;
    }

    public void setAirborneDay(String airborneDay) {
        this.airborneDay = airborneDay;
    }

    public String getAirborneTime() {
        return airborneTime;
    }

    public void setAirborneTime(String airborneTime) {
        this.airborneTime = airborneTime;
    }

    public String getLandingDay() {
        return landingDay;
    }

    public void setLandingDay(String landingDay) {
        this.landingDay = landingDay;
    }

    public String getLandingTime() {
        return landingTime;
    }

    public void setLandingTime(String landingTime) {
        this.landingTime = landingTime;
    }

    public String getOnBlockDay() {
        return onBlockDay;
    }

    public void setOnBlockDay(String onBlockDay) {
        this.onBlockDay = onBlockDay;
    }

    public String getOnBlockTime() {
        return onBlockTime;
    }

    public void setOnBlockTime(String onBlockTime) {
        this.onBlockTime = onBlockTime;
    }

    public String getDelayCode01() {
        return delayCode01;
    }

    public void setDelayCode01(String delayCode01) {
        this.delayCode01 = delayCode01;
    }

    public String getDelayTime01() {
        return delayTime01;
    }

    public void setDelayTime01(String delayTime01) {
        this.delayTime01 = delayTime01;
    }

    public String getDelayCode02() {
        return delayCode02;
    }

    public void setDelayCode02(String delayCode02) {
        this.delayCode02 = delayCode02;
    }

    public String getDelayTime02() {
        return delayTime02;
    }

    public void setDelayTime02(String delayTime02) {
        this.delayTime02 = delayTime02;
    }

    public String getDelayCode03() {
        return delayCode03;
    }

    public void setDelayCode03(String delayCode03) {
        this.delayCode03 = delayCode03;
    }

    public String getDelayTime03() {
        return delayTime03;
    }

    public void setDelayTime03(String delayTime03) {
        this.delayTime03 = delayTime03;
    }

    public String getUniqueCode() {
        return uniqueCode;
    }

    public void setUniqueCode(String uniqueCode) {
        this.uniqueCode = uniqueCode;
    }


    public LocalDate getDayOfOriginAsDate() {
        return dayOfOriginAsDate;
    }

    public void setDayOfOriginAsDate(LocalDate dayOfOriginAsDate) {
        this.dayOfOriginAsDate = dayOfOriginAsDate;
    }

    public LocalDateTime getDepSchedAsDateTime() {
        return depSchedAsDateTime;
    }

    public void setDepSchedAsDateTime(LocalDateTime depSchedAsDateTime) {
        this.depSchedAsDateTime = depSchedAsDateTime;
    }

    public LocalDateTime getArrSchedAsDateTime() {
        return arrSchedAsDateTime;
    }

    public void setArrSchedAsDateTime(LocalDateTime arrSchedAsDateTime) {
        this.arrSchedAsDateTime = arrSchedAsDateTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLegNo() {
        return legNo;
    }

    public void setLegNo(String legNo) {
        this.legNo = legNo;
    }

    public String getFnCarrier() {
        return fnCarrier;
    }

    public void setFnCarrier(String fnCarrier) {
        this.fnCarrier = fnCarrier;
    }


    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getFnSuffix() {
        return fnSuffix;
    }

    public void setFnSuffix(String fnSuffix) {
        this.fnSuffix = fnSuffix;
    }

    public String getJointFnCarrier1() {
        return jointFnCarrier1;
    }

    public void setJointFnCarrier1(String jointFnCarrier1) {
        this.jointFnCarrier1 = jointFnCarrier1;
    }

    public String getJointFnCarrier2() {
        return jointFnCarrier2;
    }

    public void setJointFnCarrier2(String jointFnCarrier2) {
        this.jointFnCarrier2 = jointFnCarrier2;
    }

    public String getJointFnCarrier3() {
        return jointFnCarrier3;
    }

    public void setJointFnCarrier3(String jointFnCarrier3) {
        this.jointFnCarrier3 = jointFnCarrier3;
    }

    public String getDayOfOrigin() {
        return dayOfOrigin;
    }

    public void setDayOfOrigin(String dayOfOrigin) {
        this.dayOfOrigin = dayOfOrigin;
    }

    public String getAcOwner() {
        return acOwner;
    }

    public void setAcOwner(String acOwner) {
        this.acOwner = acOwner;
    }

    public String getAcSubtype() {
        return acSubtype;
    }

    public void setAcSubtype(String acSubtype) {
        this.acSubtype = acSubtype;
    }

    public String getAcLogicalNo() {
        return acLogicalNo;
    }

    public void setAcLogicalNo(String acLogicalNo) {
        this.acLogicalNo = acLogicalNo;
    }

    public String getAcVersion() {
        return acVersion;
    }

    public void setAcVersion(String acVersion) {
        this.acVersion = acVersion;
    }

    public String getAcPrbd() {
        return acPrbd;
    }

    public void setAcPrbd(String acPrbd) {
        this.acPrbd = acPrbd;
    }

    public String getIsRam() {
        return isRam;
    }

    public void setIsRam(String isRam) {
        this.isRam = isRam;
    }

    public String getAcRegistration() {
        return acRegistration;
    }

    public void setAcRegistration(String acRegistration) {
        this.acRegistration = acRegistration;
    }

    public String getDepApSched() {
        return depApSched;
    }

    public void setDepApSched(String depApSched) {
        this.depApSched = depApSched;
    }

    public String getArrApSched() {
        return arrApSched;
    }

    public void setArrApSched(String arrApSched) {
        this.arrApSched = arrApSched;
    }

    public String getDepApActual() {
        return depApActual;
    }

    public void setDepApActual(String depApActual) {
        this.depApActual = depApActual;
    }

    public String getArrApActual() {
        return arrApActual;
    }

    public void setArrApActual(String arrApActual) {
        this.arrApActual = arrApActual;
    }

    public String getLegState() {
        return legState;
    }

    public void setLegState(String legState) {
        this.legState = legState;
    }

    public String getLegType() {
        return legType;
    }

    public void setLegType(String legType) {
        this.legType = legType;
    }

    public LocalDateTime getDepEstAsDateTime() {
        return depEstAsDateTime;
    }

    public void setDepEstAsDateTime(LocalDateTime depEstAsDateTime) {
        this.depEstAsDateTime = depEstAsDateTime;
    }

    public LocalDateTime getArrEstAsDateTime() {
        return arrEstAsDateTime;
    }

    public void setArrEstAsDateTime(LocalDateTime arrEstAsDateTime) {
        this.arrEstAsDateTime = arrEstAsDateTime;
    }

    public LocalDateTime getOffBlockAsDateTime() {
        return offBlockAsDateTime;
    }

    public void setOffBlockAsDateTime(LocalDateTime offBlockAsDateTime) {
        this.offBlockAsDateTime = offBlockAsDateTime;
    }

    public LocalDateTime getAirborneAsDateTime() {
        return airborneAsDateTime;
    }

    public void setAirborneAsDateTime(LocalDateTime airborneAsDateTime) {
        this.airborneAsDateTime = airborneAsDateTime;
    }

    public LocalDateTime getLandingAsDAteTime() {
        return landingAsDAteTime;
    }

    public void setLandingAsDAteTime(LocalDateTime landingAsDAteTime) {
        this.landingAsDAteTime = landingAsDAteTime;
    }

    public LocalDateTime getOnblockAsDateTime() {
        return onblockAsDateTime;
    }

    public void setOnblockAsDateTime(LocalDateTime onblockAsDateTime) {
        this.onblockAsDateTime = onblockAsDateTime;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(LocalDateTime modifiedDate) {
        this.modifiedDate = modifiedDate;
    }
    public long getTatMax() {
        return tatMax;
    }

    public void setTatMax(long tatMax) {
        this.tatMax = tatMax;
    }

    public String getFnNumber() {
        return fnNumber;
    }

    public void setFnNumber(String fnNumber) {
        this.fnNumber = fnNumber;
    }

    public LocalDateTime getNextInfoAsDayTime() {
        return nextInfoAsDayTime;
    }

    public void setNextInfoAsDayTime(LocalDateTime nextInfoAsDayTime) {
        this.nextInfoAsDayTime = nextInfoAsDayTime;
    }

    public Long getLastTransaction() {
        return lastTransaction;
    }

    public void setLastTransaction(Long lastTransaction) {
        this.lastTransaction = lastTransaction;
    }

    public Long getLastLegMessage() {
        return lastLegMessage;
    }

    public void setLastLegMessage(Long lastLegMessage) {
        this.lastLegMessage = lastLegMessage;
    }

    public Long getLastOperation() {
        return lastOperation;
    }

    public void setLastOperation(Long lastOperation) {
        this.lastOperation = lastOperation;
    }

    public Instant getLegDateTime() {
        return legDateTime;
    }

    public void setLegDateTime(Instant legDateTime) {
        this.legDateTime = legDateTime;
    }

    public Tat getTat() {
        return tat;
    }
    public String generateTatType(){
        if (tat!=null)
                return tat.getTatType();
        else return "";
    }
    public long generateTatId(){
        if(tat!=null)
            return tat.getId();
        else
            return 0;
    }

    public LocalDateTime generateDepEstDateTime(){
        if (this.depEstAsDateTime!=null)
            return this.depEstAsDateTime;
        else
            return depSchedAsDateTime;

    }

    public LocalDateTime generateArrEstDateTime(){
        if (this.arrEstAsDateTime!=null)
            return this.arrEstAsDateTime;
        else
            return this.arrSchedAsDateTime;

    }

    public LocalDateTime generateOnBlockDateTime(){
        if (this.onblockAsDateTime!=null)
            return this.onblockAsDateTime;
        else
            return generateArrEstDateTime();

    }


    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", legNo='" + legNo + '\'' +
                ", fnCarrier='" + fnCarrier + '\'' +
                ", fnNumber='" + fnNumber + '\'' +
                ", flightNumber='" + flightNumber + '\'' +
                ", fnSuffix='" + fnSuffix + '\'' +
                ", jointFnCarrier1='" + jointFnCarrier1 + '\'' +
                ", jointFnCarrier2='" + jointFnCarrier2 + '\'' +
                ", jointFnCarrier3='" + jointFnCarrier3 + '\'' +
                ", dayOfOrigin='" + dayOfOrigin + '\'' +
                ", dayOfOriginAsDate=" + dayOfOriginAsDate +
                ", acOwner='" + acOwner + '\'' +
                ", acSubtype='" + acSubtype + '\'' +
                ", acLogicalNo='" + acLogicalNo + '\'' +
                ", acVersion='" + acVersion + '\'' +
                ", acPrbd='" + acPrbd + '\'' +
                ", isRam='" + isRam + '\'' +
                ", acRegistration='" + acRegistration + '\'' +
                ", depApSched='" + depApSched + '\'' +
                ", arrApSched='" + arrApSched + '\'' +
                ", depApActual='" + depApActual + '\'' +
                ", arrApActual='" + arrApActual + '\'' +
                ", legState='" + legState + '\'' +
                ", legType='" + legType + '\'' +
                ", depDaySched='" + depDaySched + '\'' +
                ", depTimeSched='" + depTimeSched + '\'' +
                ", depSchedAsDateTime=" + depSchedAsDateTime +
                ", arrDaySched='" + arrDaySched + '\'' +
                ", arrTimeSched='" + arrTimeSched + '\'' +
                ", arrSchedAsDateTime=" + arrSchedAsDateTime +
                ", depDayEst='" + depDayEst + '\'' +
                ", depTimeEst='" + depTimeEst + '\'' +
                ", depEstAsDateTime=" + depEstAsDateTime +
                ", arrDayEst='" + arrDayEst + '\'' +
                ", arrTimeEst='" + arrTimeEst + '\'' +
                ", arrEstAsDateTime=" + arrEstAsDateTime +
                ", nextInfoDay='" + nextInfoDay + '\'' +
                ", nextInfoTime='" + nextInfoTime + '\'' +
                ", nextInfoAsDayTime=" + nextInfoAsDayTime +
                ", offBlockDay='" + offBlockDay + '\'' +
                ", offBlockTime='" + offBlockTime + '\'' +
                ", offBlockAsDateTime=" + offBlockAsDateTime +
                ", airborneDay='" + airborneDay + '\'' +
                ", airborneTime='" + airborneTime + '\'' +
                ", airborneAsDateTime=" + airborneAsDateTime +
                ", landingDay='" + landingDay + '\'' +
                ", landingTime='" + landingTime + '\'' +
                ", landingAsDAteTime=" + landingAsDAteTime +
                ", onBlockDay='" + onBlockDay + '\'' +
                ", onBlockTime='" + onBlockTime + '\'' +
                ", onblockAsDateTime=" + onblockAsDateTime +
                ", delayCode01='" + delayCode01 + '\'' +
                ", delayTime01='" + delayTime01 + '\'' +
                ", delayCode02='" + delayCode02 + '\'' +
                ", delayTime02='" + delayTime02 + '\'' +
                ", delayCode03='" + delayCode03 + '\'' +
                ", delayTime03='" + delayTime03 + '\'' +
                ", uniqueCode='" + uniqueCode + '\'' +
                ", createdDate=" + createdDate +
                ", modifiedDate=" + modifiedDate +
                ", lastTransaction=" + lastTransaction +
                ", tatMax=" + tatMax +
                ", tat=" + tat +
                '}';
    }
}
