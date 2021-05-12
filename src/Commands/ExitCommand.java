package Commands;

import Client.Client;

public class ExitCommand extends AbstractCommand {
    private final Client client;
    public ExitCommand(Client client){
        super("exit", ": завершить программу (без сохранения в файл)");
        this.client = client;

        }
    @Override
    public void execute(String[] args) {
        Client.exit();

    }
}
