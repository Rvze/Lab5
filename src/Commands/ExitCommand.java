package Commands;

import Client.Client;

public class ExitCommand extends AbstractCommand {

    public ExitCommand(){
        super("exit", ": завершить программу (без сохранения в файл)");

        }
    @Override
    public void execute(String[] args) {
        Client.exit();
        try {
            byte[] b = new byte[1024];
            for (int r; (r = System.in.read(b)) != -1;) {
                String buffer = new String(b, 0, r);
                System.out.println("read: " + buffer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
