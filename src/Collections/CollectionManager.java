package Collections;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectionManager {
    private static HashSet<Ticket> tickets = new HashSet<>();
    private final Date creationDate;
    private final HashSet<Long> idList;

    public CollectionManager() {
        tickets = new HashSet<>();
        creationDate = new Date();
        idList = new HashSet<>();
    }


    public void info() {
        print("Время инициализации коллекции: " + getInitializationTime() + "\n" + "Количество элеменотов в массиве: " +
                tickets.size() + "\n" + "Тип коллекции: " + tickets.getClass().getSimpleName());

    }

    public boolean addElement(Ticket ticket1) {
        if (tickets.contains(ticket1)) {
            print("Element is already exist in collection");
            return false;
        } else {
            tickets.add(ticket1);
            print("Element is added successfully");
            return true;
        }

    }

    /**
     * @return ticket
     */
    public HashSet<Ticket> getTicket() {
        return tickets;
    }


    public Stream<Ticket> getTicketStream() {
        return tickets.stream();
    }

    /**
     * Метод, отвчеающий за кол-во элементов меньше заданного
     *
     * @param ticketType
     */

    public void countLessThanType(TicketType ticketType) {
        int count = 0;
        for (Ticket tic : tickets) {
            if (tic.getTicketType().getValue() < ticketType.getValue()) {
                count++;
            }
        }
        print("Count of elements is: " + count);
    }

    /**
     * Метод, выводящий значения поля event меньше заданного
     *
     * @param ticket
     */
    public void filterGreaterThanEvent(Event ticket) {
        int cnt = 0;
        for (Ticket tick : tickets) {
            if (tick.getEvent().getId() < ticket.getId()) {
                cnt++;
                System.out.println(TStringShower.toStrView(tick));
            }
        }
        System.out.println("Finally found " + cnt + " elements!");
    }

    /**
     * Метод, выводящий значения поля price всех элементов в порядке убывания
     */
    public void printFieldDescendingPrice() {
        Vector<Ticket> temp = tickets.stream().collect(Collectors.toCollection(Vector::new));
        Collections.sort(temp);
        Collections.reverse(temp);
        for (Ticket tick : temp) {
            System.out.println(tick);
        }
    }


    public HashSet<Long> getIdList() {
        return idList;
    }

    /**
     * Метод, отвечающий за удаление элементов, меншьший заданного
     *
     * @param ticket
     */
    public void removeLower(Ticket ticket) {
        int count = 0;
        boolean flag = true;
        while (flag) {
            for (Ticket t : CollectionManager.tickets) {
                if (t.getId() < ticket.getId()) {
                    CollectionManager.tickets.remove(t);
                    count++;
                    flag = true;
                    break;
                }
                flag = false;
            }
        }
        print(count + " elements removed");
    }

    /**
     * Метод, отвечающий за обновление элемента, по id
     *
     * @param id
     * @param tickets
     * @return
     */
    public boolean update(long id, Ticket tickets) {
        for (Ticket t : CollectionManager.tickets) {
            if (t.getId() == id) {
                removeById(id);
                tickets.setId(id);
                CollectionManager.tickets.add(tickets);
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
        if (tickets.removeIf(x -> x.getId() == id)) {
            print("Element is successfully removed from collection");
        } else {
            print("Element is not removed from collection");
        }
    }

    /**
     * Метод, очищающий коллекцию
     */
    public void clear() {
        tickets.clear();
        print("The collection successfully cleared");

    }


    /**
     * Метод, проверяющий есть ли элемент с данным id
     *
     * @param id
     * @return
     */
    public boolean checkId(long id) {
        for (Ticket ticket : tickets) {
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