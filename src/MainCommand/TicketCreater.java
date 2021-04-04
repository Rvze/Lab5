package MainCommand;

import Commands.CollectionManager;
import Exceptions.InvalidFieldException;
import subsidiary.InputChecker;

import java.io.IOException;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class TicketCreater implements TicketCreaterInterface {
    private String line;
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

    public TicketCreater(Scanner scanner, CollectionManager collectionManager) {
        scanner = scanner;
        this.collectionManager = collectionManager;
    }

    @Override
    public void setName(String name) throws InvalidFieldException {
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

    @Override
    public void askName() {
        print("Enter Ticket name: ");
        try{
            setName(lowerInput());
        }catch(InvalidFieldException e){
            print("Ticket name can't be null!");
        }
    }

    @Override
    public Long askTicketId() {
        String str;
        print("Enter the Ticket id: ");
        str = scanner.nextLine();
        if(InputChecker.checkLong(str.trim())){
            return Long.parseLong(str);
        }else
            print("Ticket id can't be null, please try again");
        return null;
    }

    @Override
    public void askCoordinateX() {
        print("Enter Ticket Coordinate X:");
        try{
            setCoordinateX(Long.parseLong(lowerInput()));
        }catch(InvalidFieldException | NumberFormatException e){
            print("Ticket Coordinates X should be long");
        }
    }

    @Override
    public void askCoordinateY() {
        print("Enter Ticket Coordinates Y: ");
        try{
            setCoordinateY(Integer.parseInt(lowerInput()));
        }catch(InvalidFieldException | NumberFormatException e){
            print("Ticket Coordinates Y should be int");
        }
    }

    @Override
    public Ticket askTicket() {

    }

    @Override
    public void setEventId() {

    }

    @Override
    public void setEventName() {

    }

    @Override
    public void setEventDescription() {

    }

    @Override
    public void setEventType() {

    }

    @Override
    public void print(String s) {
        System.out.println(s);

    }

    public String lowerInput(){
        line = scanner.nextLine().toLowerCase().trim();
        return line;
    }

}

