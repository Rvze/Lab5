package MainCommand;

import Exceptions.InvalidFieldException;

public interface TicketCreaterInterface {
    public void setName() throws InvalidFieldException;
    public void setCoordinateX(long x) throws InvalidFieldException;
    public void setCoordinateY(Integer y) throws InvalidFieldException;
    public void setPrice() throws InvalidFieldException;
    public void setDiscount() throws InvalidFieldException;
    public boolean refundable();
    public void setType();
    public void setEvent();
}
