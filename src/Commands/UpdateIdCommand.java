package Commands;


import Client.Client;
import Collections.CollectionManager;
import Collections.TicketCreaterInterface;
import subsidiary.InputChecker;

import java.util.NoSuchElementException;

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
        try {
            Long id;
            if (args.length > 1 && args[1].length() > 0 && InputChecker.checkLong(args[1].trim())) {
                id = Long.parseLong(args[1].trim());
            } else {
                id = ticketCreater.askTicketId();
            }
            if (id != null && collectionManager.checkId(id)) {
                collectionManager.update(id, ticketCreater.askTicket());
            } else {
                println("This id not found");

            }
        }catch(NoSuchElementException e){
            println("^D is forbidden input");
            Client.exit();
        }
    }

}
