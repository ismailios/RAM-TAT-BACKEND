package ma.itroad.ram.tat.tatBusiness.service.domain.enums;

public enum LegStateEnum {
    CNL("CNL"),
    DEP("DEP"),
    ARR("ARR"),
    DIV("DIV"),
    RTR("RTR"),
    SKD("SKD"),
    NEW("NEW"),
    ON("ON"),
    OUT("OUT"),
    ETD("ETD"),
    NXI("NXI"),
    OTHER("OTHER");

    private final String value;

    LegStateEnum(String value) {
        this.value = value;
    }

    public final String getValue() {
        return value;
    }


    public static LegStateEnum legStateEnum(String value) {
        for(LegStateEnum v : values())
            if(v.getValue().equalsIgnoreCase(value)) return v;
        return OTHER;
    }



}
