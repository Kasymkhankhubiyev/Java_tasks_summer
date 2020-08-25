package task2.commands;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DefineTest  extends AbstractCalculatorTest{
    @Test
    public void testDefine(){
        addCommand("DEFINE a 5");
        runCalculator();
        assertEquals(1, getConstants().size());
        assertEquals(5D, getConstants().get("a"));
    }

    @Test
    public void testReDefine(){
        addCommand("DEFINE a 5");
        addCommand("DEFINE a 10");
        runCalculator();
        assertEquals(1, getConstants().size());
        assertEquals(10D, getConstants().get("a"));
    }

}