class Ex7{

	public int ex7_1(int a, int b){
        return Math.min(a, b);
	}

	public int ex7_1(int a, int b, int c){
        int min = Math.min(a, b);
        min = Math.min(min, c);
        return min;
	}

	public int ex7_1(int [] a){
        int min = a[0];
        for (int i: a) {
            min = Math.min(min, a[i]);
        }
		return min;
	}

	public int ex7_2(int x){
		
		return x;
	}

	public long ex7_2(long x){
		
		return x;
	}

	public float ex7_2(float x){
		
		return x;
	}

	public double ex7_2(double x){
		
		return x;
	}

	public String ex7_3(byte x){
		
		String ret = "";
		
		return ret;
	}

	public String ex7_3(short x){
		
		String ret = "";
		
		return ret;
	}

	public String ex7_3(int x){
		
		String ret = "";
		
		return ret;
	}

	public String ex7_3(long x){
		
		String ret = "";
		
		return ret;
	}
}