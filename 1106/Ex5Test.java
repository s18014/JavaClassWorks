import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;

public class Ex5Test {

    Ex5 ex5 = new Ex5();

	@Test
	public void ex5_1_1(){
		double expected = (2+3+5)/3.0;
		int [] test = {2, 3, 5};
		double actual = ex5.ex5_1(test);
		assertThat(actual, is(expected));
	}
	@Test
	public void ex5_1_2(){
		double expected = (1001+2002+3007)/3.0;
		int [] test = {1001, 2002, 3007};
		double actual = ex5.ex5_1(test);
		assertThat(actual, is(expected));
	}
	@Test
	public void ex5_1_3(){
		double expected = (1+2+3+4+5+6+7+8+9+10)/10.0;
		int [] test = {1, 2, 3, 4, 5, 6, 7, 8,  9, 10};
		double actual = ex5.ex5_1(test);
		assertThat(actual, is(expected));
	}
	@Test
	public void ex5_1_4(){
		double expected = (0+1+-2)/3.0;
		int [] test = {0, 1, -2};
		double actual = ex5.ex5_1(test);
		assertThat(actual, is(expected));
	}
	@Test
	public void ex5_1_5(){
		double expected = (-1+-2+-3+-4+-5+-6+-7+-8+-9+-10)/10.0;
		int [] test = {-1, -2, -3, -4, -5, -6, -7, -8, -9, -10};
		double actual = ex5.ex5_1(test);
		assertThat(actual, is(expected));
	}

	// エントリーポイント
	public static void main(String[] args){
		org.junit.runner.JUnitCore.main(Ex5Test.class.getName());
	}
}
