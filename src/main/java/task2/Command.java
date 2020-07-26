package task2;

import java.util.List;

public interface Command {
    void execute(Context context, List<String> args) throws CommandException;
}

abstract class DEFINE implements Command{
    @Override
    public void execute (Context context, List<String> args){

    }
}

abstract class POP implements Command{
    @Override
    public void execute(Context context, List<String> args){

    }
}

abstract class PUSH implements Command{
    @Override
    public void execute(Context context, List<String> args){

    }
}

abstract class SUM implements Command{
    @Override
    public void execute(Context context, List<String> args){

    }
}

abstract class DIF implements Command{
    @Override
    public void execute(Context context, List<String> args){

    }
}

abstract class MULTI implements Command{
    @Override
    public void execute(Context context, List<String> args){

    }
}

abstract class DIV implements Command{
    @Override
    public void execute(Context context, List<String> args){

    }
}