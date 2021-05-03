package Commands;

import Collections.CollectionManager;
import Collections.Ticket;
import Collections.TicketCreater;
import Collections.TicketCreaterInterface;

public class Add_If_MaxCommand extends AbstractCommand {
    private final CollectionManager collectionManager;
    private final TicketCreaterInterface ticketCreater;

    public Add_If_MaxCommand(CollectionManager collectionManager, TicketCreaterInterface ticketCreater) {
        super("add if max ", "добавить новый элемент в коллекцию, если его значение превышает значение наибольшего элемента этой коллекции");
        this.collectionManager = collectionManager;
        this.ticketCreater = ticketCreater;

    }

    @Override
    public void execute(String[] args) {
        ticketCreater.askTicketId();
        Ticket ticket = ticketCreater.askTicket();
        if (ticket.compareByTicket(collectionManager.getTicketStream().max(Ticket::compareByTicket).get()) >= 0) {
            println("Element is successfully added");
            collectionManager.addElement(ticket);
        }
    }
}
