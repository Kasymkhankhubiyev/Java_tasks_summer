package task2.commands;

import task2.Command;
import task2.CommandException;
import task2.Context;

import java.util.List;

public class Divide implements Command {
    @Override
    public void execute(Context context, List<String> args) throws CommandException {
        double a =1;
        double b =0;

        if (b == 0) throw new CommandException("Division by zero");

        double c = 1 / b;
    }
}
