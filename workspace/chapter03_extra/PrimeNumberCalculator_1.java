package jp.co.example.java15;

import java.util.*;

public class PrimeNumberCalculator {
	public static List<Integer> calcTo(int maxNumber) {
		if (maxNumber < 2) {
			return Collections.emptyList();
		}
		List<Integer> primeNumbers = new ArrayList<Integer>();
		primeNumbers.add(2);
		for (int testNumber = 3; testNumber <= maxNumber; testNumber = testNumber + 2) {
			if (isPrimeNumber(testNumber)) {
				primeNumbers.add(testNumber);
			}
		}
		return primeNumbers;
	}

	private static boolean isPrimeNumber(int testNumber) {
		if (testNumber < 2) {
			return false;
		} else if (testNumber == 2) {
			return true;
		}
		for (int i = 3, searchingLimit = (int) Math.sqrt(testNumber);
				i <= searchingLimit; i = i + 2) {
			if (testNumber % i == 0) {
				return false;
			}
		}
		return true;
	}
}

