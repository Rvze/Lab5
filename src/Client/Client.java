package Client;

import Collections.CollectionManager;
import Commands.*;
import Collections.TicketCreater;
import Collections.TicketCreaterInterface;


import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;

public class Client {
    private static boolean exit;
    private final CommandReaderInterface commandReader;
    private HashMap<String, Command> commandHashMap;

    public Client(CommandReaderInterface commandReader) {
        this.commandReader = commandReader;
        CollectionManager manager = commandReader.getManager();
        TicketCreaterInterface ticketCreater = new TicketCreater(new Scanner(new InputStreamReader(System.in)), manager, false);
        commandReader.addCommand("help", new HelpCommand(commandReader.getCommandMap()));
        commandReader.addCommand("info", new InfoCommand(manager));
        commandReader.addCommand("show", new ShowCommand(manager));
        commandReader.addCommand("add", new AddCommand(manager, ticketCreater));
        commandReader.addCommand("update_id", new UpdateIdCommand(manager, ticketCreater));
        commandReader.addCommand("remove_by_id", new RemoveByIdCommand(manager, ticketCreater));
        commandReader.addCommand("clear", new ClearCommand(manager, ticketCreater));
        commandReader.addCommand("save", new SaveCommand(manager));
        commandReader.addCommand("exit", new ExitCommand());
        commandReader.addCommand("add_if_max", new Add_If_MaxCommand(manager, ticketCreater));
        commandReader.addCommand("remove_lower", new Remove_LowerCommand(manager, ticketCreater));
        commandReader.addCommand("history", new HistoryCommand());
        commandReader.addCommand("count_less_than_type", new Count_Less_Than_TypeCommand(manager, ticketCreater));
        commandReader.addCommand("filter_greater_than_event", new Filter_Greater_Than_EventCommand(manager, ticketCreater));
        commandReader.addCommand("print_field_descending_price", new Print_Field_Descending_PriceCommand(manager));
        commandReader.addCommand("execute_script", new ExecuteScriptCommand(manager));

    }

    public final void interactiveMode() {
        commandReader.start();
        while (!exit)
            commandReader.readCommand();
        exit();

    }
    public static void exit(){
        exit = true;
    }
}
