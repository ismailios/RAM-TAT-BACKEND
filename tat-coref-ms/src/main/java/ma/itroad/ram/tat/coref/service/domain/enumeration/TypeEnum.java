package ma.itroad.ram.tat.coref.service.domain.enumeration;

/**
 * The TypeEnum enumeration.
 */
public enum TypeEnum {
    PRINCIPALE("PRINCIPALE"),
    EXCEPTIONNELLE("EXCEPTIONNELLE"),
    AUTOMATIQUE("AUTOMATIQUE");
	
    private final String value;

    TypeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
