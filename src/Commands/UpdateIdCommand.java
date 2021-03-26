package Commands;

public class UpdateIdCommand implements Command {
    private final CollectionManager collectionManager;

    public UpdateIdCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String[] args) {
        collectionManager.updateId();
    }
}
