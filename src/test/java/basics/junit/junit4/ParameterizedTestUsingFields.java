package basics.junit.junit4;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import basics.junit.junit5.Calculator;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
@RunWith(Parameterized.class)
public class ParameterizedTestUsingFields {
    // fields used together with @Parameter must be public
    private final Calculator calculator = new Calculator();
    @Parameterized.Parameter(0)
    public int m1;
    @Parameterized.Parameter(1)
    public int m2;
    @Parameterized.Parameter(2)
    public int result;
    // creates the test data
    @Parameterized.Parameters(name = "{index}: Test with m1={0}, m2 ={1}, result is:{2} ")
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][]{{1, 2, 2}, {5, 3, 15}, {121, 4, 484}};
        return Arrays.asList(data);
    }
    @Test
    public void testMultiply() {
        assertEquals("Result", result, calculator.multiply(m1, m2));
    }
}
