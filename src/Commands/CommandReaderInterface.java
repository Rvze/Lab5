package Commands;

import java.util.HashMap;

public interface CommandReaderInterface {
    void start();
    void readCommand();
    void addCommand(String key, AbstractCommand command);
    CollectionManager getManager();
    HashMap<String, AbstractCommand> getCommandMap();
}
