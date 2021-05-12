package Commands;

import Client.Client;
import Collections.CollectionManager;
import Collections.Ticket;
import Collections.TicketCreaterInterface;

import java.util.NoSuchElementException;

public class Remove_LowerCommand extends AbstractCommand {
    private final CollectionManager collectionManager;
    private final TicketCreaterInterface ticketCreater;

    public Remove_LowerCommand(CollectionManager collectionManager, TicketCreaterInterface ticketCreater) {
        super("remove lower", " удалить из коллекции все элементы, меньшие, чем заданный");
        this.collectionManager = collectionManager;
        this.ticketCreater = ticketCreater;
    }

    @Override
    public void execute(String[] args) {
        try{
            collectionManager.removeLower(ticketCreater.askTicket());
        }catch(NoSuchElementException e){
            println("^D is forbidden input");
            Client.exit();
        }
    }
}

