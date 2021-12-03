package ma.itroad.ram.tat.scheduler.ms.service.dto;


import com.fasterxml.jackson.annotation.JsonProperty;

import javax.naming.directory.SearchResult;
import java.io.Serializable;

public class NetlineFlightMessageDto implements Serializable {

	private Long id;
    @JsonProperty("LEG_NO")
    private String legNo;

    @JsonProperty("FN_CARRIER")
    private String fnCarrier;

    @JsonProperty("FN_NUMBER")
    private String fnNumber;

    @JsonProperty("FN_SUFFIX")
    private String fnSuffix;

    @JsonProperty("JOINT_FN_CARRIER_1")
    private String jointFnCarrier1;

    @JsonProperty("JOINT_FN_CARRIER_2")
    private String jointFnCarrier2;

    @JsonProperty("JOINT_FN_CARRIER_3")
    private String jointFnCarrier3;

    @JsonProperty("DAY_OF_ORIGIN")
    private String dayOfOrigin;

    @JsonProperty("AC_OWNER")
    private String acOwner;

    @JsonProperty("AC_SUBTYPE")
    private String acSubtype;

    @JsonProperty("AC_LOGICAL_NO")
    private String acLogicalNo;

    @JsonProperty("AC_VERSION")
    private String acVersion;

    @JsonProperty("AC_PRBD")
    private String acPrbd;

    @JsonProperty("IS_RAM")
    private String isRam;

    @JsonProperty("AC_REGISTRATION")
    private String acRegistration;

    @JsonProperty("DEP_AP_SCHED")
    private String depApSched;

    @JsonProperty("ARR_AP_SCHED")
    private String arrApSched;

    @JsonProperty("DEP_AP_ACTUAL")
    private String depApActual;

    @JsonProperty("ARR_AP_ACTUAL")
    private String arrApActual;

    @JsonProperty("LEG_STATE")
    private String legState;

    @JsonProperty("LEG_TYPE")
    private String legType;

    @JsonProperty("DEP_DAY_SCHED")
    private String depDaySched;

    @JsonProperty("DEP_TIME_SCHED")
    private String depTimeSched;

    @JsonProperty("ARR_DAY_SCHED")
    private String arrDaySched;

    @JsonProperty("ARR_TIME_SCHED")
    private String arrTimeSched;

    @JsonProperty("DEP_DAY_EST")
    private String depDayEst;

    @JsonProperty("DEP_TIME_EST")
    private String depTimeEst;

    @JsonProperty("ARR_DAY_EST")
    private String arrDayEst;

    @JsonProperty("ARR_TIME_EST")
    private String arrTimeEst;

    @JsonProperty("NEXT_INFO_DAY")
    private String nextInfoDay;

    @JsonProperty("NEXT_INFO_TIME")
    private String nextInfoTime;

    @JsonProperty("OFFBLOCK_DAY")
    private String offBlockDay;

    @JsonProperty("OFFBLOCK_TIME")
    private String offBlockTime;

    @JsonProperty("AIRBORNE_DAY")
    private String airborneDay;

    @JsonProperty("AIRBORNE_TIME")
    private String airborneTime;

    @JsonProperty("LANDING_DAY")
    private String landingDay;

    @JsonProperty("LANDING_TIME")
    private String landingTime;

    @JsonProperty("ONBLOCK_DAY")
    private String onBlockDay;

    @JsonProperty("ONBLOCK_TIME")
    private String onBlockTime;

    @JsonProperty("DELAY_CODE_01")
    private String delayCode01;


    @JsonProperty("DELAY_TIME_01")
    private String delayTime01;

    @JsonProperty("DELAY_CODE_02")
    private String delayCode02;


    @JsonProperty("DELAY_TIME_02")
    private String delayTime02;

    @JsonProperty("DELAY_CODE_03")
    private String delayCode03;


    @JsonProperty("DELAY_TIME_03")
    private String delayTime03;

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

    public String getDelayCode02() {
        return delayCode02;
    }

    public void setDelayCode02(String delayCode02) {
        this.delayCode02 = delayCode02;
    }

