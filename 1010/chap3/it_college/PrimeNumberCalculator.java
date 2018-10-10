package it_college;
import java.util.*;

public class PrimeNumberCalculator {
    public static int count;
    public static List<Integer> calcTo(int maxNumber) {
        List<Integer> primeNumbers =  new ArrayList<>();
        for (int testNumber = 2; testNumber <= maxNumber; testNumber++) {
            if (isPrimeNumber(testNumber)) {
                primeNumbers.add(testNumber);
            }
        }
        return primeNumbers;
    }

    public static boolean isPrimeNumber(int testNumber) {
        for (int i = 2; i < testNumber; i++) {
            count++;
            if (testNumber % i == 0) {
                return false;
            }
        }
        return true;
    }
}
