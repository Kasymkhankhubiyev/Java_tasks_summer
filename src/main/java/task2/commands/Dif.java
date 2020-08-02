package task2.commands;

import task2.Command;
import task2.CommandException;
import task2.Context;

import java.util.List;

public class Dif implements Command {
    @Override
    public void execute(Context context, List<String> args) throws CommandException {
        try{
            final double check = 0.0000000001;
            String variableName1 = args.get(0);
            String variableName2 = args.get(1);

            double variable1 = context.getConstants().remove(variableName1);
            double variable2 = context.getConstants().remove(variableName2);

            double b = context.getStack().pop();//два самых верхних из стека
            double a = context.getStack().pop();

            if((Math.abs(a - variable1)<check)&(Math.abs(a - variable2)<check)&(Math.abs(b - variable1)<check)&(Math.abs(b - variable2)<check)){
                context.getConstants().put(variableName1,variable1-variable2);
                context.getStack().push(variable1-variable2);
            }else
                throw new CommandException("Variable must be the highest in the Stack");
        }catch(Exception e){
            throw new CommandException("Variables not found");
        }

    }
}
