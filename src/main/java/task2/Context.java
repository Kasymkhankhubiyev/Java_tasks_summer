package task2;

import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Context {
    private Stack<Double> stack = new Stack<>(); //здесь дабл так как в стэке у нас только числа могут быть
    private Map<String, Double> constants = new HashMap<>(); // здесь мы храним наши константы, работать с ними будем через getConstants().push() и getConstants().get()
    private Writer writer;
    private Boolean exitCondition;

    public Context(Writer writer) {
        this.writer = writer;
        exitCondition = false;
    }

    public Boolean getExit(){
        return exitCondition;
    }

    public void setExit(){
        exitCondition=true;
    }

    public Stack<Double> getStack() {
        return stack;
    }

    public Map<String, Double> getConstants() {
        return constants;
    }

    public Writer getWriter() {
        return writer;
    }
}