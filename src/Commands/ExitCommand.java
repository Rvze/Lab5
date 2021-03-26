package Commands;

public class ExitCommand extends AbstractCommand {

    public ExitCommand(CollectionManager collectionManager){
        super("exit", ": завершить программу (без сохранения в файл)");

        }
    @Override
    public void execute(String[] args) {
        CommandReader.quit();
    }
}
