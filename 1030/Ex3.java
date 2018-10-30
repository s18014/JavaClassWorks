import java.util.Arrays;

class Ex3{

	public String ex3_0(int n){
        String message;
        if (n > 0) {
            message = "その値は正です";
        } else {
            message = "その値は０か負です";
        }
		return message;

	}

	public int ex3_1(int n){
		return Math.abs(n);
	}

	public String ex3_2(int a, int b){
        String message;
        if (a % b == 0) {
            message = String.format("%dは%dの約数です", b, a);
        } else {
            message = String.format("%dは%dの約数ではありません", b, a);
        }
        return message;
	}

	public String ex3_3(int a, int b){
        String message;
        if (a > b) {
            message = String.format("%dの方が大きいです", a);
        } else if (b > a) {
            message = String.format("%dの方が大きいです", b);
        } else {
            message = "同じ値です";
        }
        return message;
	}

	public String ex3_4(int a){
        String message;
        if (a < 0) {
            message = "正でない整数値です";
        } else if (a % 5 == 0) {
            message = "その値は5で割り切れます";
        } else {
            message = "その値は5で割り切れません";
        }
		return message;
	}

	public String ex3_5(int a){
        String message;
        if (a < 0) {
            message = "正でない整数値です";
        } else if (a % 10 == 0) {
            message = "その値は10の倍数です";
        } else {
            message = "その値は10の倍数ではありません";
        }
		return message;
	}

	public String ex3_6(int a){
        String message;
        int R = a % 3;
        if (a < 0) {
            message = "正でない整数値です";
        } else if (R == 0) {
            message = "その値は3で割り切れます";
        } else {
            message = String.format("その値を3で割った余りは%dです", R);
        }
        return message;
	}

	public String ex3_7(int a){
        String eval;
        if (a < 0 || a > 100) {
            return "範囲(0～100)外の値です";
        }
        if (a <= 59) {
            eval = "不可";
        } else if (a <= 69) {
            eval = "可";
        } else if (a <= 79) {
            eval = "良";
        } else {
            eval = "優";
        }
        return eval;
	}

	public double ex3_8(double a, double b){
        if (a > b) return a; else return b;
	}

	public int ex3_9(int a, int b){
        return a - b;
	}

	public String ex3_10(int a, int b){
        String message;
        if (Math.abs(a - b) <= 10) {
            message = "それらの差は10以下です";
        } else {
            message = "それらの差は11以上です";
        }
        return message;
	}

	public int ex3_11(int a, int b, int c){
        int values[] = {a, b, c};
        int min = a;
        for (int value : values) {
            min = Math.min(min, value);
        }
        return min;
	}

	public int ex3_12(int a, int b, int c){
        int values[] = {a, b, c};
        Arrays.sort(values);
        return values[1];
	}

	public String ex3_13(int a){
        String season;
        if (a < 1 || a > 12) {
            return  "範囲(1～12)外の値です";
        }
        if (a >= 3 && a <= 5) {
            season = "春";
        } else if (a >= 6 && a <= 8) {
            season = "夏";
        } else if (a >= 9 && a <= 11) {
            season = "秋";
        } else {
            season = "冬";
        }
        return season;
	}
}

