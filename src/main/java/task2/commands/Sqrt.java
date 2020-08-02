package task2.commands;

import task2.Command;
import task2.CommandException;
import task2.Context;

import java.util.List;

public class Sqrt implements Command {
    @Override
    public void execute(Context context, List<String> args) throws CommandException {
        try{
            final double check = 0.0000000001;
            String variableName1 = args.get(0);

            double variable1 = context.getConstants().remove(variableName1);

            double a = context.getStack().pop();//два самых верхних из стека

            if((Math.abs(a - variable1)<check)){
                if(variable1>0){
                    context.getConstants().put(variableName1, Math.sqrt(variable1));
                    context.getStack().push(variable1);
                }else
                    throw new CommandException("Variable is negative, sqrt can't be done");
            }else
                throw new CommandException("Variable must be the highest in the Stack");
        }catch(Exception e){
            throw new CommandException("Variables not found");
        }
    }
}
