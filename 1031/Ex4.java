import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Ex4{

	public int [] ex4_1(int [] a){
        Arrays.sort(a);
		return a;

	}

	public int [] ex4_2(int [] a){
        List<Integer> list = new ArrayList<>();
        for (int tmp : a) {
            list.add((Integer)tmp);
        }
        Collections.sort(list, Comparator.reverseOrder());
        for (int i = 0 ;i < a.length; i++) {
            a[i] = list.get(i);
        }
		return a;
}

	public String [] ex4_3(int [] a){
		String [] hantei = new String[a.length];
        for (int i = 0; i < a.length; i++) {
            if (a[i] > 0) {
                hantei[i] = "正";
            } else if (a[i] < 0) {
                hantei[i] = "負";
            } else {
                hantei[i] = "零";
            }
        }
		return hantei;

	}

	public int ex4_4(int a){
		return String.valueOf(a).length();

	}

	public int ex4_5(int a){
        int result = 0;
        for (int i = 1; i < a+1; i++) {
            result += i;
        }
        return result;

	}

	public int [] ex4_6(int a){
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < a+1; i++) {
            if (a % i == 0) {
                list.add(i);
            }
        }
        int[] array = new int[list.size()];
        for (int i = 0; i < array.length; i++) {
            array[i] = list.get(i);
        }
		return array;

	}

	public boolean ex4_7(int a){
        if (a == 1) {
            return false;
        }
        if (a == 2) {
            return true;
        }
        for (int i = 2; i < a; i++) {
            if (a % i == 0) {
                return false;
            }
        }
		return true;

	}

	public int ex4_8(int [] a){
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }
		return sum;

	}

	public int ex4_9(int [] a){
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }
        return (int)Math.round((double)sum / a.length);
	}
}

