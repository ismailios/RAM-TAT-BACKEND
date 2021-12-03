package ma.itroad.ram.tat.tatBusiness.service.domain.enums;

public enum TatTypeEnum {

    ARR("Arr"),
    DEP("Dep"),
    ARRDEP("ArrDep");

    private final String value;

    TatTypeEnum(String value) {
        this.value = value;
    }

    public final String getValue() {
        return value;
    }


}
