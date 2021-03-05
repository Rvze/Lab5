package Commands;

import MainCommand.Ticket;


import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Scanner;

public class CollectionManager {
    private static HashSet<Ticket> ticket = new HashSet<>();

    public CollectionManager() {
        ticket = new HashSet<>();
    }

    public static void print(String str, boolean printMod) {
        if (!printMod) {
            System.out.print(str);
        } else {
            System.out.println(str);
        }
    }

    public void help() {
        String separator = File.separator;
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


}