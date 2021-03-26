package Commands;

public class Add_If_MaxCommand implements Command {
    private final CollectionManager collectionManager;
    public Add_If_MaxCommand(CollectionManager collectionManager){
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String[] args) {
        collectionManager.add_if_max();
    }
}
