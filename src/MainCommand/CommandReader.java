package MainCommand;

import Commands.Command;
import Commands.HelpCommand;

import java.util.Scanner;


public class CommandReader {
    private Scanner commandIn;
    private Manager manager;

    public CommandReader(Scanner commandIn) {
        this.commandIn = commandIn;
    }

    public void readCommand() {
        String commandName = commandIn.next();
        Command command = parseCommand(commandName);
        command.execute();

    }

    private Command parseCommand(String str) {
        switch (str) {
            case "help":

        }
    }
}


