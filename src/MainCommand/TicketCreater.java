package MainCommand;

import Commands.CollectionManager;
import Exceptions.InvalidFieldException;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TicketCreater implements TicketCreaterInterface {
    private ZonedDateTime zonedDateTime = null;
    private final CollectionManager collectionManager;
    private Scanner scanner;
    private long id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.ZonedDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Float price; //Поле может быть null, Значение поля должно быть больше 0
    private Long discount; //Поле может быть null, Значение поля должно быть больше 0, Максимальное значение поля: 100
    private boolean refundable;
    private TicketType type; //Поле не может быть null
    private Event event; //Поле может быть null

    public TicketCreater(CollectionManager collectionManager, Scanner scanner) {
        this.collectionManager = collectionManager;
        this.scanner = scanner;
        this.refundable = refundable();
    }

    @Override
    public void setName() throws InvalidFieldException {
        if (name == null || name.equals(" ")) {
            throw new InvalidFieldException("Invalid value for Ticket name.");
        } else
            this.name = name;
    }

    @Override
    public void setCoordinateX(long x) throws InvalidFieldException {
        coordinates.setX(x);
    }

    @Override
    public void setCoordinateY(Integer y) throws InvalidFieldException {
        if (y == null) {
            throw new InvalidFieldException("Invalid value for Ticket coordinate y.");
        } else
            coordinates.setY(y);

    }


    @Override
    public void setPrice() throws InvalidFieldException {
        if (price < 0) {
            throw new InvalidFieldException("Invalid value for Ticket price.");
        }

    }

    @Override
    public void setDiscount() throws InvalidFieldException {
        if (discount == null || discount > 100 || discount < 0) {
            throw new InvalidFieldException("Invalid value for Ticket discount.");
        }
    }

    @Override
    public boolean refundable() {
        return true;
    }

    @Override
    public void setType() {

    }

    @Override
    public void setEvent() {

    }
}

