package jp.co.example.java15.sample_application;

public class GermanGreeter implements Greeter {
	@Override
	public void login(Account guest) {
		System.out.println(String.format("Guten Tag, %s.", guest.getName()));
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
