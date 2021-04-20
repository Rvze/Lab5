package Commands;


import subsidiary.LimitedQueue;

public class HistoryCommand extends AbstractCommand {

    public HistoryCommand(){
        super("history", " вывести последние 11 команд (без их аргументов)");
    }
    @Override
    public void execute(String[] args) {
        LimitedQueue<String> history = CommandReaderInterface.getHistory();
        println("The last 11 commands: ");
        for(Object h: history){
            println(((String)h).trim());
        }
    }
}
