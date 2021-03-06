package Commands;

import Collections.CollectionManager;
import Collections.TStringShower;
import Collections.Ticket;

public class ShowCommand extends AbstractCommand {
    private final CollectionManager collectionManager;

    public ShowCommand(CollectionManager collectionManager) {
        super("show", " :вывести в стандартный поток вывода все элементы коллекции в строковом представлении");
        this.collectionManager= collectionManager;
    }

    @Override
    public void execute(String[] args) {
        StringBuilder sb = new StringBuilder("Элементов в коллекции: " + collectionManager.getTicket().size());
        sb.append("\n");
        for(Ticket ticket : collectionManager.getTicket()){
            sb.append(TStringShower.toStrView(ticket)+"\n");
        }
        System.out.println(sb.toString());
    }
}