public class Calculator {
    public int add(int a, int b) {
        return a + b;
    }
    public int subtract(int a, int b) {
        return a - b;
    }
    public int multiply(int a, int b) {
        return a * b;
    }
    public int divide(int a, int b) {
        if (a == 0 || b == 0) {
            throw new ArithmeticException("Exception occurred");
        }
        return a / b;
    }
}
