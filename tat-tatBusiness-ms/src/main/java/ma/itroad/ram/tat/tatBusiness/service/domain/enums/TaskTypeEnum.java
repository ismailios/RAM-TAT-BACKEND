package ma.itroad.ram.tat.tatBusiness.service.domain.enums;

public enum TaskTypeEnum {

    PRINCIPAL("PRINCIPALE"),
    AUTOMATIC("AUTOMATQIUE"),
    EXCEPTIONAL("EXCEPTIONNELLE");

    private final String value;

    TaskTypeEnum(String value) {
        this.value = value;
    }

    public final String getValue() {
        return value;
    }

    public static boolean principal(String s){
        if(s==null) return false;
        return s.equals("PRINCIPALE");
    }
    public static boolean automatic(String s){
        if(s==null) return false;
        return s.equals("AUTOMATQIUE");
    }
    public static boolean exceptional(String s){
        if(s==null) return false;
        return s.equals("EXCEPTIONNELLE");
    }
}
