package ma.itroad.ram.tat.tatBusiness.service.domain.enums;

public enum StatusEnum {

    NON_STARTED("NON_STARTED"),
    IN_PROGRESS("IN_PROGRESS"),
    FINISHED("FINISHED"),
    INTERRUPTED("INTERRUPTED"),
    NOT_APPLICABLE("NOT_APPLICABLE"),
    CANCELED("CANCELED"),
    OTHER("OTHER");

    private final String value;

    StatusEnum(String value) {
        this.value = value;
    }

    public final String getValue() {
        return value;
    }

    public static boolean nonStarted(String s){
        if(s==null) return false;
        return s.equals("NON_STARTED");
    }
    public static boolean inProgress(String s){

        if(s==null) return false;
        return s.equals("IN_PROGRESS");
    }
    public static boolean finished(String s){

        if(s==null) return false;
        return s.equals("FINISHED");
    }


}
