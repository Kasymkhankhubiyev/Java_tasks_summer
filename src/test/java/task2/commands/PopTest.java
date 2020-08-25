package task2.commands;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PopTest extends AbstractCalculatorTest{
    @Test
    public void testPop(){
        addCommand("PUSH 10");
        addCommand("PUSH 8");
        addCommand("POP");
        runCalculator();
        assertEquals(1, getStack().size());
        assertEquals(10D, getStack().peek());
    }
}