package ma.itroad.ram.tat.thirdPartyConnectors.service.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
@Table(name = "flight")
public class Flight implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JsonProperty("FN_CARRIER")
	@Column(name = "FN_CARRIER")
	private String fnCarrier;

	@JsonProperty("LEG_NO")
	@Column(name = "legNo")
	private String legNo;

	@JsonProperty("FN_NUMBER")
	@Column(name = "FN_NUMBER")
	private String fnNumber;

	@JsonProperty("JOINT_FN_CARRIER_1")
	@Column(name = "JOINT_FN_CARRIER_1")
	private String joinFnCarrier1;

	@JsonProperty("JOINT_FN_CARRIER_2")
	@Column(name = "JOINT_FN_CARRIER_2")
	private String joinFnCarrier2;

	@JsonProperty("JOINT_FN_CARRIER_3")
	@Column(name = "JOINT_FN_CARRIER_3")
	private String joinFnCarrier3;

	@JsonProperty("FN_SUFFIX")
	@Column(name = "FN_SUFFIX")
	private String fnSuffix;

	@JsonProperty("DAY_OF_ORIGIN")
	@Column(name = "DAY_OF_ORIGIN")
	private String dayOfOrigin;


	@JsonProperty("AC_LOGICAL_NO")
	@Column(name = "AC_LOGICAL_NO")
	private String acLogicalNo;

	@JsonProperty("AC_VERSION")
	@Column(name="AC_VERSION")
	private String acVersion;

	@JsonProperty("AC_PRBD")
	@Column(name="AC_PRBD")
	private String acPrbd;

	@JsonProperty("AC_OWNER")
	@Column(name = "AC_OWNER")
	private String acOwner;
	@JsonProperty("AC_SUBTYPE")
	@Column(name = "AC_SUBTYPE")
	private String acSubtype;
	@JsonProperty("AC_REGISTRATION")
	@Column(name = "AC_REGISTRATION")
	private String acRegistration;
	@JsonProperty("DEP_AP_SCHED")
	@Column(name = "DEP_AP_SCHED")
	private String depApSched;
	@JsonProperty("ARR_AP_SCHED")
	@Column(name = "ARR_AP_SCHED")
	private String arrApSched;
	@JsonProperty("DEP_AP_ACTUAL")
	@Column(name = "DEP_AP_ACTUAL")
	private String depApActual;
	@JsonProperty("ARR_AP_ACTUAL")
	@Column(name = "ARR_AP_ACTUAL")
	private String arrApActual;
	@JsonProperty("LEG_STATE")
	@Column(name = "LEG_STATE")
	private String legState;
	@JsonProperty("LEG_TYPE")
	@Column(name = "LEG_TYPE")
	private String legType;
	@JsonProperty("DEP_DAY_SCHED")
	@Column(name = "DEP_DAY_SCHED")
	private String depDaySched;
	@JsonProperty("DEP_TIME_SCHED")
	@Column(name = "DEP_TIME_SCHED")
	private String depTimeSched;
	@JsonProperty("ARR_DAY_SCHED")
	@Column(name = "ARR_DAY_SCHED")
	private String arrDaySched;
	@JsonProperty("ARR_TIME_SCHED")
	@Column(name = "ARR_TIME_SCHED")
	private String arrTimeSched;
	@JsonProperty("DEP_DAY_EST")
	@Column(name = "DEP_DAY_EST")
	private String depDayEst;
	@JsonProperty("DEP_TIME_EST")
	@Column(name = "DEP_TIME_EST")
	private String depTimeEst;
	@JsonProperty("ARR_DAY_EST")
	@Column(name = "ARR_DAY_EST")
	private String arrDayEst;
	@JsonProperty("ARR_TIME_EST")
	@Column(name = "ARR_TIME_EST")
	private String arrTimeEst;
	@JsonProperty("OFFBLOCK_DAY")
	@Column(name = "OFFBLOCK_DAY")
	private String offBlockDay;
	@JsonProperty("OFFBLOCK_TIME")
	@Column(name = "OFFBLOCK_TIME")
	private String offBlockTime;
	@JsonProperty("ONBLOCK_DAY")
	@Column(name = "ONBLOCK_DAY")
	private String onBlockDay;
	@JsonProperty("ONBLOCK_TIME")
	@Column(name = "ONBLOCK_TIME")
	private String onBlockTime;

	@JsonProperty("IS_RAM")
	@Column(name="IS_RAM")
	private String isRam;

	@JsonProperty("AIRBORNE_DAY")
	@Column(name="AIRBORNE_DAY")
	private String airborneDay;

	@JsonProperty("AIRBORNE_TIME")
	@Column(name="AIRBORNE_TIME")
	private String airborneTime;

	@JsonProperty("LANDING_DAY")
	@Column(name="LANDING_DAY")
	private String landingDay;

	@JsonProperty("LANDING_TIME")
	@Column(name="LANDING_TIME")
	private String landingTime;


	@JsonProperty("DELAY_CODE_01")
	@Column(name="DELAY_CODE_01")
	private String delayCode1;

	@JsonProperty("DELAY_CODE_02")
	@Column(name="DELAY_CODE_02")
	private String delayCode2;

	@JsonProperty("DELAY_CODE_03")
	@Column(name="DELAY_CODE_03")
	private String delayCode3;

	@JsonProperty("DELAY_TIME_01")
	@Column(name="DELAY_TIME_01")
	private String delayTime1;

	@JsonProperty("DELAY_TIME_02")
	@Column(name="DELAY_TIME_02")
	private String delayTime2;

	@JsonProperty("DELAY_TIME_03")
	@Column(name="DELAY_TIME_03")
	private String delayTime3;

	@JsonProperty("NEXT_INFO_DAY")
	@Column(name="NEXT_INFO_DAY")
	private String nextInfoDay;

	@JsonProperty("NEXT_INFO_TIME")
	@Column(name="NEXT_INFO_TIME")
	private String nextInfoTime;




	// jhipster-needle-entity-add-field - JHipster will add fields here
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Flight id(Long id) {
		this.id = id;
		return this;
	}



	public String getLegNo() {
		return legNo;
	}

	public void setLegNo(String legNo) {
		this.legNo = legNo;
	}

	public String getJoinFnCarrier1() {
		return joinFnCarrier1;
	}

	public void setJoinFnCarrier1(String joinFnCarrier1) {
		this.joinFnCarrier1 = joinFnCarrier1;
	}

	public String getJoinFnCarrier2() {
		return joinFnCarrier2;
	}

	public void setJoinFnCarrier2(String joinFnCarrier2) {
		this.joinFnCarrier2 = joinFnCarrier2;
	}

	public String getJoinFnCarrier3() {
		return joinFnCarrier3;
	}

	public void setJoinFnCarrier3(String joinFnCarrier3) {
		this.joinFnCarrier3 = joinFnCarrier3;
	}

	public String getAcLogicalNo() {
		return acLogicalNo;
	}

	public void setAcLogicalNo(String acLogicalNo) {
		this.acLogicalNo = acLogicalNo;
	}

	public String getIsRam() {
		return isRam;
	}

	public void setIsRam(String isRam) {
		this.isRam = isRam;
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

	public String getDelayCode1() {
		return delayCode1;
	}

	public void setDelayCode1(String delayCode1) {
		this.delayCode1 = delayCode1;
	}

	public String getDelayCode2() {
		return delayCode2;
	}

	public void setDelayCode2(String delayCode2) {
		this.delayCode2 = delayCode2;
	}

	public String getDelayCode3() {
		return delayCode3;
	}

	public void setDelayCode3(String delayCode3) {
		this.delayCode3 = delayCode3;
	}

	public String getDelayTime1() {
		return delayTime1;
	}

	public void setDelayTime1(String delayTime1) {
		this.delayTime1 = delayTime1;
	}

	public String getDelayTime2() {
		return delayTime2;
	}

	public void setDelayTime2(String delayTime2) {
		this.delayTime2 = delayTime2;
	}

	public String getDelayTime3() {
		return delayTime3;
	}

	public void setDelayTime3(String delayTime3) {
		this.delayTime3 = delayTime3;
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

	// jhipster-needle-entity-add-getters-setters - JHipster will add getters and
	// setters here

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof Flight)) {
			return false;
		}
		return id != null && id.equals(((Flight) o).id);
	}

	@Override
	public int hashCode() {
		// see
		// https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
		return getClass().hashCode();
	}

	@Override
	public String toString() {
		return "Flight{" +
				"id=" + id +
				", fnCarrier='" + fnCarrier + '\'' +
				", legNo='" + legNo + '\'' +
				", fnNumber='" + fnNumber + '\'' +
				", joinFnCarrier1='" + joinFnCarrier1 + '\'' +
				", joinFnCarrier2='" + joinFnCarrier2 + '\'' +
				", joinFnCarrier3='" + joinFnCarrier3 + '\'' +
				", fnSuffix='" + fnSuffix + '\'' +
				", dayOfOrigin='" + dayOfOrigin + '\'' +
				", acLogicalNo='" + acLogicalNo + '\'' +
				", acVersion='" + acVersion + '\'' +
				", acPrbd='" + acPrbd + '\'' +
				", acOwner='" + acOwner + '\'' +
				", acSubtype='" + acSubtype + '\'' +
				", acRegistration='" + acRegistration + '\'' +
				", depApSched='" + depApSched + '\'' +
				", arrApSched='" + arrApSched + '\'' +
				", depApActual='" + depApActual + '\'' +
				", arrApActual='" + arrApActual + '\'' +
				", legState='" + legState + '\'' +
				", legType='" + legType + '\'' +
				", depDaySched='" + depDaySched + '\'' +
				", depTimeSched='" + depTimeSched + '\'' +
				", arrDaySched='" + arrDaySched + '\'' +
				", arrTimeSched='" + arrTimeSched + '\'' +
				", depDayEst='" + depDayEst + '\'' +
				", depTimeEst='" + depTimeEst + '\'' +
				", arrDayEst='" + arrDayEst + '\'' +
				", arrTimeEst='" + arrTimeEst + '\'' +
				", offBlockDay='" + offBlockDay + '\'' +
				", offBlockTime='" + offBlockTime + '\'' +
				", onBlockDay='" + onBlockDay + '\'' +
				", onBlockTime='" + onBlockTime + '\'' +
				", isRam='" + isRam + '\'' +
				", airborneDay='" + airborneDay + '\'' +
				", airborneTime='" + airborneTime + '\'' +
				", landingDay='" + landingDay + '\'' +
				", landingTime='" + landingTime + '\'' +
				", delayCode1='" + delayCode1 + '\'' +
				", delayCode2='" + delayCode2 + '\'' +
				", delayCode3='" + delayCode3 + '\'' +
				", delayTime1='" + delayTime1 + '\'' +
				", delayTime2='" + delayTime2 + '\'' +
				", delayTime3='" + delayTime3 + '\'' +
				", nextInfoDay='" + nextInfoDay + '\'' +
				", nextInfoTime='" + nextInfoTime + '\'' +
				'}';
	}
}
