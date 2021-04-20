package Collections;

public interface TStringShower {
    static String toStrView(Ticket t){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Ticket{id=" + t.getId() +
                ", name='"+t.getName() +
                "', coordinates =Coordinates{x=" + t.getCoordinates().getX()+
                ", y=" + t.getCoordinates().getY()+
                "}, creationDate=" + t.getCreationDate().toString()+
                ", price=" + t.getPrice()+
                ", discount=" + t.getDiscount()+
                ", type=" + t.getType()+
                ", EventId=" + t.getEvent().getId()+
                ", EventName=" + t.getEvent().getName()+
                ", EventDescription" + t.getEvent().getDescription()+
                ", EventType=" + t.getEvent().getEventType());
        return stringBuilder.toString();
    }
}
