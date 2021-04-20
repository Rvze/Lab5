package Commands;

import Collections.CollectionManager;
import subsidiary.LimitedQueue;

import java.util.HashMap;

public interface CommandReaderInterface {
    LimitedQueue<String> history = new LimitedQueue<>(11);

    static LimitedQueue<String> getHistory(){
        return history;
    }

    static void addToHistory(String str){
        history.add(str);
    }

    void start();

    void readCommand();

    void addCommand(String key, AbstractCommand command);

    CollectionManager getManager();

    HashMap<String, AbstractCommand> getCommandMap();


}
