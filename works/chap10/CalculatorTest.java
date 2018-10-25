import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class CalculatorTest {
    private final Calculator calculator = new Calculator();
    public static void main(String[] args) {
        org.junit.runner.JUnitCore.main(CalculatorTest.class.getName());
    }

    @Test
    public void doTestSubtractTwoByThree() {
        assertThat(calculator.subtract(2, 3), is(-1));
    }

    @Test
    public void doTestAddOneAndMinusFour() {
        assertThat(calculator.add(1, -4), is(-3));
    }

    @Test(expected = ArithmeticException.class)
    public void doTestDivideByZero() {
        calculator.divide(3, 0);
    }

    @Test
    public void doTestDivideByZero2() {
        try {
            calculator.divide(3, 0);
            fail("Did not throw exception, Unexpected act");
        } catch (ArithmeticException e) {
            assertThat(e.getMessage(), is("/ by zero"));
        } catch (Exception e) {
            fail("Throwed unexepected exception :" + e.getMessage());
        }
    }
}
