package it_college;
import java.util.*;

public class PrimeNumberCalculator3 {
    public static int count;
    public static List<Integer> calcTo(int maxNumber) {
        if (maxNumber < 2) {
            return Collections.emptyList();
        }

        List<Integer> primeNumbers =  new ArrayList<>();

        primeNumbers.add(2);
        for (int testNumber = 3; testNumber <= maxNumber; testNumber += 2) {
            count++;
            if (isPrimeNumber(testNumber)) {
                primeNumbers.add(testNumber);
            }
        }
        return primeNumbers;
    }

    public static boolean isPrimeNumber(int testNumber) {
        if (testNumber < 2) {
            return false;
        } else if (testNumber == 2) {
            return true;
        } else if (testNumber % 2 == 0) {
            return false;
        }

        for (int i = 3, searchingLimit = (int) Math.sqrt(testNumber); i < searchingLimit; i += 2) {
            count++;
            if (testNumber % i == 0) {
                return false;
            }
        }
        return true;
    }
}
