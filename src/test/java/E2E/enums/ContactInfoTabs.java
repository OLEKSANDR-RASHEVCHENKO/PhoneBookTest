package E2E.enums;

public enum ContactInfoTabs {
    INFO ("2"),
    PHONES("3"),
    EMAILS("4"),
    ADRESSES("5");

    public final String value;
    ContactInfoTabs(String value){
        this.value=value;
    }
}
