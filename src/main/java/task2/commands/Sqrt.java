package task2.commands;

import task2.Command;
import task2.CommandException;
import task2.Context;

import java.util.List;

public class Sqrt implements Command {
    @Override
    public void execute(Context context, List<String> args) throws CommandException {
            if(context.getStack().size() < 1)
                throw new CommandException("There should be at least 1 value in the stack");

            double a = context.getStack().pop();// самый верхних из стека

            if(a > 0){
                context.getStack().push(Math.sqrt(a));
            }else
                throw new CommandException("Variable is negative, sqrt can't be done");
    }
}
