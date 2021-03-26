package Commands;

public class Count_Less_Than_TypeCommand implements Command{
    private final CollectionManager collectionManager;
    public Count_Less_Than_TypeCommand(CollectionManager collectionManager){
        this.collectionManager = collectionManager;
    }
    @Override
    public void execute(String[] args) {
        collectionManager.count_less_than_type();
    }
}
