package jp.co.example.java15.bookstore.impl.services;

import jp.co.example.java15.bookstore.spec.dao.FlashDao;
import jp.co.example.java15.bookstore.spec.services.FlashService;


public class FlashServiceImpl implements FlashService {
	private final FlashDao flashDao;


	public FlashServiceImpl(FlashDao flashDao) {
		this.flashDao = flashDao;
	}


	@Override
	public void put(String key, Object obj) {
		flashDao.put(key, obj);
	}


	@Override
	public <T> T get(String key, Class<T> klass) {
		return flashDao.get(key, klass);
	}
}
