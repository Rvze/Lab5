package Commands;
import MainCommand.Manager;

public class HelpCommand implements Command {
    private final CollectionManager collectionManager;
    public HelpCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }


    @Override
    public void execute(String[] args) {
        collectionManager.help();
    }
}
