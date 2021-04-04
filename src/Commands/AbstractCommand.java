package Commands;

import java.util.Objects;

public class AbstractCommand implements Command {
    private final String name;
    private final String description;

    public AbstractCommand(String name, String description){
        this.name = name;
        this.description = description;
    }

    /**
     * Имя команды
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Описание команды
     * @return
     */
    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractCommand that = (AbstractCommand) o;
        return name.equals(that.name) && description.equals(that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description);
    }

    @Override
    public void execute(String[] args) {

    }

    /**
     * Выводит в поток вывода справку о команде
     */
    public void getHelp(){

    }
    public void println(String s){
        System.out.println(s);
    }
}
