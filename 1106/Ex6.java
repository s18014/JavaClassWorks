import java.util.*;

class Ex6{

	public int [] ex6_1(){
        int [] ret = {5, 4, 3, 2, 1};
		return ret;
	}

	public double [] ex6_2(){
		double [] ret = {1.1, 2.2, 3.3, 4.4, 5.5};
		return ret;
	}

	public int [] ex6_3(int a, int b){
        int [] ret = new int[a];
        for (int i = 0; i < a; i++) {
            ret[i] = b;
        }
		return ret;
	}

	public int [] ex6_4(int [] a){
        int sum = 0;
        int average;
        int max = a[0];
        int min = a[0];
        for (int i: a) {
            sum += i;
            max = Math.max(max, i);
            min = Math.min(min, i);
        }
        average = (int)Math.round((double)sum / a.length);
        int[] ret = {sum, average, max, min};
		return ret;
	}

	public int ex6_5(int [] a, int key){
        for (int i = 0; i < a.length; i++) {
            if (a[i] == key) {
                return i;
            }
        }
		return -1;
	}

	public int ex6_6(int [] a, int key){
        for (int i = a.length-1; i > 0 ; i--) {
            if (a[i] == key) {
                return i;
            }
        }
		return -1;

	}

	public void ex6_7(int [] a, int idx){
        if (a.length-1 == idx) {
            return;
        }
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < a.length; i++) {
            list.add(a[i]);
        }
        list.add(list.get(list.size()-1));
        list.remove(idx);

        for (int i = 0; i < a.length; i++) {
            a[i] = list.get(i);
        }

	}

	public void ex6_8(int [] a, int idx, int n){
        List<Integer> list = new ArrayList<Integer>();

        for (int i = 0; i < a.length; i++) {
            list.add(a[i]);
        }
        List<Integer> tmpList = list;
        Iterator<Integer> ite = tmpList.iterator();

        for (int i = idx; i < n+1; i++) {
            list.remove(idx);
        }

        for (int i = 0; i < a.length; i++) {
            a[i] = list.get(i);
        }
		return;
	}

	public void ex6_9(int [] a, int idx, int x){
		
		return;
	}

	public void ex6_10(int [] a, int [] b){
		
		return;
	}

	public int [] ex6_11(int [] a){
		
		int [] ret = new int[0];

		return ret;
	}

	public int [] ex6_12(int [] a, int x){
		
		int [] ret = new int[0];

		return ret;
	}

	public int [] ex6_13(int [] a, int idx){
		
		int [] ret = new int[0];

		return ret;
	}
	
	public int [] ex6_14(int [] a, int idx, int n){
		
		int [] ret = new int[0];
		
		return ret;
	}
	
	public int [] ex6_15(int [] a, int idx, int x){
		
		int [] ret = new int[0];
		
		return ret;
	}
}