    public String getDelayCode03() {
        return delayCode03;
    }

    public void setDelayCode03(String delayCode03) {
        this.delayCode03 = delayCode03;
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

    public String getLegType() {
        return legType;
    }

    public void setLegType(String legType) {
        this.legType = legType;
    }

    public String getDelayTime01() {
        return delayTime01;
    }

    public void setDelayTime01(String delayTime01) {
        this.delayTime01 = delayTime01;
    }

    public String getDelayTime02() {
        return delayTime02;
    }

    public void setDelayTime02(String delayTime02) {
        this.delayTime02 = delayTime02;
    }

    public String getDelayTime03() {
        return delayTime03;
    }

    public void setDelayTime03(String delayTime03) {
        this.delayTime03 = delayTime03;
    }

    public NetlineFlightMessageDto() {
    }

    public NetlineFlightMessageDto(Long id, String legNo, String fnCarrier, String fnNumber, String fnSuffix,
			String jointFnCarrier1, String jointFnCarrier2, String jointFnCarrier3, String dayOfOrigin, String acOwner,
			String acSubtype, String acLogicalNo, String acVersion, String acPrbd, String isRam, String acRegistration,
			String depApSched, String arrApSched, String depApActual, String arrApActual, String legState,
			String legType, String depDaySched, String depTimeSched, String arrDaySched, String arrTimeSched,
			String depDayEst, String depTimeEst, String arrDayEst, String arrTimeEst, String nextInfoDay,
			String nextInfoTime, String offBlockDay, String offBlockTime, String airborneDay, String airborneTime,
			String landingDay, String landingTime, String onBlockDay, String onBlockTime, String delayCode01,
			String delayTime01, String delayCode02, String delayTime02, String delayCode03, String delayTime03) {
		super();
		this.id = id;
		this.legNo = legNo;
		this.fnCarrier = fnCarrier;
		this.fnNumber = fnNumber;
		this.fnSuffix = fnSuffix;
		this.jointFnCarrier1 = jointFnCarrier1;
		this.jointFnCarrier2 = jointFnCarrier2;
		this.jointFnCarrier3 = jointFnCarrier3;
		this.dayOfOrigin = dayOfOrigin;
		this.acOwner = acOwner;
		this.acSubtype = acSubtype;
		this.acLogicalNo = acLogicalNo;
		this.acVersion = acVersion;
		this.acPrbd = acPrbd;
		this.isRam = isRam;
		this.acRegistration = acRegistration;
		this.depApSched = depApSched;
		this.arrApSched = arrApSched;
		this.depApActual = depApActual;
		this.arrApActual = arrApActual;
		this.legState = legState;
		this.legType = legType;
		this.depDaySched = depDaySched;
		this.depTimeSched = depTimeSched;
		this.arrDaySched = arrDaySched;
		this.arrTimeSched = arrTimeSched;
		this.depDayEst = depDayEst;
		this.depTimeEst = depTimeEst;
		this.arrDayEst = arrDayEst;
		this.arrTimeEst = arrTimeEst;
		this.nextInfoDay = nextInfoDay;
		this.nextInfoTime = nextInfoTime;
		this.offBlockDay = offBlockDay;
		this.offBlockTime = offBlockTime;
		this.airborneDay = airborneDay;
		this.airborneTime = airborneTime;
		this.landingDay = landingDay;
		this.landingTime = landingTime;
		this.onBlockDay = onBlockDay;
		this.onBlockTime = onBlockTime;
		this.delayCode01 = delayCode01;
		this.delayTime01 = delayTime01;
		this.delayCode02 = delayCode02;
		this.delayTime02 = delayTime02;
		this.delayCode03 = delayCode03;
		this.delayTime03 = delayTime03;
	}

	@Override
    public String toString() {
        return "NetlineFlightMessageDto{" +
                "legNo='" + legNo + '\'' +
                ", fnCarrier='" + fnCarrier + '\'' +
                ", fnNumber='" + fnNumber + '\'' +
                ", acRegistration='" + acRegistration + '\'' +
                '}'+
                " Ac Registration can't be null";
    }
}
