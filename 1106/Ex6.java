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

    public int [] ex6_7(int [] a, int idx){
        List<Integer> list = new ArrayList<>();
        for (int i: a) {
            list.add(i);
        }
        list.remove(idx);
        int[] ret = new int[list.size()];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = list.get(i);
        }
        return ret;

    }


    public int [] ex6_8(int [] a, int idx, int n){
        if (idx + n > a.length) return a;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            list.add(a[i]);
        }
        for (int i = 0; i < n; i++) {
            list.remove(idx);
        }
        int[] ret = new int[list.size()];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = list.get(i);
        }
        return ret;
    }


    public int [] ex6_9(int [] a, int idx, int x){
        List<Integer> list = new ArrayList<>();
        for (int i: a) {
            list.add(i);
        }
        list.add(idx, x);
        int[] ret = new int[list.size()];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = list.get(i);
        }
        return ret;
    }

    public void ex6_10(int [] a, int [] b){
        int minLen = Math.min(a.length, b.length);
        int [] tmpA = new int [a.length];
        int [] tmpB = new int [b.length];
        System.arraycopy(a, 0, tmpA, 0, a.length);
        System.arraycopy(b, 0, tmpB, 0, b.length);
        for (int i = 0; i < minLen; i++) {
            a[i] = tmpB[i];
            b[i] = tmpA[i];
        }
    }

    public int [] ex6_11(int [] a){
        return a;
    }

    public int [] ex6_12(int [] a, int x){
        List<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            if (a[i] == x) indexes.add(i);
        }
        int [] ret = new int [indexes.size()];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = indexes.get(i);
        }
        return ret;
    }

    public int [] ex6_13(int [] a, int idx){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            if (i != idx) {
                list.add(a[i]);
            }
        }
        int [] ret = new int [list.size()];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = list.get(i);
        }
        return ret;
    }

    public int [] ex6_14(int [] a, int idx, int n){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            list.add(a[i]);
        }
        for (int i = 0; i < n; i++) {
            if (list.size() <= idx) break;
            list.remove(idx);
        }
        int[] ret = new int[list.size()];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = list.get(i);
        }
        return ret;
    }

    public int [] ex6_15(int [] a, int idx, int x){
        if (idx == -1) idx = 0;
        List<Integer> list = new ArrayList<>();
        for (int i: a) {
            list.add(i);
        }
        list.add(idx, x);
        int[] ret = new int[list.size()];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = list.get(i);
        }
        return ret;
    }

}