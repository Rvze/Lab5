package Commands;

import Collections.CollectionManager;
import Files.FileWorker;

import java.util.NoSuchElementException;
import java.util.Scanner;

import java.util.HashMap;

public class CommandReader implements CommandReaderInterface {
    private HashMap<String, AbstractCommand> commandHashMap;
    private CollectionManager manager;
    private Scanner scanner;
    private final boolean isRunning = true;

    private final FileWorker csvFileWorkerInterface;

    public CommandReader(CollectionManager collectionManager, FileWorker fileWorker) {
        manager = collectionManager;
        csvFileWorkerInterface = fileWorker;
        commandHashMap = new HashMap<>();
    }


// scanner
// Читаешь ввод пользователя
// Кидаешь его в readCommand


    public final void println(String s) {
        System.out.println(s);
    }

    @Override
    /**
     * Метод, обеспечивающий чтение команд в строковом формате
     */
    public void readCommand() {
        Scanner commandReader = new Scanner(System.in);
        String userCommand = "";
        try {
            userCommand = commandReader.nextLine();
        } catch (NoSuchElementException e) {
            println("You can't input this\nThe work of App will be stopped");
        }

        String[] input = userCommand.trim().split(" ", 2);
        if (commandHashMap.containsKey(input[0])) {
            commandHashMap.get(input[0]).execute(input);
            CommandReaderInterface.addToHistory(input[0]);
        } else if (!input[0].equals("")) {
            println("Данной команды не существует, наберите 'help' для справки");
        }
    }


    @Override
    public void start() {
        try {
            Scanner fileInput = new Scanner(System.in);
            println("Do you wanna start app work with csv file input?\n|yes/no|");

            String input = fileInput.nextLine();
            while (!input.equals("yes") && !input.equals("no")) {
                println("yes/no");
                input = fileInput.nextLine().trim();
            }
            if (input.matches("yes")) {
                csvFileWorkerInterface.loadInput(manager.getTicket());
            }
            println("The app is ready to work");
        } catch (NoSuchElementException e) {
            println("^D is forbidden input");
        }
    }

    @Override
    public void addCommand(String key, AbstractCommand command) {
        commandHashMap.put(key, command);
    }


    /**
     * Получить Collection Manager
     *
     * @return
     */
    @Override
    public CollectionManager getManager() {
        return manager;
    }

    @Override
    public HashMap<String, AbstractCommand> getCommandMap() {
        return commandHashMap;
    }
}
