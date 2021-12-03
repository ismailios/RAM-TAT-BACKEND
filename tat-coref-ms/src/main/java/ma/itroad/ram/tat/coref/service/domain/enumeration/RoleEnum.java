package ma.itroad.ram.tat.coref.service.domain.enumeration;

/**
 * The RoleEnum enumeration.
 */
public enum RoleEnum {
    CDB("CDB"),
    OPL("OPL"),
    SUPERVISEUR("SUPERVISEUR"),
    CCO("CCO"),
    MCC("MCC"),
    PC_ESCALE("pc_escale"),
    CA("CA"),
    FUELING_MANAGER("fueling_manager"),
    CC("CC"),
    DOS("dos"),
    TOP_MANAGEMENT("top_management");

    private final String value;

    RoleEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
