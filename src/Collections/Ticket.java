package Collections;

import java.time.ZonedDateTime;
import java.util.Comparator;
import java.util.Objects;

public class Ticket implements Comparable<Ticket> {
    private long id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.ZonedDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Float price; //Поле может быть null, Значение поля должно быть больше 0
    private Long discount; //Поле может быть null, Значение поля должно быть больше 0, Максимальное значение поля: 100
    private boolean refundable;
    private TicketType type; //Поле не может быть null
    private Event event; //Поле может быть null
    private static TicketComparator ticketComparator = new TicketComparator();

    public Ticket(long id, String name, Coordinates coordinates, ZonedDateTime creationDate, Float price,
                  Long discount, boolean refundable, TicketType type, Event event) {
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = ZonedDateTime.now();
        this.price = price;
        this.discount = discount;
        this.refundable = refundable;
        this.type = type;
        this.event = event;
    }

    public Ticket() {

    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public ZonedDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(ZonedDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Long getDiscount() {
        return discount;
    }

    public void setDiscount(Long discount) {
        this.discount = discount;
    }

    public boolean isRefundable() {
        return refundable;
    }

    public void setRefundable(boolean refundable) {
        this.refundable = refundable;
    }

    public TicketType getType() {
        return type;
    }

    public void setType(TicketType type) {
        this.type = type;
    }

    public Event getEvent() {
        return event;
    }


    public TicketType getTicketType() {
        return type;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coordinates=" + coordinates +
                ", creationDate=" + creationDate +
                ", price=" + price +
                ", discount=" + discount +
                ", refundable=" + refundable +
                ", type=" + type +
                ", event=" + event +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return id == ticket.id && refundable == ticket.refundable && name.equals(ticket.name) && coordinates.equals(ticket.coordinates) && creationDate.equals(ticket.creationDate) && price.equals(ticket.price) && discount.equals(ticket.discount) && type == ticket.type && event.equals(ticket.event);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, coordinates, creationDate, price, discount, refundable, type, event);
    }


    @Override
    public int compareTo(Ticket o) {
        if (price - o.getPrice() > 0)
            return 1;
        else if (o.getPrice() - price > 0)
            return -1;
        else
            return 0;
    }

    public int compareByTicket(Ticket t) {
        return (int)(id-t.getId());
    }

    public static TicketComparator getTicketComparator() {
        return ticketComparator;
    }

    static class TicketComparator implements Comparator<Ticket> {
        public int compare(Ticket h1, Ticket h2) {
            if (h1.getId() == h2.getId()) {
                return 0;
            }
            if (h1.getId() > h2.getId()) {
                return 1;
            }
            else {
                return -1;
            }
        }
    }
}
