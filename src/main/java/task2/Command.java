package task2;

import java.util.List;

public interface Command {
    //void execute(Context context, List<String> args) throws CommandException;
    void execute(Context context, String[] args) throws CommandException;
}
