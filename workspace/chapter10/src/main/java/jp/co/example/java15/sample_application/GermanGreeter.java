package jp.co.example.java15.sample_application;

public class GermanGreeter implements Greeter {
	// 説明の都合上、少し冗長な書き方をしています。
	@Override
	public void login(Account guest) {
		String message = String.format("Guten Tag, %s.", guest.getCountry());
		System.out.println(message);
	}

	@Override
	public void logout(Account guest) {
		System.out.println("Aus Wiedersehen.");
	}

	@Override
	public void like(Account guest) {
		System.out.println("Danke schon.");
	}

}
