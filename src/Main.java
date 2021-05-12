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
        try {
            byte[] b = new byte[1024];
            for (int r; (r = System.in.read(b)) != -1; ) {
                String buffer = new String(b, 0, r);
                System.out.println("read: " + buffer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}