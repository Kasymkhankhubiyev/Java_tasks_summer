package task2;

import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Context {
    Stack<Double> stack = new Stack<Double>();
    Map<String, Double> map = new HashMap<String, Double>();

    Context(Writer writer) {

    }

    Double getStack() { //дает самы верхний элемент и удаляется его из стека.
        return stack.pop(); //почему не подходит?
    }

    Map<String, Double> getConstants() {
        return null;
    }

    Writer getOutput() {
        return null;
    }
}