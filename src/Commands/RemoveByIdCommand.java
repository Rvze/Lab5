package Commands;

import Collections.CollectionManager;
import Collections.TicketCreaterInterface;
import subsidiary.InputChecker;

public class RemoveByIdCommand extends AbstractCommand{
    private final CollectionManager collectionManager;
    private final TicketCreaterInterface ticketCreater;
    public RemoveByIdCommand(CollectionManager collectionManager, TicketCreaterInterface ticketCreater){
        super("remove by id", " удалить элемент коллекции по его id");
        this.collectionManager = collectionManager;
        this.ticketCreater = ticketCreater;
    }
    @Override
    public void execute(String[] args) {
        Long id;
        if(args.length > 1 && args[1].length() > 0 && InputChecker.checkLong(args[1].trim())){
            id = Long.parseLong(args[1].trim());
        }else{
            id = ticketCreater.askTicketId();
        }
        if (id!=null && collectionManager.checkId(id)){
            collectionManager.removeById(id);
        }else{
            println("This id not found");
        }
    }
}
