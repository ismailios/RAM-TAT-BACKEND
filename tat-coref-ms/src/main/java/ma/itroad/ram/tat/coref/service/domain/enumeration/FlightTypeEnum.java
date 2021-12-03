package ma.itroad.ram.tat.coref.service.domain.enumeration;

/**
 * The FlightTypeEnum enumeration.
 */
public enum FlightTypeEnum {
    MP("MP"),
    GP("GP"),
    AT7("AT7");

    private final String value;

    FlightTypeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
