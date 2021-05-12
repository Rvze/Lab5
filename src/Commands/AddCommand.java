package Commands;

import Client.Client;
import Collections.CollectionManager;
import Collections.TicketCreaterInterface;

import java.util.NoSuchElementException;

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
        try {
            collectionManager.addElement(ticketCreater.askTicket());
        }catch(NoSuchElementException e){
            println("^D is forbidden input");
            Client.exit();
        }
    }

}
