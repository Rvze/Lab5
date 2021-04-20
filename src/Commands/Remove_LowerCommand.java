package Commands;
import Collections.CollectionManager;
import Collections.TicketCreaterInterface;

public class Remove_LowerCommand extends AbstractCommand {
    private final CollectionManager collectionManager;
    private final TicketCreaterInterface ticketCreater;
    public Remove_LowerCommand(CollectionManager collectionManager, TicketCreaterInterface ticketCreater){
        super("remove lower", " удалить из коллекции все элементы, меньшие, чем заданный");
        this.collectionManager = collectionManager;
        this.ticketCreater = ticketCreater;
    }
    @Override
    public void execute(String[] args) {
        collectionManager.removeLower(ticketCreater.askTicket());
    }
}
