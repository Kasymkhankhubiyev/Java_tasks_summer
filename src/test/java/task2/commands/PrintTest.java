package task2.commands;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PrintTest extends AbstractCalculatorTest{
    @Test
    public void testPrint(){
        addCommand("PUSH 10");
        addCommand("PUSH 8");
        addCommand("PRINT");
        runCalculator();
        assertEquals(2, getStack().size());
        assertEquals(1, output.size());
        assertEquals("" + 8D, output.get(0));
    }
}