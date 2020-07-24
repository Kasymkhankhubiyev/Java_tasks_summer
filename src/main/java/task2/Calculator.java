package task2;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Map;
import java.util.Stack;
import java.io.File;

public class Calculator {
    public static void main(String[] args) {
        CommandFactory commandFactory;
        Context context;
        InputStreamReader reader;

        File myfile = new File("resources"); //Нужно нормальный путь к файлу записать.
        if(myfile.exists()) {
            System.out.println("File is found\n");
            if(myfile.canRead()){

            }
        }
        else {
            System.out.println("File does not exist..." + '\n' + "input your commands using console\n");
            //пишем для консольного ввода
        }
    }

    private InputStreamReader readFormConsole(){
        return null;
    }

    private InputStreamReader readFormFile(String fileName){
        //new InputStreamReader(new FileInputStream(fileName));
        return null;
    }
}
