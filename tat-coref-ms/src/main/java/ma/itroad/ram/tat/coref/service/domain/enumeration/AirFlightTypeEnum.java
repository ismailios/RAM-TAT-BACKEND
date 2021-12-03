package ma.itroad.ram.tat.coref.service.domain.enumeration;

/**
 * The FlightTypeEnum enumeration.
 */
public enum AirFlightTypeEnum {
	CPAX("Commercial Passager"),
	MEPP("MEP passager"),
	CCAR("Commercial Cargo"),
	VESS("Vol d'essai"),
	VTRA("Vol d'entrainnement"),
	ALL("all"),
	CPAX_MEPP_VESS_VTRA("CPAX_MEPP_VESS_VTRA"),
	NULL("NULL");

    private final String value;

    AirFlightTypeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
