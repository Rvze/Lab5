package Commands;

public class ExecuteScriptCommand implements Command {
    private final CollectionManager collectionManager;
    public ExecuteScriptCommand(CollectionManager collectionManager){
        this.collectionManager = collectionManager;
    }
    @Override
    public void execute(String[] args) {
        collectionManager.execute_script();
    }
}
