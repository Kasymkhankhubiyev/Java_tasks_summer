package task2.commands;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DivTest extends AbstractCalculatorTest{
    @Test
    public void testDiv(){
        addCommand("PUSH 10");
        addCommand("PUSH 4");
        addCommand("DIV");
        runCalculator();
        assertEquals(1, getStack().size());
        assertEquals(2.5D, getStack().peek());
    }

    @Test
    public void testDivisionByZero(){
        addCommand("PUSH 10");
        addCommand("PUSH 0");
        addCommand("DIV");
        runCalculator();
        assertEquals(2, getStack().size());
    }
}