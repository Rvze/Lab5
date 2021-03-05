package Commands;

import Commands.CollectionManager;
import Commands.Command;
import Commands.HelpCommand;

import java.util.HashMap;

public class CommandReader {
    private HashMap<String, Command> commandHashMap;
    private CollectionManager collectionManager;
    public CommandReader(CollectionManager collectionManager){
        this.collectionManager = new CollectionManager();
        commandHashMap = new HashMap<>();
        commandHashMap.put("help", new HelpCommand(collectionManager));
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
}
