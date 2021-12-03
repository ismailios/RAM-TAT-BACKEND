package ma.itroad.ram.tat.tatBusiness.service.domain.enums;

public enum UserRoleEnum {

    SUPERVISOR("SUPERVISEUR"),
    CC("CC"),
    CA("CA"),
    MCC("MCC"),
    CDB("CDB"),
    OPL("OPL"),
    PC_ESCALE("PC_ESCALE"),
    OTHER("OTHER");

    private final String value;

    UserRoleEnum(String value) {
        this.value = value;
    }

    public final String getValue() {
        return value;
    }

    public static boolean isSupervisor(String s){
        return s!=null && s.equalsIgnoreCase("SUPERVISEUR");
    }
    public static boolean isCC(String s){

        return s!=null && s.equalsIgnoreCase("CC");
    }
    public static boolean isCA(String s){
        return s!=null && s.equalsIgnoreCase("CA");
    }
    public static boolean isMCC(String s){

        return s!=null && s.equalsIgnoreCase("MCC");
    }
    public static boolean isOPL(String s){
        return  s!=null && s.equalsIgnoreCase("OPL");
    }
    public static boolean isCDB(String s){
        return s!=null && s.equalsIgnoreCase("CDB");
    }
    public static boolean isPcEscale(String s){

        return s!=null &&s.equalsIgnoreCase("PC_ESCALE");
    }
}
