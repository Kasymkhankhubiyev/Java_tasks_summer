package task2;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CommandExecutor {
    final String delimeter = " ";

    private final Context context;
    private final Scanner scanner;
    private final CommandFactory commandFactory;
    private final Writer writer;

    public CommandExecutor(Context context, Scanner scanner, CommandFactory commandFactory, Writer writer) {
        this.context = context;
        this.scanner = scanner;
        this.commandFactory = commandFactory;
        this.writer = writer;
    }

    public void run() throws IOException {
        while (!context.getExit() && scanner.hasNextLine()){ //получаем строки
            String line = scanner.nextLine();
            String[] substring = line.split(delimeter); //здесь у нас список из имени комманды и аргументов
            if(!line.startsWith("#")) {
                List<String> lineWords = new ArrayList<>(Arrays.asList(substring)); // превращаем массив в ArrayList так как с ним удобнее работать
                lineWords.removeIf(s -> s.isEmpty()); // удаляем все пустые строки, они могли появиться если мы напишем 2 пробелла подряд например
                if (lineWords.size() > 0) {  // дальше делаем что-то только если пользователь не ввел пустую строку
                    String commandName = lineWords.remove(0);  // получаем имя команды заодно удалив его из списка
                    try {
                        commandFactory.createCommand(commandName).execute(context, lineWords);
                    } catch (CommandException e) {
                        writer.write(commandName + ":" + e.getMessage() +"\n");
                        writer.flush();
                    } catch (DecodeException e) {
                        writer.write("Unknown command: " + commandName + "\n");
                        writer.flush();
                    }
                }
            }
        }
        writer.close();
        scanner.close();
    }
}
