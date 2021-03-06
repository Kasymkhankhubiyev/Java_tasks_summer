package task2.commands;

import task2.Command;
import task2.CommandException;
import task2.Context;

import java.util.List;

public class Dif implements Command {
    @Override
    public void execute(Context context, List<String> args) throws CommandException {
        if(context.getStack().size() < 2)
            throw new CommandException("There should be at least 2 values in the stack");

        double b = context.getStack().pop();//два самых верхних из стека
        double a = context.getStack().pop();
        context.getStack().push(a - b);
    }
}
