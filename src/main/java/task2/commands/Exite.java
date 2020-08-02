package task2.commands;

import task2.Command;
import task2.CommandException;
import task2.Context;

import java.util.List;

public class Exite implements Command {
    @Override
    public void execute(Context context, List<String> args) throws CommandException {
        try{
            context.setExite();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
