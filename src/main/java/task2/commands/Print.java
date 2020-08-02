package task2.commands;

import task2.Command;
import task2.CommandException;
import task2.Context;

import java.util.List;

public class Print implements Command {
    @Override
    public void execute(Context context, List<String> args) throws CommandException {
        try {
            if(context.getStack().size()<1) throw new CommandException("No arguments in the Stack");
            context.getStack().peek();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
