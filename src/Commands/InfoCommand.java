package Commands;

import MainCommand.Manager;

public class InfoCommand implements Command{
    private final CollectionManager collectionManager;
    public InfoCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }
    @Override
    public void execute(String[] args) {
        collectionManager.info();
    }
}
