package task2;

import java.util.List;
import java.io.Reader;

public class Define implements Command {

    @Override
    //public void execute(Context context, List<String> args) throws CommandException {
    public void execute(Context context, int i){
        Reader reader = null;
        String com = context.getArray(i);
        String arg = context.getConstants(com);
        String[] numbers = arg.split(" ");
        double k = (double) numbers[0];//reader.read(numbers[0]);
    }
}
