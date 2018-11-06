import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;
import org.junit.Ignore;

public class Ex6Test {

    private final Ex6 ex6 = new Ex6();

	@Test
	public void ex6_1_1(){
		int [] expected = {5, 4, 3, 2, 1};
		int [] actual = ex6.ex6_1();
		assertThat(actual, is(expected));
	}
	@Test
	public void ex6_2_1(){
		double [] expected = {1.1, 2.2, 3.3, 4.4, 5.5};
		double [] actual = ex6.ex6_2();
		assertThat(actual, is(expected));
	}
	@Test
	public void ex6_3_1(){
		int [] expected = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		int [] actual = ex6.ex6_3(10, 0);
		assertThat(actual, is(expected));
	}
	@Test
	public void ex6_3_2(){
		int [] expected = {1000};
		int [] actual = ex6.ex6_3(1, 1000);
		assertThat(actual, is(expected));
	}
	@Test
	public void ex6_3_3(){
		int [] expected = {1, 1, 1};
		int [] actual = ex6.ex6_3(3, 1);
		assertThat(actual, is(expected));
	}
	@Test
	public void ex6_3_4(){
		int [] expected = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
		int [] actual = ex6.ex6_3(10, -1);
		assertThat(actual, is(expected));
	}
	@Test
	public void ex6_3_5(){
		int [] expected = {2, 2};
		int [] actual = ex6.ex6_3(2, 2);
		assertThat(actual, is(expected));
	}
	@Test
	public void ex6_4_1(){
		int [] expected = {55, 6, 10, 1};
		int [] test = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int [] actual = ex6.ex6_4(test);
		assertThat(actual, is(expected));
	}
	@Test
	public void ex6_4_2(){
		int [] expected = {-55, -5, -1, -10};
		int [] test = {-1, -2, -3, -4, -5, -6, -7, -8, -9, -10};
		int [] actual = ex6.ex6_4(test);
		assertThat(actual, is(expected));
	}
	@Test
	public void ex6_4_3(){
		int [] expected = {-23, -2, 10, -11};
		int [] test = {-10, 1, -1, 10, -5, 3, 1, 2, -8, -5, -11};
		int [] actual = ex6.ex6_4(test);
		assertThat(actual, is(expected));
	}
	@Test
	public void ex6_4_4(){
		int [] expected = {455, 46, 91, 1};
		int [] test = {50, 70, 45, 22, 91, 82, 77, 14, 3, 1};
		int [] actual = ex6.ex6_4(test);
		assertThat(actual, is(expected));
	}
	@Test
	public void ex6_4_5(){
		int [] expected = {-455, -45, -1, -91};
		int [] test = {-50, -70, -45, -22, -91, -82, -77, -14, -3, -1};
		int [] actual = ex6.ex6_4(test);
		assertThat(actual, is(expected));
	}
	@Test
	public void ex6_5_1(){
		int expected = 4;
		int [] test = {1, 2, 3, 4, 5, 5, 7, 8, 5, 5};
		int actual = ex6.ex6_5(test,5);
		assertThat(actual, is(expected));
	}
	@Test
	public void ex6_5_2(){
		int expected = 4;
		int [] test = {-1, -2, -3, -4, -5, -5, -7, -8, -5, -5};
		int actual = ex6.ex6_5(test,-5);
		assertThat(actual, is(expected));
	}
	@Test
	public void ex6_5_3(){
		int expected = 4;
		int [] test = {1, 2, 3, 4, -1, -2, -3, -3, -3, -1};
		int actual = ex6.ex6_5(test,-1);
		assertThat(actual, is(expected));
	}
	@Test
	public void ex6_5_4(){
		int expected = -1;
		int [] test = {1, 2, 3, 4, 1, 2, 3, 3, 3, 1};
		int actual = ex6.ex6_5(test,5);
		assertThat(actual, is(expected));
	}
	@Test
	public void ex6_5_5(){
		int expected = 0;
		int [] test = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		int actual = ex6.ex6_5(test,0);
		assertThat(actual, is(expected));
	}
	@Test
	public void ex6_6_1(){
		int expected = 9;
		int [] test = {1, 2, 3, 4, 5, 5, 7, 8, 5, 5};
		int actual = ex6.ex6_6(test,5);
		assertThat(actual, is(expected));
	}
	@Test
	public void ex6_6_2(){
		int expected = 9;
		int [] test = {-1, -2, -3, -4, -5, -5, -7, -8, -5, -5};
		int actual = ex6.ex6_6(test,-5);
		assertThat(actual, is(expected));
	}
	@Test
	public void ex6_6_3(){
		int expected = 9;
		int [] test = {1, 2, 3, 4, -1, -2, -3, -3, -3, -1};
		int actual = ex6.ex6_6(test,-1);
		assertThat(actual, is(expected));
	}
	@Test
	public void ex6_6_4(){
		int expected = -1;
		int [] test = {1, 2, 3, 4, 1, 2, 3, 3, 3, 1};
		int actual = ex6.ex6_6(test,5);
		assertThat(actual, is(expected));
	}
	@Test
	public void ex6_6_5(){
		int expected = 9;
		int [] test = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		int actual = ex6.ex6_6(test,0);
		assertThat(actual, is(expected));
	}
	@Test
	public void ex6_7_1(){
		int [] a = {1, 3, 4, 7, 9, 11};
		int idx = 2;
		int [] expected = {1, 3, 7, 9, 11};
		int [] actual = ex6.ex6_7(a, idx);
		assertThat(actual, is(expected));
	}
	@Test
	public void ex6_7_2(){
		int [] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int idx = 0;
		int [] expected = {2, 3, 4, 5, 6, 7, 8, 9, 10};
		int [] actual = ex6.ex6_7(a, idx);
		assertThat(actual, is(expected));
	}
	@Test
	public void ex6_7_3(){
		int [] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int idx = 9;
		int [] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		int [] actual = ex6.ex6_7(a, idx);
		assertThat(actual, is(expected));
	}
	@Test
	public void ex6_7_4(){
		int [] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int idx = 1;
		int [] expected = {1, 3, 4, 5, 6, 7, 8, 9, 10};
		int [] actual = ex6.ex6_7(a, idx);
		assertThat(actual, is(expected));
	}
	@Test
	public void ex6_7_5(){
		int [] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int idx = 8;
		int [] expected = {1, 2, 3, 4, 5, 6, 7, 8, 10};
		int [] actual = ex6.ex6_7(a, idx);
		assertThat(actual, is(expected));
	}
	@Test
	public void ex6_8_1(){
		int [] a = {1, 3, 4, 7, 9, 11};
		int idx = 1;
		int n = 3;
		int [] expected = {1, 9, 11};
		int [] actual = ex6.ex6_8(a, idx, n);
		assertThat(actual, is(expected));
	}
	@Test
	public void ex6_8_2(){
		int [] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int idx = 2;
		int n = 5;
		int [] expected = {1, 2, 8, 9, 10};
		int [] actual = ex6.ex6_8(a, idx, n);
		assertThat(actual, is(expected));
	}
	@Test
	public void ex6_8_3(){
		int [] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int idx = 0;
		int n = 9;
		int [] expected = {10};
		int [] actual = ex6.ex6_8(a, idx, n);
		assertThat(actual, is(expected));
	}
	@Test
	public void ex6_8_4(){
		int [] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int idx = 9;
		int n = 9;
		int [] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int [] actual = ex6.ex6_8(a, idx, n);
		assertThat(actual, is(expected));
	}
	@Test
	public void ex6_8_5(){
		int [] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int idx = 0;
		int n = 0;
		int [] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int [] actual = ex6.ex6_8(a, idx, n);
		assertThat(actual, is(expected));
	}
	@Test
	public void ex6_9_1(){
		int [] a = {1, 3, 4, 7, 9, 11};
		int idx = 2;
		int x = 99;
		int [] expected = {1, 3, 99, 4, 7, 9, 11};
		int [] actual = ex6.ex6_9(a, idx, x);
		assertThat(actual, is(expected));
	}
	@Test
	public void ex6_9_2(){
		int [] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int idx = 2;
		int x = 5;
		int [] expected = {1, 2, 5, 3, 4, 5, 6, 7, 8, 9, 10};
		int [] actual = ex6.ex6_9(a, idx, x);
		assertThat(actual, is(expected));
	}
	@Test
	public void ex6_9_3(){
		int [] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int idx = 0;
		int x = 0;
		int [] expected = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int [] actual = ex6.ex6_9(a, idx, x);
		assertThat(actual, is(expected));
	}
	@Test
	public void ex6_9_4(){
		int [] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int idx = 9;
		int x = 9;
		int [] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9, 9, 10};
		int [] actual = ex6.ex6_9(a, idx, x);
		assertThat(actual, is(expected));
	}
	@Test
	public void ex6_9_5(){
		int [] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int idx = 5;
		int x = 100;
		int [] expected = {1, 2, 3, 4, 5, 100, 6, 7, 8, 9, 10};
		int [] actual = ex6.ex6_9(a, idx, x);
		assertThat(actual, is(expected));
	}
	@Test
	public void ex6_10_1(){
		int [] a = {1, 2, 3, 4, 5, 6, 7};
		int [] b = {5, 4, 3, 2, 1};
		int [] expected_a = {5, 4, 3, 2, 1, 6, 7};
		int [] expected_b = {1, 2, 3, 4, 5};
		ex6.ex6_10(a, b);
		assertThat(a, is(expected_a));
		assertThat(b, is(expected_b));
	}
	@Test
	public void ex6_10_2(){
		int [] a = {1, 2, 3, 4, 5, 6, 7};
		int [] b = {7, 6, 5, 4, 3, 2, 1};
		int [] expected_a = {7, 6, 5, 4, 3, 2, 1};
		int [] expected_b = {1, 2, 3, 4, 5, 6, 7};
		ex6.ex6_10(a, b);
		assertThat(a, is(expected_a));
		assertThat(b, is(expected_b));
	}
	@Test
	public void ex6_10_3(){
		int [] a = {1, 2, 3, 4, 5, 6, 7};
		int [] b = {};
		int [] expected_a = {1, 2, 3, 4, 5, 6, 7};
		int [] expected_b = {};
		ex6.ex6_10(a, b);
		assertThat(a, is(expected_a));
		assertThat(b, is(expected_b));
	}
	@Test
	public void ex6_10_4(){
		int [] a = {1, 2, 3, 4, 5, 6, 7};
		int [] b = {1000};
		int [] expected_a = {1000, 2, 3, 4, 5, 6, 7};
		int [] expected_b = {1};
		ex6.ex6_10(a, b);
		assertThat(a, is(expected_a));
		assertThat(b, is(expected_b));
	}
	@Test
	public void ex6_10_5(){
		int [] a = {1, 2, 3, 4, 5, 6, 7};
		int [] b = {-1, -2, -3, -4, -5, -6, -7, -8};
		int [] expected_a = {-1, -2, -3, -4, -5, -6, -7};
		int [] expected_b = {1, 2, 3, 4, 5, 6, 7, -8};
		ex6.ex6_10(a, b);
		assertThat(a, is(expected_a));
		assertThat(b, is(expected_b));
	}
	@Test
	public void ex6_11_1(){
		int [] a = {1, 2, 3, 4, 5, 6, 7};
		int [] expected = {1, 2, 3, 4, 5, 6, 7};
		int [] actual = ex6.ex6_11(a);
		a = null;
		assertThat(actual, is(expected));
	}
	@Test
	public void ex6_11_2(){
		int [] a = {-1, -2, -3, -4, -5, -6, -7};
		int [] expected = {-1, -2, -3, -4, -5, -6, -7};
		int [] actual = ex6.ex6_11(a);
		a = null;
		assertThat(actual, is(expected));
	}
	@Test
	public void ex6_11_3(){
		int [] a = {-3, -2, -1, 0, 1, 2, 3};
		int [] expected = {-3, -2, -1, 0, 1, 2, 3};
		int [] actual = ex6.ex6_11(a);
		a = null;
		assertThat(actual, is(expected));
	}
	@Test
	public void ex6_11_4(){
		int [] a = {0};
		int [] expected = {0};
		int [] actual = ex6.ex6_11(a);
		a = null;
		assertThat(actual, is(expected));
	}
	@Test
	public void ex6_11_5(){
		int [] a = {};
		int [] expected = {};
		int [] actual = ex6.ex6_11(a);
		a = null;
		assertThat(actual, is(expected));
	}
	@Test
	public void ex6_12_1(){
		int [] a = {1, 5, 4, 8, 5, 5, 7};
		int [] expected = {1, 4, 5};
		int x = 5;
		int [] actual = ex6.ex6_12(a, x);
		assertThat(actual, is(expected));
	}
	@Test
	public void ex6_12_2(){
		int [] a = {5, 5, 5, 5, 5, 5, 5};
		int [] expected = {0, 1, 2, 3, 4, 5, 6};
		int x = 5;
		int [] actual = ex6.ex6_12(a, x);
		assertThat(actual, is(expected));
	}
	@Test
	public void ex6_12_3(){
		int [] a = {0, 0, 0, 0, 0, 0, 0};
		int [] expected = {};
		int x = 5;
		int [] actual = ex6.ex6_12(a, x);
		assertThat(actual, is(expected));
	}
	@Test
	public void ex6_12_4(){
		int [] a = {1, 2, 3, 4, 5, 6, 7};
		int [] expected = {6};
		int x = 7;
		int [] actual = ex6.ex6_12(a, x);
		assertThat(actual, is(expected));
	}
	@Test
	public void ex6_12_5(){
		int [] a = {-1, -2, -3, -4, -5, -6, -7};
		int [] expected = {0};
		int x = -1;
		int [] actual = ex6.ex6_12(a, x);
		assertThat(actual, is(expected));
	}
	@Test
	public void ex6_13_1(){
		int [] a = {1, 3, 4, 7, 9, 11};
		int idx = 2;
		int [] expected = {1, 3, 7, 9, 11};
		int [] actual = ex6.ex6_13(a, idx);
		assertThat(actual, is(expected));
	}
	@Test
	public void ex6_13_2(){
		int [] a = {1, 3, 4, 7, 9, 11};
		int idx = -1;
		int [] expected = {1, 3, 4, 7, 9, 11};
		int [] actual = ex6.ex6_13(a, idx);
		assertThat(actual, is(expected));
	}
	@Test
	public void ex6_13_3(){
		int [] a = {1, 3, 4, 7, 9, 11};
		int idx = 6;
		int [] expected = {1, 3, 4, 7, 9, 11};
		int [] actual = ex6.ex6_13(a, idx);
		assertThat(actual, is(expected));
	}
	@Test
	public void ex6_13_4(){
		int [] a = {};
		int idx = 0;
		int [] expected = {};
		int [] actual = ex6.ex6_13(a, idx);
		assertThat(actual, is(expected));
	}
	@Test
	public void ex6_13_5(){
		int [] a = {1, 3, 4, 7, 9, 11};
		int idx = 5;
		int [] expected = {1, 3, 4, 7, 9};
		int [] actual = ex6.ex6_13(a, idx);
		assertThat(actual, is(expected));
	}
	@Test
	public void ex6_14_1(){
		int [] a = {1, 3, 4, 7, 9, 11};
		int idx = 1;
		int n = 3;
		int [] expected = {1, 9, 11};
		int [] actual = ex6.ex6_14(a, idx, n);
		assertThat(actual, is(expected));
	}
	@Test
	public void ex6_14_2(){
		int [] a = {1, 3, 4, 7, 9, 11};
		int idx = 0;
		int n = 6;
		int [] expected = {};
		int [] actual = ex6.ex6_14(a, idx, n);
		assertThat(actual, is(expected));
	}
	@Test
	public void ex6_14_3(){
		int [] a = {1, 3, 4, 7, 9, 11};
		int idx = 0;
		int n = 7;
		int [] expected = {};
		int [] actual = ex6.ex6_14(a, idx, n);
		assertThat(actual, is(expected));
	}
	@Test
	public void ex6_14_4(){
		int [] a = {1, 3, 4, 7, 9, 11};
		int idx = -1;
		int n = -6;
		int [] expected = {1, 3, 4, 7, 9, 11};
		int [] actual = ex6.ex6_14(a, idx, n);
		assertThat(actual, is(expected));
	}
	@Test
	public void ex6_14_5(){
		int [] a = {1, 3, 4, 7, 9, 11};
		int idx = 6;
		int n = 1;
		int [] expected = {1, 3, 4, 7, 9, 11};
		int [] actual = ex6.ex6_14(a, idx, n);
		assertThat(actual, is(expected));
	}
	@Test
	public void ex6_15_1(){
		int [] a = {1, 3, 4, 7, 9, 11};
		int idx = 2;
		int x = 99;
		int [] expected = {1, 3, 99, 4, 7, 9, 11};
		int [] actual = ex6.ex6_15(a, idx, x);
		assertThat(actual, is(expected));
	}
	@Test
	public void ex6_15_2(){
		int [] a = {1, 3, 4, 7, 9, 11};
		int idx = -1;
		int x = 99;
		int [] expected = {99, 1, 3, 4, 7, 9, 11};
		int [] actual = ex6.ex6_15(a, idx, x);
		assertThat(actual, is(expected));
	}
	@Test
	public void ex6_15_3(){
		int [] a = {1, 3, 4, 7, 9, 11};
		int idx = 6;
		int x = 99;
		int [] expected = {1, 3, 4, 7, 9, 11, 99};
		int [] actual = ex6.ex6_15(a, idx, x);
		assertThat(actual, is(expected));
	}
	@Test
	public void ex6_15_4(){
		int [] a = {};
		int idx = 0;
		int x = 99;
		int [] expected = {99};
		int [] actual = ex6.ex6_15(a, idx, x);
		assertThat(actual, is(expected));
	}
	@Test
	public void ex6_15_5(){
		int [] a = {};
		int idx = -1;
		int x = 99;
		int [] expected = {99};
		int [] actual = ex6.ex6_15(a, idx, x);
		assertThat(actual, is(expected));
	}


	// エントリーポイント
	public static void main(String[] args){
		org.junit.runner.JUnitCore.main(Ex6Test.class.getName());
	}
}
