package Collections;

public enum TicketType {
    USUAL("Usual", 1),
    BUDGETARY("Budgetarty", 2),
    CHEAP("Cheap", 3);
    private final String url;
    private final int value;

    TicketType(String url, int value) {
        this.url = url;
        this.value = value;
    }

    public static void printType() {
        System.out.println();
        for (TicketType tp : TicketType.values()) {
            System.out.println(tp.getUrl());
        }
    }


    public int getValue() {
        return value;
    }

    public String getUrl() {
        return url;
    }
}