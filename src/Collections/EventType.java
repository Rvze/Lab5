package Collections;

public enum EventType {
    CONCERT("concert"),
    FOOTBALL("football"),
    BASEBALL("baseball"),
    BASKETBALL("basketball");


    private final String url;

    EventType(String url) {
        this.url = url;
    }

    public static void printValues(){
        System.out.println("List of EventType enum values:");
        for(EventType et : EventType.values()){
            System.out.println(et.getUrl());
        }
    }

    public String getUrl() {
        return url;
    }
}