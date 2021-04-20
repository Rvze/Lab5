import Client.Client;
import Collections.CollectionManager;
import Commands.CommandReader;
import Commands.CommandReaderInterface;
import Files.CSVFileWorker;

public class Main {
    public static void main(String[] args) {
        CollectionManager collectionManager = new CollectionManager();
        CSVFileWorker fileWorkerInterface = new CSVFileWorker(collectionManager);
        CommandReaderInterface commandReader = new CommandReader(collectionManager, fileWorkerInterface);
        Client client = new Client(commandReader);
        client.interactiveMode();
    }
}