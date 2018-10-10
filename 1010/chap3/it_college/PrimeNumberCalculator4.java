package it_college;

import java.util.*;

public class PrimeNumberCalculator4 {
    public static int count;
	public static List<Integer> calcTo(int maxNumber) {
		if (maxNumber < 2) {
			return Collections.emptyList();
		}

		boolean[] isPrimeNumber = new boolean[maxNumber + 1];
		for (int testNumber = 3; testNumber <= maxNumber; testNumber += 2) {
			isPrimeNumber[testNumber] = true;
		}

		List<Integer> primeNumbers = new ArrayList<Integer>();
		primeNumbers.add(2);
		for (int testNumber = 3, searchingLimit = (int) Math.sqrt(maxNumber);
				testNumber <= maxNumber; testNumber = testNumber + 2) {
                count ++;
			if (!isPrimeNumber[testNumber]) {
				continue;
			}
			primeNumbers.add(testNumber);
			if (testNumber > searchingLimit) {
				continue;
			}
			for (int i = testNumber * 2; i <= maxNumber; i = i + testNumber) {
				isPrimeNumber[i] = false;
			}
		}
		return primeNumbers;
	}
}
