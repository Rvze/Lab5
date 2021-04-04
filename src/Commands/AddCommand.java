package Commands;
import MainCommand.TicketCreaterInterface;

public class AddCommand extends AbstractCommand {
    private final CollectionManager collectionManager;
    private final TicketCreaterInterface ticketCreater;

    public AddCommand(CollectionManager collectionManager, TicketCreaterInterface ticketCreater) {
        super("add", " {element} : добавить новый элемент в коллекцию");
        this.collectionManager = collectionManager;
        this.ticketCreater = ticketCreater;
    }

    @Override
    public void execute(String[] args) {
        collectionManager.add(ticketCreater);
    }

    @Override
    public void getHelp() {

    }
}
