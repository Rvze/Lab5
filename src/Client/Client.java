package Client;

import Commands.*;
import MainCommand.TicketCreater;
import MainCommand.TicketCreaterInterface;


import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;

public class Client {
    private final boolean isRunning = true;
    private final CommandReaderInterface commandReader;
    private HashMap<String, Command> commandHashMap;

    public Client(CommandReaderInterface commandReader) {
        this.commandReader = commandReader;
        CollectionManager manager = commandReader.getManager();
        TicketCreaterInterface ticketCreater = new TicketCreater(new Scanner(new InputStreamReader(System.in)), manager);
        commandReader.addCommand("help", new HelpCommand(commandReader.getCommandMap()));
        commandReader.addCommand("info", new InfoCommand(manager));
        commandReader.addCommand("show", new ShowCommand(manager));
        commandReader.addCommand("add",new AddCommand(manager, ticketCreater));
        commandReader.addCommand("update id", new UpdateIdCommand());

    }
}
