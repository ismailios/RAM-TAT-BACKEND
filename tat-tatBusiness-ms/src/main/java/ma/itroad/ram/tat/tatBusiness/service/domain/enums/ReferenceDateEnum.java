package ma.itroad.ram.tat.tatBusiness.service.domain.enums;

public enum ReferenceDateEnum {
    ETD("ETD"),
    ETA("ETA"),
    ATA("ATA");

    private final String value;

    ReferenceDateEnum(String value) {
        this.value = value;
    }

    public final String getValue() {
        return value;
    }

    public static boolean isETD(String s){
        return s.equals("ETD");
    }
    public static boolean isETA(String s){
        return s.equals("ETA");
    }
    public static boolean isATA(String s){
        return s.equals("ATA");
    }
}
