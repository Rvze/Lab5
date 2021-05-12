package Commands;

import Client.Client;
import Collections.CollectionManager;
import Collections.Ticket;
import Collections.TicketCreater;
import Collections.TicketCreaterInterface;

import java.util.NoSuchElementException;

public class Add_If_MaxCommand extends AbstractCommand {
    private final CollectionManager collectionManager;
    private final TicketCreaterInterface ticketCreater;
    private Client client;

    public Add_If_MaxCommand(CollectionManager collectionManager, TicketCreaterInterface ticketCreater) {
        super("add if max ", "добавить новый элемент в коллекцию, если его значение превышает значение наибольшего элемента этой коллекции");
        this.collectionManager = collectionManager;
        this.ticketCreater = ticketCreater;

    }

    @Override
    public void execute(String[] args) {
        try {
            ticketCreater.askTicketId();

            Ticket ticket = ticketCreater.askTicket();
            if (ticket.compareByTicket(collectionManager.getTicketStream().max(Ticket.getTicketComparator()).get()) > 0) {
                collectionManager.addElement(ticket);
            }
        }catch(NoSuchElementException e){
            println("^D is forbidden input");
            Client.exit();
        }
    }
}
