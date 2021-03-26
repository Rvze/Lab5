package Commands;

public class Print_Field_Descending_PriceCommand implements Command {
    private final CollectionManager collectionManager;

    public Print_Field_Descending_PriceCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String[] args) {
        collectionManager.print_field_descending_price();
    }
}
