package Commands;

import Collections.CollectionManager;
import Exceptions.InvalidFieldException;
import Collections.TicketCreaterInterface;
import Collections.TicketType;

public class Count_Less_Than_TypeCommand extends AbstractCommand {
    private final CollectionManager collectionManager;
    private final TicketCreaterInterface ticketCreater;

    public Count_Less_Than_TypeCommand(CollectionManager collectionManager, TicketCreaterInterface ticketCreater) {
        super("count less than type", " вывести количество элементов, значение поля type которых меньше заданного");
        this.collectionManager = collectionManager;
        this.ticketCreater = ticketCreater;
    }

    @Override
    public void execute(String[] args) {
        try {
            collectionManager.countLessThanType((TicketType) ticketCreater.checkTicketEnum(args[1].trim()));
        } catch (InvalidFieldException e) {
            println("There is no enum named " + args[1].trim());
        }
    }
}
