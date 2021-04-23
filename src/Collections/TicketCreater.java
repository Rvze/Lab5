package Collections;

import Exceptions.InvalidFieldException;
import subsidiary.IdGenerator;
import subsidiary.InputChecker;


import java.io.IOException;
import java.time.*;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class TicketCreater implements TicketCreaterInterface {
    private final boolean isScript;
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

    public TicketCreater(Scanner scanner, CollectionManager collectionManager, boolean isScript) {
        this.scanner = scanner;
        this.collectionManager = collectionManager;
        this.isScript = isScript;
    }

    @Override
    public void setName(String name) throws InvalidFieldException {
        Pattern pattern = Pattern.compile(",");
        Matcher matcher = pattern.matcher(name);
        if (name == null || name.equals(" ") || matcher.find()) {
            throw new InvalidFieldException("Invalid value for Ticket name.");
        } else
            this.name = name;
    }

    @Override
    public void setCoordinateX(long x) throws InvalidFieldException {
        if (coordinates == null) {
            this.coordinates = new Coordinates();
        }
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
    public void setPrice(Float price) throws InvalidFieldException {
        if (price < 0) {
            throw new InvalidFieldException("Invalid value for Ticket price.");
        } else
            this.price = price;

    }

    @Override
    public void setDiscount(Long discount) throws InvalidFieldException {
        if (discount == null || discount > 100 || discount < 0) {
            throw new InvalidFieldException("Invalid value for Ticket discount.");
        } else
            this.discount = discount;
    }


    @Override
    public void setType(TicketType type) throws InvalidFieldException {
        if (type == null) {
            throw new InvalidFieldException("Invalid value for Ticket type");
        } else
            this.type = type;
    }

    @Override
    public boolean setRefundable(boolean x) {
        this.refundable = x;
        return x;
    }


    @Override
    public void askName() {
        print("Enter Ticket name: ");
        try {
            setName(lowerInput());
        } catch (InvalidFieldException e) {
            print("Ticket name can't be null!");
            if (!isScript) {
                askName();
            }
        }
    }

    @Override
    public Long askTicketId() {
        String str;
        try {
            print("Enter the Ticket id: ");
            str = scanner.nextLine();

            if (InputChecker.checkLong(str.trim())) {
                return Long.parseLong(str);
            } else {
                print("Ticket id should be long, please try again");

            }

        } catch (Exception e) {
            print("Input error");
        }

        return null;

    }

    @Override
    public void askCoordinateX() {
        print("Enter Ticket Coordinate X:");
        try {
            setCoordinateX(Long.parseLong(lowerInput()));
        } catch (InvalidFieldException | NumberFormatException e) {
            print("Ticket Coordinates X should be long");
            if (!isScript) {
                askCoordinateX();
            }
        }
    }

    @Override
    public void askCoordinateY() {
        print("Enter Ticket Coordinates Y: ");
        try {
            setCoordinateY(Integer.parseInt(lowerInput()));
        } catch (InvalidFieldException | NumberFormatException e) {
            print("Ticket Coordinates Y should be int");
            if (!isScript) {
                askCoordinateY();
            }
        }
    }

    @Override
    public void askPrice() {
        print("Enter Ticket price: ");
        try {
            setPrice(Float.parseFloat(lowerInput()));
        } catch (InvalidFieldException | NumberFormatException e) {
            print("Ticket price should be float");
            if (!isScript) {
                askPrice();
            }
        }
    }

    @Override
    public void askDiscount() {
        print("Enter Ticket discount: ");
        try {
            setDiscount(Long.parseLong(lowerInput()));
        } catch (InvalidFieldException | NumberFormatException e) {
            print("Ticket discount should be long");
            if (!isScript) {
                askDiscount();
            }
        }
    }

    @Override
    public void askRefundable() {
        print("Enter Ticket refundable: ");
        setRefundable(Boolean.parseBoolean(lowerInput()));
    }

    @Override
    public void askType() {
        TicketType.printType();
        print("Enter Ticket type: ");
        try {
            setType((TicketType) checkTicketEnum((inputLine())));
        } catch (InvalidFieldException e) {
            print("There is no in Ticket type value" + line + "\nField type can`t be null");
            if (!isScript) {
                askType();
            }
        }
    }

    @Override
    public void askEventId() {
        print("Enter Event id: ");
        try {
            setEventId(Long.parseLong(lowerInput()));
        } catch (NumberFormatException e) {
            print("Event id should be long");
            if (!isScript) {
                askEventId();
            }
        }
    }

    @Override
    public void askEventName() {
        print("Enter Event name: ");
        try {
            setEventName(inputLine());
        } catch (InvalidFieldException e) {
            print("Ticket Event name can`t be void or null");
            if (!isScript)
                askEventName();
        }
    }

    @Override
    public void askEventDescription() {
        print("Enter Event description: ");
        try {
            setEventDescription(inputLine());
        } catch (InvalidFieldException e) {
            print("Ticket Event description can`t be void");
            if (!isScript)
                askEventDescription();
        }
    }

    @Override
    public void askEventType() {
        EventType.printValues();
        print("Input Ticket Event eventType: ");
        try {
            setEventType((EventType) checkEventEnum(inputLine()));
        } catch (InvalidFieldException e) {
            print("There is no in Ticket Event eventType value " + line + "\nField ");
        }
    }


    /**
     * Метод, обеспечиваюищй ввод всех полей и передачу экземпляра Ticket
     *
     * @return
     */
    @Override
    public Ticket askTicket() {
        inputFieldsFile();
        return getTicket();
    }

    /**
     * Метод, который вводит все поля
     */
    @Override
    public void inputFieldsFile() {
        askName();
        askCoordinateX();
        askCoordinateY();
        askPrice();
        askDiscount();
        askRefundable();
        askType();
        askEventId();
        askEventName();
        askEventDescription();
        askEventType();
    }

    @Override
    public Ticket getTicket() {
        return new Ticket(IdGenerator.generateId(collectionManager),name, coordinates, creationDate, price, discount, refundable, type, event);
    }

    @Override
    public Enum checkTicketEnum(String s) throws InvalidFieldException {
        for (TicketType tp : TicketType.values()) {
            if (s.equalsIgnoreCase(tp.getUrl())) {
                return tp;
            }
        }


        throw new InvalidFieldException("There is no Ticket enum named " + s);
    }

    @Override
    public Enum checkEventEnum(String s) throws InvalidFieldException {
        for (EventType et : EventType.values()) {
            if (s.equalsIgnoreCase(et.getUrl())) ;
            {
                return et;
            }
        }
        throw new InvalidFieldException("There is no Event enum named " + s);
    }


    @Override
    public void setEventId(Long eventId) {
        if (eventId == null || eventId <= 0) {
            print("Invalid value");
        } else if (event == null) {
            event = new Event();
        }
        event.setId(eventId);

    }

    @Override
    public void setEventName(String eventName) throws InvalidFieldException {
        if (eventName == null || eventName.equals("")) {
            throw new InvalidFieldException("Invalid value for Ticket Event name");
        } else {
            if (event == null) {
                event = new Event();
            }
            event.setName(eventName);
        }


    }

    @Override
    public void setEventDescription(String description) throws InvalidFieldException {
        if (description.equals("")) {
            throw new InvalidFieldException("Invalid value for Ticket Event description");
        } else if (event == null) {
            event = new Event();
        }
        event.setDescription(description);
    }

    @Override
    public void setEventType(EventType eventType) {
        this.event.setEventType(eventType);
    }

    @Override
    public void print(String s) {
        System.out.println(s);

    }

    public String inputLine() {
        line = scanner.nextLine().toLowerCase().trim();
        return line;
    }


    public String lowerInput() {
        line = scanner.nextLine().toLowerCase().trim();
        return line;
    }


}

