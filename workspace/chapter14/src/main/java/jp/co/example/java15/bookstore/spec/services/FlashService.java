package jp.co.example.java15.bookstore.spec.services;


public interface FlashService {
	public static final String ORDERED_CART = "orderedCart";
	public static final String STOCK_SHORTAGE = "stockShortage";


	public void put(String key, Object obj);
	public <T> T get(String key, Class<T> klass);
}
