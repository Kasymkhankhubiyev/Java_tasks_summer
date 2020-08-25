package task2.commands;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MultiplyTest extends AbstractCalculatorTest{
    @Test
    public void testMultiply(){
        addCommand("PUSH 10");
        addCommand("PUSH 8");
        addCommand("MULTIPLY");
        runCalculator();
        assertEquals(1, getStack().size());
        assertEquals(80D, getStack().peek());
    }
}