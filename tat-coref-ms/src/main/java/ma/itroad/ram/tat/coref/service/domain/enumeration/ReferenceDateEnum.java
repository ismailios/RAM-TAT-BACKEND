package ma.itroad.ram.tat.coref.service.domain.enumeration;

/**
 * The ReferenceDateEnum enumeration.
 */
public enum ReferenceDateEnum {
    ETA("eta"),
    ATA("ata"),
    ETD("etd");

    private final String value;

    ReferenceDateEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
