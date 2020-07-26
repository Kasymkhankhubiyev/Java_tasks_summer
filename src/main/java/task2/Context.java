package task2;

import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Context {
    private Stack<Double> stack = new Stack<Double>();
    private Map<String, Double> map = new HashMap<String, Double>();
    private Writer writer;

    Context(Writer writer) {
        this.writer = writer;
    }

    Stack<Double> getStack() {
        return stack;
    }

    Map<String, Double> getConstants() {
        return map;
    }

    Writer getOutput() {
        return writer;
    }
}