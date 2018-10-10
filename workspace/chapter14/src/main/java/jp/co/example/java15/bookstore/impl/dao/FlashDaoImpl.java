package jp.co.example.java15.bookstore.impl.dao;

import java.util.Hashtable;
import java.util.Map;

import jp.co.example.java15.bookstore.spec.dao.FlashDao;


public class FlashDaoImpl implements FlashDao {
	private static final Map<String, Object> store = new Hashtable<>();


	@Override
	public void put(String key, Object val) {
		store.put(key, val);
	}


	@Override
	public <T> T get(String key, Class<T> klass) {
		@SuppressWarnings("unchecked")
		T remove = (T) store.remove(key);
		return remove;
	}
}
