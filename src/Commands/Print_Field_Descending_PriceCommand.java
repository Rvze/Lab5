package Commands;

import Collections.CollectionManager;
import Collections.Ticket;

public class Print_Field_Descending_PriceCommand extends AbstractCommand {
    private final CollectionManager collectionManager;
    private Ticket price;


    public Print_Field_Descending_PriceCommand(CollectionManager collectionManager) {
        super("Print filed descending price", " :вывести значение поля price всех элементов в порядке убывания");
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String[] args) {
        collectionManager.printFieldDescendingPrice(price);

    }
}

