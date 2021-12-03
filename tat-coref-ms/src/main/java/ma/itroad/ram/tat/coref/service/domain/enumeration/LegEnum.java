package ma.itroad.ram.tat.coref.service.domain.enumeration;

/**
 * The LegEnum enumeration.
 */
public enum LegEnum {
        A("A"),
        B("B"),
         C("C"),
         D("D"),
         E("E"),
         F("F"),
         G("G"),
         H("H"),
         I("I"),
         J("J"),
         K("K"),
         L("L"),
         M("M"),
         N("N"),
         O("O"),
         P("P"),
         Q("Q"),
         R("R"),
         S("S"),
         T("T"),
         U("U"),
         V("V"),
         W("W"),
         X("X"),
         Y("Y"),
         Z("Z");


    private final String value;

    LegEnum (String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
