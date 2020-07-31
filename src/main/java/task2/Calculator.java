package task2;

import com.sun.scenario.effect.impl.sw.java.JSWColorAdjustPeer;

import java.io.*;
import java.util.*;

public class Calculator {
    public static void main(String[] args) {
        Writer w = new BufferedWriter(new OutputStreamWriter(System.out));
        CommandFactory commandFactory = null;
        Context context = new Context(w);
        Scanner scanner;
        Command command;
        ArrayList<String> arguments = null;
        Map<String,String> argMap = new HashMap<>();
        final String delimeter = " ";
        int i =0;

        try{//заполняем сканнер, если вдргу что случится - поймаем, например файл в аргументе не работает.
            if (args.length == 0) {
                scanner = readFormConsole();
            } else {
                scanner = readFormFile(args[0]);
            }
            while (scanner.hasNextLine()){ //получаем строки
                String line = scanner.nextLine();//in which cases can we use scan.useDelimeter()?
                String[] substring;
                substring = line.split(delimeter,2); //how do we use READ with Scanner?
                arguments.add(substring[1]);
                commandFactory.createCommand(substring[0]);
                //argMap.put(substring[0],substring[1]);
                i++;
            }
            scanner.close();
            //command.execute(context,arguments);
            //int j=0;
            //while (j<i){
            //}
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Scanner readFormConsole(){
        return new Scanner(System.in);
    }

    private static Scanner readFormFile(String fileName){
        File file = new File(fileName);
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return scanner;
    }
}
