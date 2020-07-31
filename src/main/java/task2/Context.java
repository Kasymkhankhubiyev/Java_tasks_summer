package task2;

import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Context {
    private Stack<String> stack = new Stack<String>();
    private String[] comList= null;
    private Map<String,String> map = new HashMap<String,String>();
    private Writer writer;

    Context(Writer writer) {
        this.writer = writer;
    }

    void setArray(int i, String str){
        comList[i]=str;
    }
    String getArray(int i) {
        return comList[i];
    }
    void putValuables(String a,String n){
        map.put(a,n);
    }
    void setStack(String str){
        stack.push(str);
    }
    //String getStack(int i) {
      //  return stack;
    //}
    String getConstants(String string) {

        return map.get(string);
    }

    Writer getOutput() {
        return writer;
    }
}