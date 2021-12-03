package ma.itroad.ram.tat.tatBusiness.service.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
//import org.springframework.data.annotation.Id;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name="netline_flight_message")
public class NetlineFlightMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="LEG_NO" )
	@JsonProperty("LEG_NO")
    private String legNo;

	@Column(name="FN_CARRIER")
	@JsonProperty("FN_CARRIER")
    private String fnCarrier;

    @Column(name="FN_NUMBER")
	@JsonProperty("FN_NUMBER")
    private String fnNumber;

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

    @Column(name="AC_REGISTRATION", nullable = false)
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

    @Column(name="ARR_DAY_SCHED")
	@JsonProperty("ARR_DAY_SCHED")
    private String arrDaySched;

    @Column(name="ARR_TIME_SCHED")
	@JsonProperty("ARR_TIME_SCHED")
    private String arrTimeSched;

    @Column(name="DEP_DAY_EST")
	@JsonProperty("DEP_DAY_EST")
    private String depDayEst;

    @Column(name="DEP_TIME_EST")
	@JsonProperty("DEP_TIME_EST")
    private String depTimeEst;

    @Column(name="ARR_DAY_EST")
	@JsonProperty("ARR_DAY_EST")
    private String arrDayEst;

    @Column(name="ARR_TIME_EST")
	@JsonProperty("ARR_TIME_EST")
    private String arrTimeEst;

    @Column(name="NEXT_INFO_DAY")
	@JsonProperty("NEXT_INFO_DAY")
    private String nextInfoDay;

    @Column(name="NEXT_INFO_TIME")
	@JsonProperty("NEXT_INFO_TIME")
    private String nextInfoTime;

    @Column(name="OFFBLOCK_DAY")
	@JsonProperty("OFFBLOCK_DAY")
    private String offBlockDay;

    @Column(name="OFFBLOCK_TIME")
	@JsonProperty("OFFBLOCK_TIME")
    private String offBlockTime;

    @Column(name="AIRBORNE_DAY")
	@JsonProperty("AIRBORNE_DAY")
    private String airborneDay;

    @Column(name="AIRBORNE_TIME")
	@JsonProperty("AIRBORNE_TIME")
    private String airborneTime;

    @Column(name="LANDING_DAY")
	@JsonProperty("LANDING_DAY")
    private String landingDay;

    @Column(name="LANDING_TIME")
	@JsonProperty("LANDING_TIME")
    private String landingTime;

    @Column(name="ONBLOCK_DAY")
	@JsonProperty("ONBLOCK_DAY")
    private String onBlockDay;

    @Column(name="ONBLOCK_TIME")
	@JsonProperty("ONBLOCK_TIME")
    private String onBlockTime;

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

    @Column(name="FLIGHT_UNIQUE_CODE")
    private String flightUniqueCode;


    public NetlineFlightMessage() {
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

    public String getFnNumber() {
        return fnNumber;
    }

    public void setFnNumber(String fnNumber) {
        this.fnNumber = fnNumber;
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

    public String generateUniqueFlightCode(){

        String s = ""+fnCarrier+fnNumber+"-"+dayOfOrigin+"-"+depApSched;
        flightUniqueCode=s;
        return s;
    }


}
