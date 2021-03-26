package MainCommand;

public enum TicketType {
    USUAL("Usual"),
    BUDGETARY("Budgetarty"),
    CHEAP("Cheap");
    private final String url;
    TicketType(String url){
        this.url = url;
    }

    public static void printType(){
        System.out.println();
        for (TicketType tp : TicketType.values()){
            System.out.println(tp.getUrl());
        }
    }
    public String getUrl() {
        return url;
    }
}