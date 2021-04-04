import Commands.CollectionManager;
import Commands.CommandReader;
import Commands.CommandReaderInterface;
import Files.CSVFileWorker;
import Files.CSVFileWorkerInterface;
import Files.FileWorker;

public class Main {
    public static void main(String[] args) {
        CollectionManager collectionManager = new CollectionManager();
        CSVFileWorker fileWorkerInterface = new CSVFileWorker(collectionManager);

    }
}