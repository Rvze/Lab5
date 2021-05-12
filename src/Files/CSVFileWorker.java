package Files;

import Collections.*;
import Exceptions.InvalidFieldException;
import subsidiary.InputChecker;

import java.io.*;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CSVFileWorker implements CSVFileWorkerInterface, FileWorker {
    private final CollectionManager manager;
    private String saveFilePath;
    private String filePath;

    private String separator;
    private Scanner scanner;

    public CSVFileWorker(CollectionManager collectionManager) {
        manager = collectionManager;
    }


    @Override
    public String getSeparator() {
        return separator;
    }

    @Override
    public void setSeparator(String separator) {
        this.separator = separator;
    }


    @Override
    public String getSaveFilePath() {
        return saveFilePath;
    }

    /**
     * Метод, реализующий ввод пути файла
     */
    @Override
    public void inputFilePath() {
        print("Enter the path to file");
        scanner = new Scanner(System.in);
        filePath = scanner.nextLine().trim();
        File file = new File(filePath);
        while (file.isDirectory() || !file.exists() || !file.canRead()) {
            if (!file.exists()) {
                print("File isn`t exist");
            } else if (file.isDirectory()) {
                print("This is not file, this is directory");
            } else if (!file.canRead()) {
                print("File can't be read");
            }
            filePath = scanner.nextLine();
            file = new File(filePath.trim());
        }
        try {
            scanner = new Scanner(new FileReader(filePath));
        } catch (FileNotFoundException e) {
            print("File path isn't correct, try again!");
            return;
        }
        print("File path is correct, let's go");
    }

    public void inputSaveFilePath() {
        print("Enter the path to save file");
        scanner = new Scanner(System.in);
        try {
            saveFilePath = scanner.nextLine().trim();
        }catch(NoSuchElementException e){
            print("jopa");
        }
        File file = new File(saveFilePath);
        while (file.isDirectory() || !file.exists() || !file.canRead()) {
            if (!file.exists()) {
                print("File isn`t exist");
            } else if (file.isDirectory()) {
                print("This is not file, this is directory");
            } else if (!file.canRead()) {
                print("File can't be read");
            }
            saveFilePath = scanner.nextLine();
            file = new File(saveFilePath.trim());
        }
        try {
            scanner = new Scanner(new FileReader(saveFilePath));
        } catch (FileNotFoundException e) {
            print("File path isn't correct, try again!");
            return;
        }
        print("File path is correct, let's go");
    }

    /**
     * Метод, обеспечивающий запись в файл
     *
     * @param str
     */
    @Override
    public void write(String[] str) {
        try {
            File file;
            if (saveFilePath == null) {
                inputSaveFilePath();
                while (!(file = new File(saveFilePath)).canWrite()) {
                    print("Unable to write to this file, please try again:");
                    inputSaveFilePath();
                }
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(saveFilePath));
            for (String s : str) {
                bufferedWriter.write(s);
                bufferedWriter.newLine();
            }
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    /**
     * Парсит из массива строк в элемент коллекции
     *
     * @param values
     * @return
     */
    @Override
    public Ticket read(String[] values) {
        TicketCreaterInterface ticketCreater = new TicketCreater(scanner, manager, false);
        for (int i = 0; i < values.length; i++) {
            values[i] = values[i].trim();
            if (values[i].isEmpty()) {
                print("You has empty field in the file");
                return null;
            }
        }
        try {
            ticketCreater.setName(values[0]);
            if (InputChecker.checkLong(values[1]))
                ticketCreater.setCoordinateX(Long.parseLong(values[1]));
            else
                throw new InvalidFieldException("Coordinate X should be long");
            if (InputChecker.checkInt(values[2]))
                ticketCreater.setCoordinateY(Integer.parseInt(values[2]));
            else
                throw new InvalidFieldException("Coordinate Y should be int");
            if (InputChecker.checkFloat(values[3]))
                ticketCreater.setPrice(Float.parseFloat(values[3]));
            else
                throw new InvalidFieldException("Price should be float");
            if (InputChecker.checkLong(values[4]))
                ticketCreater.setDiscount(Long.parseLong(values[4]));
            else
                throw new InvalidFieldException("Ticket discount should be long");
            ticketCreater.setRefundable(Boolean.parseBoolean(values[5]));
            ticketCreater.setType((TicketType) ticketCreater.checkTicketEnum(values[6]));
            if (InputChecker.checkLong(values[7]))
                ticketCreater.setEventId(Long.parseLong(values[7]));
            ticketCreater.setEventName(values[8]);
            ticketCreater.setEventDescription(values[9]);
            ticketCreater.setEventType((EventType) ticketCreater.checkEventEnum(values[10]));

        } catch (InvalidFieldException e) {
            print(e.getMessage());
            return null;
        }
        return ticketCreater.getTicket();
    }

    @Override
    public void loadInput(HashSet<Ticket> hashSet) {
        inputFilePath();
        setSeparator(",");
        try {
            scanner = new Scanner(new FileReader(getFilePath().trim()));
            String line;
            while ((scanner.hasNextLine())) {
                line = scanner.nextLine();
                String[] lines = line.split(getSeparator());
                if (lines.length != 11) {
                    print("You have the wrong number of fields, element will not added to the collection");
                    continue;
                }
                Ticket ticket = read(lines);
                if (ticket != null) {
                    print("Element " + ticket.getName() + " is successfully added to the collection");
                    hashSet.add(ticket);
                } else {
                    print("Ticket instance is not added to the collection");
                }
            }
        } catch (IOException e) {
            print("Incorrect file path");
        }
    }

    /**
     * Метод, обеспечивающий за строковое представление элементов коллекции в csv файле
     *
     * @param tickets
     * @return
     */
    @Override
    public String[] parseToString(HashSet<Ticket> tickets) {
        String[] strings = new String[tickets.size()];
        int index = 0;
        for (Ticket ticket : tickets) {
            strings[index] = String.valueOf(ticket.getId());
            strings[index] = ticket.getName();
            strings[index] += ',' + String.valueOf(ticket.getCoordinates().getX());
            strings[index] += ',' + String.valueOf(ticket.getCoordinates().getY());
            strings[index] += ',' + ticket.getCreationDate().toString();
            strings[index] += ',' + ticket.getPrice();
            strings[index] += ',' + ticket.getDiscount();
            strings[index] += ',' + String.valueOf(ticket.getType());
            strings[index] += ',' + ticket.getEvent().getId();
            strings[index] += ',' + ticket.getEvent().getName();
            strings[index] += ',' + ticket.getEvent().getDescription();
            strings[index] += ',' + ticket.getEvent().getEventType().getUrl();
            strings[index] += ',' + ticket.getTicketType().getUrl();
            index++;
        }
        return strings;
    }

    private String toCSVString(Ticket ticket) {
        StringBuilder str = new StringBuilder();
        str.append(ticket.getId() + ",");
        str.append(ticket.getName() + ",");
        str.append(ticket.getCoordinates() + ",");
        str.append(ticket.getCreationDate() + ",");
        str.append(ticket.getPrice() + ",");
        str.append(ticket.getDiscount() + ",");
        //str.append(ticket.getRefundable()+",");
        str.append(ticket.getType() + ",");
        str.append(ticket.getEvent() + ",");
        return String.valueOf(str);
    }

    private void print(String s) {
        System.out.println(s);
    }

    public String getFilePath() {
        return filePath;
    }
}
