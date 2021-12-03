package ma.itroad.ram.tat.coref.service.domain.enumeration;

/**
 * The TatTypeEnum enumeration.
 */
public enum TatTypeEnum {
    ARRIVEE("arrivee"),
    DEPART("depart"),
    ARRIVEE_DEPART("arrivee_depart"),
    ARRIVEE_DEPART_ARRIVEEDEPART("ARRIVEE_DEPART_ARRIVEEDEPART"),
    ARRIVEE_ARRIVEE_DEPART("ARRIVEE_ARRIVEE_DEPART"),
    DEPART_ARRIVEE_DEPART("DEPART_ARRIVEE_DEPART"),
    ARRIVEE_ARRIVEEDEPART("ARRIVEE_ARRIVEEDEPART"),
    DEPART_ARRIVEEDEPART("DEPART_ARRIVEEDEPART");
    

    private final String value;

    TatTypeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
