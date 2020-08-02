package task2.commands;

import task2.Command;
import task2.CommandException;
import task2.Context;

import java.util.List;

public class Pop implements Command {
    @Override
    public void execute(Context context, List<String> args) throws CommandException {
        try {
            Double value = Double.valueOf(args.get(0));
            context.getStack().pop();
        }catch(Exception e){
            throw new CommandException("First argument should be a number");
        }
    }
}
