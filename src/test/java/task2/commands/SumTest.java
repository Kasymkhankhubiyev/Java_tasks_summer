package task2.commands;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SumTest extends AbstractCalculatorTest{
    @Test
    public void testSum(){
        addCommand("PUSH 10");
        addCommand("PUSH 8");
        addCommand("SUM");
        runCalculator();
        assertEquals(1, getStack().size());
        assertEquals(18D, getStack().peek());
    }
}