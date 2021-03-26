package Commands;

public class SaveCommand implements Command {
    private final CollectionManager collectionManager;
    public SaveCommand(CollectionManager collectionManager){
        this.collectionManager = collectionManager;
    }
    @Override
    public void execute(String[] args) {
        collectionManager.save();
    }
}
