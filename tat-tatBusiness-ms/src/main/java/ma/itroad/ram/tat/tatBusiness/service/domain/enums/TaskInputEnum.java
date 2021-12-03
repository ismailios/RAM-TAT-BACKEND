package ma.itroad.ram.tat.tatBusiness.service.domain.enums;

public enum TaskInputEnum {

    FUELING("FUELING"),
    REMAINING_WATER8_QUANTITY("EAU_POTABLE_RESTANT"),
    WATER_QUANTITY("EAU_POTABLE_A_BORD"),
    OTHER("OTHER");

    private final String value;

    TaskInputEnum(String value) {
        this.value = value;
    }

    public final String getValue() {
        return value;
    }


}
