package task2;

import com.sun.scenario.effect.impl.sw.java.JSWColorAdjustPeer;

import java.io.*;
import java.util.*;

public class Calculator {
    public static void main(String[] args) {
        Writer w = new BufferedWriter(new OutputStreamWriter(System.out));
        CommandFactory commandFactory = new CommandFactory();
        Context context = new Context(w);
        Scanner scanner;
        final String delimeter = " "; //удалил лишние переменные

        try{//заполняем сканнер, если вдргу что случится - поймаем, например файл в аргументе не работает.
            if (args.length == 0) {
                scanner = readFormConsole();
            } else {
                scanner = readFormFile(args[0]);
            }

            while (scanner.hasNextLine()&& !context.getExite()){ //получаем строки
                String line = scanner.nextLine();
                String[] substring = line.split(delimeter); //здесь у нас список из имени комманды и аргументов
                List<String> lineWords = new ArrayList<>(Arrays.asList(substring)); // превращаем массив в ArrayList так как с ним удобнее работать
                lineWords.removeIf(s -> s.isEmpty()); // удаляем все пустые строки, они могли появиться если мы напишем 2 пробелла подряд например
                if (lineWords.size() > 0) {  // дальше делаем что-то только если пользователь не ввел пустую строку
                    String commandName = lineWords.remove(0);  // получаем имя команды заодно удалив его из списка
                    commandFactory.createCommand(commandName).execute(context, lineWords);
                }
            }
            scanner.close();
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
