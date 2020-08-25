package task2.commands;

import org.junit.jupiter.api.BeforeEach;
import task2.CommandExecutor;
import task2.CommandFactory;
import task2.Context;

import java.io.IOException;
import java.io.StringReader;
import java.io.Writer;
import java.util.*;

public class AbstractCalculatorTest {
    class RememberingWriter extends Writer{
        private String data = "";
        @Override
        public void write(char[] cbuf, int off, int len) throws IOException {
            data = data + new String(Arrays.copyOfRange(cbuf, off, off + len));
        }

        @Override
        public void flush() throws IOException { }

        @Override
        public void close() throws IOException { }

        public List<String> getDataList() {
            return new ArrayList<>(Arrays.asList(data.split("\n")));
        }

    }

    protected StringBuilder inputCommands;
    protected RememberingWriter writer;
    protected CommandFactory commandFactory = new CommandFactory();
    protected Context context;
    protected List<String> output;

    @BeforeEach
    public void init(){
        inputCommands = new StringBuilder();
        writer = new RememberingWriter();
        context = new Context(writer);
        output = new ArrayList<>();
    }

    protected void runCalculator(){
        Scanner scanner = new Scanner(new StringReader(inputCommands.toString()));
        try {
            new CommandExecutor(context, scanner, commandFactory, writer).run();
        } catch (IOException e) {
            throw new RuntimeException("Internal test error");
        }
        output.addAll(writer.getDataList());
    }

    public Stack<Double> getStack() {
        return context.getStack();
    }

    public Map<String, Double> getConstants() {
        return context.getConstants();
    }

    public void addCommand(String s){
        inputCommands.append(s + "\n");
    }
}
