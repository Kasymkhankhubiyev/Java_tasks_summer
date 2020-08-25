package task2.commands;

import task2.Command;
import task2.CommandException;
import task2.Context;

import java.util.List;

public class Push implements Command {
    @Override
    public void execute(Context context, List<String> args) throws CommandException {
        if (args.isEmpty()) throw new CommandException("No arguments");
        Double number = null;

        try {
            number = Double.valueOf(args.get(0));
        } catch (Exception ignored){}

        if (number == null)
            number = context.getConstants().get(args.get(0));

        if (number != null)
            context.getStack().push(number);
        else
            throw new CommandException("First argument should be a number or a known constant");
    }
}
