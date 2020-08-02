package task2.commands;

import task2.Command;
import task2.CommandException;
import task2.Context;

import java.util.List;

public class Sqrt implements Command {
    @Override
    public void execute(Context context, List<String> args) throws CommandException {
        try{
            double a = context.getStack().pop();// самый верхних из стека

            if(context.getStack().size()<1)
                throw new CommandException("There should be at least 2 values in the stack");


            if(a>0){
                //context.getConstants().put("const", Math.sqrt(a));
                context.getStack().push(a);
            }else
                throw new CommandException("Variable is negative, sqrt can't be done");

        }catch (CommandException ce){
            throw ce;
        }catch(Exception e){
            throw new CommandException("Variables not found");
        }
    }
}
