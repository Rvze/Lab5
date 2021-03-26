package Commands;

import MainCommand.Ticket;
import Commands.CollectionManager;
import MainCommand.TicketCreater;

public class AddCommand extends AbstractCommand {
    private final CollectionManager collectionManager;
    private final TicketCreater ticketCreater;

    public AddCommand(CollectionManager collectionManager, TicketCreater ticketCreater) {
        super("add", " {element} : добавить новый элемент в коллекцию");
        this.collectionManager = collectionManager;
        this.ticketCreater = ticketCreater;
    }

    @Override
    public void execute(String[] args) {
        collectionManager.add(ticketCreater);
    }
}
