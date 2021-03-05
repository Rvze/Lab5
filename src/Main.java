import Commands.CollectionManager;
import Commands.CommandReader;

public class Main {
    public static void main(String[] args) {
        CollectionManager collectionManager = new CollectionManager();
        CommandReader commandReader = new CommandReader(collectionManager);
// commandReader.interectiveMode();
        commandReader.readCommand("help");
    }
}