package Commands;

import Collections.CollectionManager;
import Collections.TicketCreaterInterface;

public class Filter_Greater_Than_EventCommand extends AbstractCommand {
    private final CollectionManager collectionManager;
    private final TicketCreaterInterface ticketCreater;

    public Filter_Greater_Than_EventCommand(CollectionManager collectionManager, TicketCreaterInterface ticketCreater) {
        super("filter greater than event ", "вывести элементы, значение поля event которых больше заданного");
        this.collectionManager = collectionManager;
        this.ticketCreater = ticketCreater;
    }

    @Override
    public void execute(String[] args) {
        ticketCreater.askEventId();
        collectionManager.filterGreaterThanEvent(ticketCreater.getTicket().getEvent());
    }
}
