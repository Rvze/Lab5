package Commands;

import Collections.CollectionManager;
import Collections.Event;
import Collections.TicketCreaterInterface;

public class Filter_Greater_Than_EventCommand extends AbstractCommand {
    private final CollectionManager collectionManager;
    private Event event;
    private final TicketCreaterInterface ticketCreater;
    public Filter_Greater_Than_EventCommand(CollectionManager collectionManager, TicketCreaterInterface ticketCreater){
        super("filter greater than event ", "вывести элементы, значение поля event которых больше заданного");
        this.collectionManager = collectionManager;
        this.ticketCreater = ticketCreater;
    }
    @Override
    public void execute(String[] args) {
        collectionManager.filterGreaterThanEvent(event);
    }
}
