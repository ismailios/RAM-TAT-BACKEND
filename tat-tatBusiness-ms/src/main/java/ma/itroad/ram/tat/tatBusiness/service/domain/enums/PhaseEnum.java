package ma.itroad.ram.tat.tatBusiness.service.domain.enums;

public enum PhaseEnum {
    DEPART("DEPART"),
    ARRIVEE("ARRIVEE"),
    ARRIVEE_DEPART("ARRIVEE_DEPART");

    private final String value;

    PhaseEnum(String value) {
        this.value = value;
    }

    public final String getValue() {
        return value;
    }

    public static boolean isArrival(String s){
        return s.equals("ARRIVEE");
    }
    public static boolean isDeparture(String s){
        return s.equals("DEPART");
    }
    public static boolean isArrDep(String s){
        return s.equals("ARRIVEE_DEPART");
    }
}
