package task2;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;


public class CommandFactory {
    private Map<String, Command> commandMap = new HashMap<>();
    private final String terminator = " ";

    private void init(){
        try{
            FileInputStream fileStream = new FileInputStream("commands.txt");
            Scanner reader = new Scanner(fileStream);
            while(reader.hasNext()){
                String string = reader.nextLine();
                String[] substring;
                substring = string.split(terminator,2);
                Command command = (Command) Class.forName(substring[1]).newInstance();
                commandMap.put(substring[0], command);
            }
            //Properties prop = new Properties(); // создаю контейнер и откгружаю все сюда.
            //prop.load(fileStream);
        }catch (FileNotFoundException e){
            //throw new DecodeException("Failed io initialize CommandFactory");
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
    };

    public Command createCommand(String commandName) throws DecodeException {
        Command command = commandMap.get(commandName);
        if (command == null) {
            throw new DecodeException("Command not found");
        } else return command;
    }

    public void factoryWorkFlow(String commandName,Context context,String[] arguments) {
        try {
            commandMap.get(commandName).execute(context, arguments);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
