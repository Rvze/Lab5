package Commands;

public class ShowCommand extends AbstractCommand {
    private final CollectionManager collectionManager;

    public ShowCommand(CollectionManager collectionManager) {
        super("show", " :вывести в стандартный поток вывода все элементы коллекции в строковом представлении");
        this.collectionManager= collectionManager;
    }

    @Override
    public void execute(String[] args) {
        collectionManager.show();
    }
}
