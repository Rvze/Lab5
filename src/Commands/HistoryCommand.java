package Commands;

public class HistoryCommand implements Command {
    private final CollectionManager collectionManager;
    public HistoryCommand(CollectionManager collectionManager){
        this.collectionManager = collectionManager;
    }
    @Override
    public void execute(String[] args) {
        collectionManager.history();
    }
}
