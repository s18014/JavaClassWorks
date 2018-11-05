class Ex5{

	public double ex5_1(int [] a){
        double sum = 0;
        for (int i : a) {
            sum += i;
        }
		return sum / a.length;
	}
}