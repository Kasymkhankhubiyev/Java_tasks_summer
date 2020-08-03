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
            System.out.println(context.getStack().peek());
        }catch (CommandException ce){
            throw ce;
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
