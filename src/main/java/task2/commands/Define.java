package task2.commands;

import task2.Command;
import task2.CommandException;
import task2.Context;

import java.util.List;
import java.io.Reader;

public class Define implements Command {
    @Override
    public void execute(Context context, List<String> args) throws CommandException {
        try {
            String variableName = args.get(0);
            Double variableValue = Double.valueOf(args.get(1));
            context.getConstants().put(variableName, variableValue);
        } catch (Exception e) {
            throw new CommandException("Wrong arguments: first should be a variable name, second - value");
        }
    }
}
