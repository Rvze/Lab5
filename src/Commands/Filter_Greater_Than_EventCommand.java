package Commands;

public class Filter_Greater_Than_EventCommand implements Command {
    private final CollectionManager collectionManager;
    public Filter_Greater_Than_EventCommand(CollectionManager collectionManager){
        this.collectionManager = collectionManager;
    }
    @Override
    public void execute(String[] args) {
        collectionManager.filter_greater_than_event();
    }
}
