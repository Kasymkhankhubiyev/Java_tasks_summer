package task2.commands;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SqrtTest extends AbstractCalculatorTest{
    @Test
    public void testSqrt(){
        addCommand("PUSH 10");
        addCommand("PUSH 16");
        addCommand("SQRT");
        runCalculator();
        assertEquals(2, getStack().size());
        assertEquals(4D, getStack().pop());
    }
}