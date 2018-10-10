package jp.co.example.java15.sample_application;

public class Greeter {
	public void login(Account guest) {
		System.out.println(getLoginMessage(guest));
	}

	private String getLoginMessage(Account guest) {
		switch (guest.getCountry()) {
		case JAPAN:
			return String.format("こんにちは、%sさん。", guest.getName());
		case FRANCE:
			return String.format("Bonjour, %s.", guest.getName());
		case GERMANY:
			return String.format("Guten Tag, %s.", guest.getName());
		case USA:
		default:
			return String.format("Hello, %s.", guest.getName());
		}
	}

	public void logout(Account guest) {
		System.out.println(getLogoutMessage(guest));
	}

	private String getLogoutMessage(Account guest) {
		switch (guest.getCountry()) {
		case JAPAN:
			return "さようなら。";
		case FRANCE:
			return "Au revoir.";
		case GERMANY:
			return "Aus Wiedersehen.";
		case USA:
		default:
			return "Goodbye.";
		}
	}

	public void like(Account guest) {
		System.out.println(getThanksMessage(guest));
	}

	private String getThanksMessage(Account guest) {
		switch (guest.getCountry()) {
		case JAPAN:
			return "ありがとうございます。";
		case FRANCE:
			return "Merci beaucoup.";
		case GERMANY:
			return "Danke schon.";
		case USA:
		default:
			return "Thank you.";
		}
	}
}
