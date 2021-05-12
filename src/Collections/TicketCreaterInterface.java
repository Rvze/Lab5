package Collections;

import Exceptions.InvalidFieldException;

public interface TicketCreaterInterface {
    void setTicketId(Long id) throws InvalidFieldException;

    void setName(String name) throws InvalidFieldException;

    void setCoordinateX(long x) throws InvalidFieldException;

    void setCoordinateY(Integer y) throws InvalidFieldException;

    void setPrice(Float price) throws InvalidFieldException;

    void setDiscount(Long discount) throws InvalidFieldException;


    void setType(TicketType ticketType) throws InvalidFieldException;

    boolean setRefundable(boolean x);


    void askName();

    Long askTicketId();

    void askCoordinateX();

    void askCoordinateY();

    void askPrice();

    void askDiscount();

    void askRefundable();

    void askType();

    void askEventId();

    void askEventName();

    void askEventDescription();

    void askEventType();

    Ticket askTicket();

    void inputFieldsFile();

    Ticket getTicket();

    Enum checkTicketEnum(String s) throws InvalidFieldException;

    Enum checkEventEnum(String s) throws InvalidFieldException;

    void setEventId(Long EventId);

    void setEventName(String EventName) throws InvalidFieldException;

    void setEventDescription(String description) throws InvalidFieldException;

    void setEventType(EventType eventType);

    void print(String s);


}



