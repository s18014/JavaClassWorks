package jp.co.example.java15.sample_application;

public class FrenchGreeter implements Greeter {
	@Override
	public void login(Account guest) {
		System.out.println(String.format("Bonjour, %s.", guest.getName()));
	}

	@Override
	public void logout(Account guest) {
		System.out.println("Au revoir.");
	}

	@Override
	public void like(Account guest) {
		System.out.println("Merci beaucoup.");
	}

}
