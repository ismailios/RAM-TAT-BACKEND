package ma.itroad.ram.tat.coref.service.domain.enumeration;

/**
 * The GroupTaskEnum enumeration.
 */
public enum GroupTaskEnum {
    TRAITEMENT_AVION("traitement_avion"),
    PASSAGE("passage"),
    PNC("pnc"),
    CATERING("catering"),
    MAINTENANCE("maintenance"),
    PNT("pnt"),
    TIERS_1("tiers_1"),
    TIERS_2("tiers_2"),
    ALL("ALL");

    private final String value;

    GroupTaskEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
