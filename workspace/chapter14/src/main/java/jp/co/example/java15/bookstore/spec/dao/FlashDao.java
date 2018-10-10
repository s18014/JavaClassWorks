package jp.co.example.java15.bookstore.spec.dao;


public interface FlashDao {
	public void put(String key, Object val);
	public <T> T get(String key, Class<T> klass);
}
