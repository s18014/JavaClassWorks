package jp.co.example.java15.sandbox;

public class Calculator {
	 
	/**
	 * aとbを足した結果を返します
	 * @param a
	 * @param b
	 * @return
	 */
	public int add(int a, int b) {
		return a + b;
	}
	
	/**
	 * aからbを引いた結果を返します
	 * @param a
	 * @param b
	 * @return
	 */
	public int subtract(int a, int b) {
		return b - a;
	}
	
	/**
	 * aとbを掛けた結果を返します
	 * @param a
	 * @param b
	 * @return
	 */
	public int multiply(int a, int b) {
		return a * b;
	}
	
	/**
	 * aをbで割った結果を返します
	 * @param a
	 * @param b
	 * @return
	 */
	public int divide(int a, int b) {
		return a / b;
	}

}
