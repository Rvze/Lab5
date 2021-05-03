package Commands;

import Collections.CollectionManager;
import Collections.Ticket;
import Collections.TicketCreater;
import Collections.TicketCreaterInterface;

public class Print_Field_Descending_PriceCommand extends AbstractCommand {
    private final CollectionManager collectionManager;


    public Print_Field_Descending_PriceCommand(CollectionManager collectionManager) {
        super("Print filed descending price", " :вывести значение поля price всех элементов в порядке убывания");
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String[] args) {
        collectionManager.printFieldDescendingPrice();
    }
}

