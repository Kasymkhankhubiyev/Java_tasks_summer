package task2;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;


public class CommandFactory {
    private Map<String, Command> commandMap = new HashMap<>();
    String terminator = " "; //это верно?

    private void init(){
        getClass().getResourceAsStream("commands.txt");
        try{
            File file = new File("commands.txt");
            FileInputStream filestream = null;
            filestream = new FileInputStream("commands.txt");
            Scanner reader = null;
            reader = new Scanner(filestream);
            if(reader!=null){
                while(reader.hasNext()){
                    String string = reader.nextLine();
                    String[] substring;
                    substring = string.split(terminator,2);// я теперь должен вытаскивать значения? зачем вообще double в мапке?
                    commandMap.put(substring[0],substring[1]);
                }
            } else throw new IOException();
            //Properties prop = new Properties(); // создаю контейнер и откгружаю все сюда.
            //prop.load(filestream);

        }catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }

        //fill coommandMap with actual data
    };

    public Command createCommand(String commandName) throws DecodeException {
        Command command = commandMap.get(commandName);
        if (command == null) {
            throw new DecodeException("Command not found");
        } else return command;
    }
}
