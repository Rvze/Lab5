package Commands;

public class Remove_LowerCommand implements Command {
    private final CollectionManager collectionManager;
    public Remove_LowerCommand(CollectionManager collectionManager){
        this.collectionManager = collectionManager;
    }
    @Override
    public void execute(String[] args) {
        collectionManager.remove_lower();
    }
}
