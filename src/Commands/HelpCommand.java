package Commands;


import java.util.HashMap;

public class HelpCommand extends AbstractCommand {
    private final HashMap<String, AbstractCommand> commandMap;

    public HelpCommand(HashMap<String, AbstractCommand> commandMap) {
        super("help", " : вывести справку по доступным командам");
        this.commandMap = commandMap;
    }


    @Override
    public void execute(String[] args) {
        for (String x : commandMap.keySet()) {
            println(commandMap.get(x).getName() + commandMap.get(x).getDescription());
        }
    }

    @Override
    public void println(String s) {
        super.println(s);
    }
}
