package task2;

import com.sun.scenario.effect.impl.sw.java.JSWColorAdjustPeer;

import java.io.*;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Calculator {
    public static void main(String[] args) {
        Writer w = new BufferedWriter(new OutputStreamWriter(System.out));
        CommandFactory commandFactory;
        Context context = new Context(w);
        Scanner scanner;

        if (args.length == 0) {
            scanner = readFormConsole();
        } else {
            scanner = readFormFile(args[0]);
        }
        try{

        } catch (Exception e) {
            e.printStackTrace();
        }
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
