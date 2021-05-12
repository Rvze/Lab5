package Commands;


import Exceptions.OutputManager;

import java.util.HashMap;
import java.util.NoSuchElementException;

public class HelpCommand extends AbstractCommand {
    private final HashMap<String, AbstractCommand> commandMap;
    private OutputManager outputManager;

    public HelpCommand(HashMap<String, AbstractCommand> commandMap) {
        super("help", " : вывести справку по доступным командам");
        this.commandMap = commandMap;
    }


    @Override
    public void execute(String[] args) {
        try {
            for (String x : commandMap.keySet()) {
                println(commandMap.get(x).getName() + commandMap.get(x).getDescription());
            }
        } catch (NoSuchElementException e) {
            println("");
        }
    }

    @Override
    public void println(String s) {
        super.println(s);
    }
}
