package Commands;

import Collections.CollectionManager;
import Collections.TicketCreaterInterface;

public class ClearCommand extends AbstractCommand{
    private final CollectionManager collectionManager;
    private final TicketCreaterInterface ticketCreater;
    public ClearCommand (CollectionManager collectionManager, TicketCreaterInterface ticketCreater){
        super("clear", " очистить колелкцию");
        this.collectionManager = collectionManager;
        this.ticketCreater = ticketCreater;
    }
    @Override
    public void execute(String[] args) {
        collectionManager.clear();
    }
}
