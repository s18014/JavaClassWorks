package jp.co.example.java15.sample_application;

class GreeterFactory {
	public static Greeter getGreeter(Account guest) {
		switch (guest.getCountry()) {
		case JAPAN:
			return new JapaneseGreeter();
		case FRANCE:
			return new FrenchGreeter();
		case GERMANY:
			return new GermanGreeter();
		case USA:
		default:
			return new EnglishGreeter();
		}
	}
}
