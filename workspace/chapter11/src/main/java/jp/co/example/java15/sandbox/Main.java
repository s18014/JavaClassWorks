package jp.co.example.java15.sandbox;

public class Main {
    public static void main(String[] args) {
        MyObject object = new MyObject();
        System.out.println("BeforeAdding: " + object.addValue(-2));
        object.add(3);
        System.out.println("AfterAdding: " + object.addValue(-2));
    }
}
