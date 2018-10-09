package jp.co.example.java15.sandbox;

public class Sample {

	public int executeSample(String[] args) {

		int result = 0;
		if (args == null) {
			throw new IllegalArgumentException("引数が指定されていません。");
		}

		if (args.length < 3) {
			throw new IllegalArgumentException("引数が足りません。");
		}

		if (args[0].equals("hoge")) {
			result = result + 1;
		}

		if (args[1].equals("piyo") && args[2].equals("fuga")) {
			result = result + 2;
		}
		return result;
	}

}
