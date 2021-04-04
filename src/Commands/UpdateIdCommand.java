package Commands;

import MainCommand.Ticket;
import MainCommand.TicketCreater;
import MainCommand.TicketCreaterInterface;
import subsidiary.InputChecker;

public class UpdateIdCommand extends AbstractCommand {
    private final CollectionManager collectionManager;
    private final TicketCreaterInterface ticketCreater;

    public UpdateIdCommand(CollectionManager collectionManager, TicketCreaterInterface ticketCreater) {
        super("update", " id {element}: обновить значение элемента коллекции, id которого равен заданному");
        this.collectionManager = collectionManager;
        this.ticketCreater = ticketCreater;
    }

    @Override
    public void execute(String[] args) {
        Long id;
        if(args.length > 1 && args[1].length() > 0 && InputChecker.checkLong(args[1].trim()){
            id = Long.parseLong(args[1].trim());
        }else{
            id = TicketCreater.
        }
    }
}
