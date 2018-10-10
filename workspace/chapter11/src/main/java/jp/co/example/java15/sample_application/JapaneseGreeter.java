package jp.co.example.java15.sample_application;

public class JapaneseGreeter implements Greeter {
	@Override
	public void login(Account guest) {
		System.out.println(String.format("こんにちは、%sさん。", guest.getName()));
	}

	@Override
	public void logout(Account guest) {
		System.out.println("さようなら。");
	}

	@Override
	public void like(Account guest) {
		System.out.println("ありがとうございます。");
	}

}
