import java.util.*;

public class PrimeNumberCalculator {
    public List<Integer> calcTo(int maxNumber) {
        List<Integer> primeNumbers =  new ArrayList<>();
        for (int testNumber = 2; testNumber <= maxNumber; testNumber++) {
            if (isPrimeNumber(testNumber)) {
                primeNumbers.add(testNumber);
            }
        }
        return primeNumbers;
    }

    private boolean isPrimeNumber(int testNumber) {
        for (int i = 2; i < testNumber; i++) {
            if (testNumber % i == 0) {
                return false;
            }
        }
        return true;
    }
}
