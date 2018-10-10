package jp.co.example.java15.bookstore.impl.services.shared;

import java.io.IOException;

import jp.co.example.java15.bookstore.spec.dao.CartItemRelationDao;
import jp.co.example.java15.bookstore.spec.dao.Transaction;


public class CartClearer {
	private final CartItemRelationDao cartDao;


	public CartClearer(CartItemRelationDao cartDao) {
		this.cartDao = cartDao;
	}


	public void clear(Transaction transaction, String userId) {
		try {
			cartDao.removeByUserId(transaction, userId);
		} catch (IOException e) {
			throw new IllegalStateException(e);
		}
	}
}
