package task2;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) throws IOException {
        Writer writer = new BufferedWriter(new OutputStreamWriter(System.out));
        CommandFactory commandFactory = new CommandFactory();
        Context context = new Context(writer);
        Scanner scanner;

        //try{//заполняем сканнер, если вдргу что случится - поймаем, например файл в аргументе не работает.
        if (args.length == 0) {
            scanner = readFormConsole();
        } else {
            scanner = readFormFile(args[0]);
        }

        new CommandExecutor(context, scanner, commandFactory, writer).run();

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
