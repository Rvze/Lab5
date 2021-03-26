package Commands;

public class RemoveByIdCommand implements Command{
    private final CollectionManager collectionManager;
    public RemoveByIdCommand(CollectionManager collectionManager){
        this.collectionManager = collectionManager;
    }
    @Override
    public void execute(String[] args) {
        collectionManager.removeById();
    }
}
