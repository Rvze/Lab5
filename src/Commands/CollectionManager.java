package Commands;

import MainCommand.Ticket;
import MainCommand.TicketCreater;


import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class CollectionManager {
    private static HashSet<Ticket> ticket = new HashSet<>();
    private final Date creationDate;

    public CollectionManager() {
        ticket = new HashSet<>();
        creationDate = new Date();
    }

    public static void print(String str, boolean printMod) {
        if (!printMod) {
            System.out.print(str);
        } else {
            System.out.println(str);
        }
    }

    public void help() {
        String fileName = "C:\\учеба\\программирование\\Lab5\\src\\Files\\CommandList.txt"; //"C:" + separator + "учеба" + separator + "программирование" + separator + "Lab5" + separator + "src" + separator + "Files";
        Path path = Paths.get(fileName);
        try {
            Scanner scanner = new Scanner(path);
            while (scanner.hasNextLine()) {
                print(scanner.nextLine(), true);
            }
            scanner.close();
        } catch (IOException e) {
            print("The file: " + fileName + " isn't exist", true);
        }
    }
    public void info(){
        String info = "Время инициализации коллекции: " + getInitializationTime() + "\n" + "Количество элеменотов в массиве: " +
                ticket.size() + "\n" + "Тип коллекции: " + ticket.getClass().getSimpleName();
    }
    public void show(){
        for (Ticket value : ticket) {
            System.out.println(value);
        }

    }
    public void add(TicketCreater ticketCreater){


    }
    public void updateId(){

    }
    public void removeById(){

    }
    public void clear(){

    }
    public void save(){

    }
    public void execute_script(){

    }

    public void add_if_max(){

    }
    public void remove_lower(){

    }
    public void history(){

    }
    public void count_less_than_type(){

    }
    public void filter_greater_than_event(){

    }
    public void print_field_descending_price(){

    }
    public Date getInitializationTime(){
        return creationDate;
    }


}