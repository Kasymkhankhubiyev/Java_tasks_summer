package task2.commands;

import task2.Command;
import task2.CommandException;
import task2.Context;

import java.io.IOException;
import java.util.List;

public class Print implements Command {
    @Override
    public void execute(Context context, List<String> args) throws CommandException {
        if(context.getStack().size() < 1) throw new CommandException("No arguments in the Stack");
        try {
            context.getWriter().write(context.getStack().peek().toString() + "\n");
            context.getWriter().flush();
        } catch (IOException e) {
            throw new CommandException("Unable to write");
        }
    }
}
