package Commands;

import Client.Client;
import Collections.CollectionManager;
import Exceptions.OutputManager;
import Exceptions.OutputManagerImpl;
import Files.CSVFileWorker;
import Files.FileWorker;

import java.util.NoSuchElementException;

public class SaveCommand extends AbstractCommand {
    private final CollectionManager collectionManager;
    private final FileWorker writer;
    private Client client;
    public SaveCommand(CollectionManager collectionManager){
        super("save", "сохранить коллекцию в файл");
        this.collectionManager = collectionManager;
        writer = new CSVFileWorker(collectionManager);
    }
    @Override
    public void execute(String[] args) {
        try {
            writer.write(writer.parseToString(collectionManager.getTicket()));
            println("The collection is saved successfully");
        }catch(NoSuchElementException | NullPointerException e){
            println("^D is forbidden input");
            Client.exit();
        }
    }
}
