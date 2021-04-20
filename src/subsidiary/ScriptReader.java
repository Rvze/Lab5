package subsidiary;

import Collections.CollectionManager;

import Collections.TicketCreater;
import Commands.*;
import Exceptions.ScriptException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.channels.ScatteringByteChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * Класс, обеспечивающий считывание из текстового файла, для выполнения скрипта
 */
public class ScriptReader {
    private static final List<String> scriptPaths = new ArrayList<>();
    private static String filePath;
    private static Scanner scanner;
    private HashMap<String, AbstractCommand> commandMap;

    public ScriptReader(CollectionManager collectionManager) {
        commandMap = new HashMap<>();
        try {
            scanner = new Scanner(new FileReader(filePath.trim()));
        } catch (FileNotFoundException e) {
            System.err.println("File " + filePath.trim() + " is not found!");
        }
        TicketCreater ticketCreater = new TicketCreater(scanner, collectionManager, true);
        commandMap = new HashMap<>();
        commandMap.put("help", new HelpCommand(commandMap));
        commandMap.put("info", new InfoCommand(collectionManager));
        commandMap.put("show", new ShowCommand(collectionManager));
        commandMap.put("add", new AddCommand(collectionManager, ticketCreater));
        commandMap.put("update_id", new UpdateIdCommand(collectionManager, ticketCreater));
        commandMap.put("remove_by_id", new RemoveByIdCommand(collectionManager, ticketCreater));
        commandMap.put("clear", new ClearCommand(collectionManager, ticketCreater));
        commandMap.put("save", new SaveCommand(collectionManager));
        commandMap.put("exit", new ExitCommand());
        commandMap.put("add_if_max", new Add_If_MaxCommand(collectionManager, ticketCreater));
        commandMap.put("remove_lower", new Remove_LowerCommand(collectionManager, ticketCreater));
        commandMap.put("history", new HistoryCommand());
        commandMap.put("count_less_than_type", new Count_Less_Than_TypeCommand(collectionManager, ticketCreater));
        commandMap.put("filter_greater_than_event", new Filter_Greater_Than_EventCommand(collectionManager, ticketCreater));
        commandMap.put("print_field_descending_price", new Print_Field_Descending_PriceCommand(collectionManager));
        commandMap.put("execute_script", new ExecuteScriptFileCommand(collectionManager));
    }

    /**
     * Метод, отвечающий за ввод пути файла
     */
    public static void inputFilePath() throws ScriptException {
        print("Enter the file path: ");
        Scanner scanFilePath = new Scanner(System.in);
        filePath = scanFilePath.nextLine().trim();
        File file = new File(filePath);
        while (!file.exists() || file.isDirectory()) {
            print("File path is incorrect, pls try again");
            filePath = scanFilePath.nextLine();
            file = new File(filePath);
        }
        scriptPaths.add(filePath);
        print("The path to the file is successfully entered");
    }

    /**
     * Метод, отвечающий за чтение пути файла из файла
     *
     * @throws ScriptException
     */
    public static void inputFilePathScript() throws ScriptException {
        filePath = scanner.nextLine();
        File file = new File(filePath);
        if (file.exists() && file.isDirectory()) {
            if (!checkPath(filePath))
                scriptPaths.add(filePath);
        } else
            throw new ScriptException();
    }

    /**
     * Метод, проверяющий, был ли использован ранее скрипт
     *
     * @param path
     * @return
     */
    public static boolean checkPath(String path) {
        if (scriptPaths.contains(path)) {
            return true;
        } else {
            scriptPaths.add(path);
            return false;
        }
    }

    /**
     * Очищает историю использованных скриптов
     */
    public static void clearPaths() {
        scriptPaths.clear();
    }

    /**
     * Обеспечивате общение клиента и ScriptReader
     *
     * @param s
     */
    public static void print(String s) {
        System.out.println(s);
    }

    /**
     * Основной метод, проходящийся по командам скрипта
     *
     * @return
     */
    public boolean readCommand() {
        String userCommand = scanner.nextLine();
        while (scanner.hasNext()) {
            String[] updatedUC = userCommand.trim().split(" ");
            if (commandMap.containsKey(updatedUC[0])) {
                commandMap.get(updatedUC[0]).execute(updatedUC);
                CommandReaderInterface.addToHistory(updatedUC[0]);
            } else {
                print("Данной команды не существует");
            }
            userCommand = scanner.nextLine();
        }
        String[] updatedUC = userCommand.trim().split(" ");
        if (commandMap.containsKey(updatedUC[0])) {
            commandMap.get(updatedUC[0]).execute(updatedUC);
            CommandReaderInterface.addToHistory(updatedUC[0]);
        } else {
            print("Данной команды не существует");
        }

        return false;
    }

}
