package Commands;

public class ShowCommand implements Command {
    private final CollectionManager collectionManager;

    public ShowCommand(CollectionManager collectionManager) {
        this.collectionManager= collectionManager;
    }

    @Override
    public void execute(String[] args) {
        collectionManager.show();
    }
}
