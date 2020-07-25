package task2;

import java.io.Writer;
import java.util.Map;
import java.util.Stack;

public interface Context {
    Stack<Double> getStack();
    Map<String, Double> getConstants();
    Writer getOutput();
}
