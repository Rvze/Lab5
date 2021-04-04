package Files;

import Commands.CollectionManager;
import MainCommand.Ticket;

import java.io.*;
import java.util.HashSet;
import java.util.Scanner;

public class CSVFileWorker implements CSVFileWorkerInterface, FileWorker {
    private final CollectionManager manager;
    private String filePath;
    private String separator;
    private Scanner scanner;

    public CSVFileWorker(CollectionManager collectionManager) {
        manager = collectionManager;
    }


    @Override
    public String getSeparator() {
        return null;
    }

    @Override
    public void getSeparator(String separator) {

    }

    @Override
    public String getFilePath() {
        return null;
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
        try{
            scanner = new Scanner(new FileReader(filePath));
        }catch (FileNotFoundException e){
            print("File path isn't correct, try again!");
            return;
        }
        print("File path is correct, let's go");
    }


    @Override
    public void write(String[] str) {
        try {
            String saveFilePath = System.getenv("");
            File file;
            if (saveFilePath == null) {
                print("The path in the environment variable is incorrect");
                inputFilePath();
                saveFilePath = getFilePath();
                while (!(file = new File(saveFilePath)).canWrite()) {
                    print("Unable to write to this file, please try again:");
                    inputFilePath();
                    saveFilePath = getFilePath();
                }
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(saveFilePath));
            for (String s : str) {
                bufferedWriter.write(s);
                bufferedWriter.close();
            }
        }catch (IOException ioException){
            ioException.printStackTrace();
        }
    }

    @Override
    public Ticket read(String[] values) {
        return null;
    }

    @Override
    public void loadInput(HashSet<Ticket> hashSet) {

    }

    @Override
    public String[] parseToString(HashSet<Ticket> hashSet) {
        return new String[0];
    }

    public void print(String s) {
        System.out.print(s);
    }
}
