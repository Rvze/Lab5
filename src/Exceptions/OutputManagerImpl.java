package Exceptions;

public class OutputManagerImpl implements OutputManager{
    @Override
    public void printErrMsg(String msg) {
        System.err.println(msg);
    }
}
