package Commands;

import MainCommand.Manager;

public class InfoCommand extends AbstractCommand{
    private final CollectionManager collectionManager;
    public InfoCommand(CollectionManager collectionManager) {
        super("info", " :вывести в стандартный поток вывода информацию о коллекции");
        this.collectionManager = collectionManager;
    }
    @Override
    public void execute(String[] args) {
        collectionManager.info();
    }
}
