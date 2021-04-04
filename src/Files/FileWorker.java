package Files;

import MainCommand.Ticket;

import java.util.HashSet;

public interface FileWorker {
    String getFilePath();

    void inputFilePath();

    void write(String[] str);

    Ticket read(String[] values);

    void loadInput(HashSet<Ticket> hashSet);

    String[] parseToString(HashSet<Ticket> hashSet);
}
