package jp.co.example.java15.sample_application;

class PurchaseManagerFactory {
	public static PurchaseManager getManager(Account guest) {
		switch (guest.getCountry()) {
		case JAPAN:
			return new JapanesePurchaseManager();
		case FRANCE:
			return new FrenchPurchaseManager();
		case GERMANY:
			return new GermanPurchaseManager();
		case USA:
		default:
			return new EnglishPurchaseManager();
		}
	}
}
