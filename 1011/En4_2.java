import java.util.*;

public class En4_2 {
    public static void main(String[] args) {
        PrimeNumberCalculator pnc = new PrimeNumberCalculator();
        printNumbers(pnc.calcTo(100));
    }

    private static void printNumbers(List<Integer> numbers) {
        for (int number: numbers) {
            System.out.println(number);
        }
    }

    private static void print(Object obj) {
        System.out.println(obj);
    }
}
