package Commands;

import Collections.CollectionManager;
import Files.CSVFileWorker;
import Files.FileWorker;

public class SaveCommand extends AbstractCommand {
    private final CollectionManager collectionManager;
    private final FileWorker writer;
    public SaveCommand(CollectionManager collectionManager){
        super("save", "сохранить коллекцию в файл");
        this.collectionManager = collectionManager;
        writer = new CSVFileWorker(collectionManager);
    }
    @Override
    public void execute(String[] args) {
        writer.write(writer.parseToString(collectionManager.getTicket()));
        println("The collection is saved successfully");
    }
}
