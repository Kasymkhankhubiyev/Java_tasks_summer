package task2;

import java.util.HashMap;
import java.util.Map;

public class CommandFactory {
    private Map<String, Command> commandMap = new HashMap<>();

    private void init(){
        getClass().getResourceAsStream("commands.txt");

        //fill coommandMap with actual data
    };

    public Command createCommand(String commandName) throws DecodeException{
        return  null;
    }
}
