package ma.itroad.ram.tat.tatBusiness.service.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FlightDto implements Serializable {

    @JsonIgnore
    @JsonProperty("tat_max")
    private long tatMax;

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

    @JsonProperty("DAY_OF_ORIGIN_DATE")
    private LocalDate dayOfOriginAsDate;

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

    @JsonProperty("DEP_SCHED_DATE")
    private LocalDateTime depSchedAsDateTime;

    @JsonProperty("ARR_SCHED_DATE")
    private LocalDateTime arrSchedAsDateTime;

    @JsonProperty("DEP_EST_DATE")
    private LocalDateTime depEstAsDateTime;

    @JsonProperty("ARR_EST_DATE")
    private LocalDateTime arrEstAsDateTime;

   @JsonProperty("OFFBLOCK_DATE")
    private LocalDateTime offBlockAsDateTime;


    @JsonProperty("AIRBORNE_DATE")
    private LocalDateTime airborneAsDateTime;


    @JsonProperty("LANDING_DATE")
    private LocalDateTime landingAsDAteTime;


    @JsonProperty("ONBLOCK_DATE")
    private LocalDateTime onblockAsDateTime;

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

    @JsonProperty("UNIQUE_CODE")
    private String uniqueCode;

    @JsonProperty("TAT_ID")
    private long tatId;

    @JsonProperty("TAT_TYPE")
    private String tatType;

    @JsonProperty("FLIGHT_NUMBER")
    private String flightNumber;

    public LocalDate getDayOfOriginAsDate() {
        return dayOfOriginAsDate;
    }

    public void setDayOfOriginAsDate(LocalDate dayOfOriginAsDate) {
        this.dayOfOriginAsDate = dayOfOriginAsDate;
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

    public String getUniqueCode() {
        return uniqueCode;
    }

    public void setUniqueCode(String uniqueCode) {
        this.uniqueCode = uniqueCode;
    }

    public long getTatId() {
        return tatId;
    }

    public void setTatId(long tatId) {
        this.tatId = tatId;
    }

    public String getTatType() {
        return tatType;
    }

    public void setTatType(String tatType) {
        this.tatType = tatType;
    }


    public long getTatMax() {
        return tatMax;
    }

    public void setTatMax(long tatMax) {
        this.tatMax = tatMax;
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

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }
}
