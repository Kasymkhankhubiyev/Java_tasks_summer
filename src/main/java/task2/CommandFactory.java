package task2;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;


public class CommandFactory {
    private Map<String, Command> commandMap = new HashMap<>();
    static char terminator = ' '; //это верно?


    private void init(){
        getClass().getResourceAsStream("commands.txt");
        try{
            File file = new File("commands.txt");
            FileInputStream filestream = null;
            filestream = new FileInputStream("commands.txt");
            Properties prop = new Properties();
            prop.load(filestream);


        }catch (Exception e){}

        //fill coommandMap with actual data
    };

    public Command createCommand(String commandName) throws DecodeException{
        return  null;
    }
}
