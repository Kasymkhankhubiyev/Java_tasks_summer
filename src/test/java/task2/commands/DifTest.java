package task2.commands;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DifTest extends AbstractCalculatorTest{
    @Test
    public void testDif(){
        addCommand("PUSH 10");
        addCommand("PUSH 8");
        addCommand("DIF");
        runCalculator();
        assertEquals(1, getStack().size());
        assertEquals(2D, getStack().peek());
    }
}