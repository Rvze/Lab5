package Commands;

import MainCommand.Ticket;
import MainCommand.TicketCreater;
import java.util.Scanner;

import java.util.HashMap;

public class CommandReader {
    private HashMap<String, Command> commandHashMap;
    private CollectionManager collectionManager;
    private Scanner scanner;
    private static boolean isExit = false;
    public CommandReader(CollectionManager collectionManager){
        collectionManager = new CollectionManager();

        TicketCreater ticketCreater = new TicketCreater(collectionManager, scanner);
        this.collectionManager = new CollectionManager();
        commandHashMap = new HashMap<>();
        commandHashMap.put("help", new HelpCommand(collectionManager));
        commandHashMap.put("info", new InfoCommand(collectionManager));
        commandHashMap.put("show", new ShowCommand(collectionManager));
        commandHashMap.put("add", new AddCommand(collectionManager, ticketCreater));
        commandHashMap.put("update id", new UpdateIdCommand(collectionManager));
        commandHashMap.put("remove_by_id", new RemoveByIdCommand(collectionManager));
        commandHashMap.put("clear", new ClearCommand(collectionManager));
        commandHashMap.put("save", new SaveCommand(collectionManager));
        commandHashMap.put("execute_script", new ExecuteScriptCommand(collectionManager));
        commandHashMap.put("exit", new ExitCommand(collectionManager));
        commandHashMap.put("add_if_max", new Add_If_MaxCommand(collectionManager));
        commandHashMap.put("remove_lower", new Remove_LowerCommand(collectionManager));
        commandHashMap.put("history", new HistoryCommand(collectionManager));
        commandHashMap.put("count_less_than_type", new Count_Less_Than_TypeCommand(collectionManager));
        commandHashMap.put("print_field_descending", new Print_Field_Descending_PriceCommand(collectionManager));
    }
    public void interactiveMode(){
// scanner
// Читаешь ввод пользователя
// Кидаешь его в readCommand

    }
    public void readCommand(String str){
        String[] input = str.trim().toLowerCase().split(" ");
        if(commandHashMap.containsKey(input[0].trim())){
            commandHashMap.get(str).execute(input);
        }
    }

    /**
     * Метод, устонавливающий флаг выхода
     */
    public static void quit(){
        isExit = true;
    }
}
