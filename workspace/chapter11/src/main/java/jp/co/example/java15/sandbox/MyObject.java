package jp.co.example.java15.sandbox;

public class MyObject {
    private int value = 0;

    public void add(int addedValue) {
        value += addedValue;
    }

    public int addValue(int operand) {
        return operand + value;
    }
}
