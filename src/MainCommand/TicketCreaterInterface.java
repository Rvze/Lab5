package MainCommand;

import Exceptions.InvalidFieldException;

public interface TicketCreaterInterface {
    void setName(String name) throws InvalidFieldException;

    void setCoordinateX(long x) throws InvalidFieldException;

    void setCoordinateY(Integer y) throws InvalidFieldException;

    void setPrice() throws InvalidFieldException;

    void setDiscount() throws InvalidFieldException;

    boolean refundable();

    void setType();

    void setEvent();

    void askName();

    Long askTicketId();

    void askCoordinateX();

    void askCoordinateY();

    Ticket askTicket();

    void setEventId();

    void setEventName();

    void setEventDescription();

    void setEventType();

    void print(String s);
    }


}
