package Collections;

import Collections.Event;
import Collections.Ticket;


import Collections.TicketType;


import java.util.*;
import java.util.stream.Stream;

public class CollectionManager {
    private static HashSet<Ticket> ticket = new HashSet<>();
    private final Date creationDate;
    private final HashSet<Long> idList;

    public CollectionManager() {
        ticket = new HashSet<>();
        creationDate = new Date();
        idList = new HashSet<>();
    }


    public void info() {
        print("Время инициализации коллекции: " + getInitializationTime() + "\n" + "Количество элеменотов в массиве: " +
                ticket.size() + "\n" + "Тип коллекции: " + ticket.getClass().getSimpleName());

    }


    public void show() {
        for (Ticket value : ticket) {
            System.out.println(value.toString());
        }

    }

    public boolean addElement(Ticket ticket1) {
        if (ticket.contains(ticket1)) {
            print("Element is already exist in collection");
            return false;
        } else {
            ticket.add(ticket1);
            print("Element is added successfully");
            return true;
        }

    }

    /**
     * @return ticket
     */
    public HashSet<Ticket> getTicket() {
        return ticket;
    }


    public Stream<Ticket> getTicketStream() {
        return ticket.stream();
    }

    /**
     * Метод, отвчеающий за кол-во элементов меньше заданного
     *
     * @param ticketType
     */

    public void countLessThanType(TicketType ticketType) {
        int count = 0;
        for (Ticket tic : ticket) {
            if (tic.getTicketType().getValue() < ticketType.getValue()) {
                count++;
            }
        }
        print("Count of elements is: " + count);
    }


    public void filterGreaterThanEvent(Event eventGreater) {
        for (Ticket event : ticket) {
            if (event.getId() > eventGreater.getId()) {
                System.out.println(eventGreater);
            }
        }
    }

    public void printFieldDescendingPrice(Ticket price) {
        for (Ticket tic : ticket) {
            tic.compareTo(price);
        }
    }


    /**
     * Метод, отвечающий за удаление элементов, меншьший заданного
     *
     * @param tickets
     */
    public void removeLower(Ticket tickets) {
        int count = 0;
        boolean flag = true;
        while (flag) {
            for (Ticket t : ticket) {
                if (t.getId() < tickets.getId()) {
                    ticket.remove(t);
                    count++;
                    flag = true;
                    break;
                }
                flag = false;
            }
        }
        print(count + " elements removed");
    }

    public boolean update(long id, Ticket tickets) {
        for (Ticket t : ticket) {
            if (t.getId() == id) {
                removeById(id);
                tickets.setId(id);
                ticket.add(tickets);
                print("Element is updated!");
                return true;
            }
        }
        print("Element is not updated");
        return false;
    }

    /**
     * Метод, отвечающий за удаление элемента коллекции по id
     *
     * @param id
     */
    public void removeById(long id) {
        if (ticket.removeIf(x -> x.getId() == id)) {
            print("Element is successfully removed from collection");
        } else {
            print("Element is not removed from collection");
        }
    }

    /**
     * Метод, очищающий коллекцию
     */
    public void clear() {
        ticket.clear();
        print("The collection successfully cleared");

    }


    /**
     * Метод, проверяющий есть ли элемент с данным id
     *
     * @param id
     * @return
     */
    public boolean checkId(long id) {
        for (Ticket ticket : ticket) {
            if (ticket.getId() == id) {
                return true;
            }
        }
        return false;
    }


    public Date getInitializationTime() {
        return creationDate;
    }

    public void print(String str) {
        System.out.println(str);
    }


}