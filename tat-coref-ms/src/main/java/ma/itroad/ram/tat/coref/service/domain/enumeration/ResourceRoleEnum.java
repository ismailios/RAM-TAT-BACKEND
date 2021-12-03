package ma.itroad.ram.tat.coref.service.domain.enumeration;

/**
 * The ResourceRoleEnum enumeration.
 */
public enum ResourceRoleEnum {
    CHEF_EQUIPE("chef_equipe"),
    AGENT_EMBARQUEMENT("agent_embarquement"),
    AGENT_SALLE("agent_salle");

    private final String value;

    ResourceRoleEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
