import it_college.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // printNumbers(PrimeNumberCalculator.calcTo(100));
        // print(String.format("--1--\ncount: %d\n", PrimeNumberCalculator.count));
        printNumbers(PrimeNumberCalculator2.calcTo(100));
        print(String.format("--2--\ncount: %d\n", PrimeNumberCalculator2.count));
        printNumbers(PrimeNumberCalculator3.calcTo(100));
        print(String.format("--3--\ncount: %d\n", PrimeNumberCalculator3.count));
        printNumbers(PrimeNumberCalculator4.calcTo(100));
        print(String.format("--4--\ncount: %d\n", PrimeNumberCalculator4.count));
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
