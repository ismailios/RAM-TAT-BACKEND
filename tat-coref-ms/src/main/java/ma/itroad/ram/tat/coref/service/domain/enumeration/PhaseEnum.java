package ma.itroad.ram.tat.coref.service.domain.enumeration;

/**
 * The TatTypeEnum enumeration.
 */
public enum PhaseEnum {
    ARRIVEE("arrivee"),
    DEPART("arrivee"),
    ARRIVEE_DEPART("arrivee_depart");

    private final String value;

    PhaseEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

