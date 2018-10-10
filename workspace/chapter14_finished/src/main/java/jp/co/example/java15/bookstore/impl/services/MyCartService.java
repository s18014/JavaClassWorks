package jp.co.example.java15.bookstore.impl.services;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jp.co.example.java15.bookstore.impl.services.shared.CartGetter;
import jp.co.example.java15.bookstore.spec.dao.CartItemRelationDao;
import jp.co.example.java15.bookstore.spec.dao.ItemDao;
import jp.co.example.java15.bookstore.spec.dao.StockDao;
import jp.co.example.java15.bookstore.spec.dao.Transaction;
import jp.co.example.java15.bookstore.spec.dto.Cart;
import jp.co.example.java15.bookstore.spec.dto.CartAddResult;
import jp.co.example.java15.bookstore.spec.dto.CartItemRelation;
import jp.co.example.java15.bookstore.spec.services.CartService;


public class MyCartService implements CartService {
	private static final int CART_MAX_AMOUNT = 9;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	private final CartItemRelationDao cartDao;
	private final ItemDao itemDao;
	private final StockDao stockDao;
	private final Transaction transaction;


	public MyCartService(Transaction transaction, CartItemRelationDao cartDao, ItemDao itemDao, StockDao stockDao) {
		this.cartDao = cartDao;
		this.itemDao = itemDao;
		this.transaction = transaction;
		this.stockDao = stockDao;
	}


	@Override
	public CartAddResult addCart(String userId, int itemId, int amount) {
		try {
			transaction.begin();

			// TODO itemId が存在するか確認しましょう
			// TODO 在庫が十分に残っているか確認できるようにしましょう

			CartItemRelation cartItem = cartDao.findByUserIdAndItemId(transaction, userId, itemId);

			int newAmount = amount;
			int overflowed = 0;

			if (cartItem != null) {
				newAmount = newAmount + cartItem.getAmount();
			}

			if (newAmount > CART_MAX_AMOUNT) {
				overflowed = newAmount - CART_MAX_AMOUNT;
				newAmount = CART_MAX_AMOUNT;
			}

			CartAddResult result = new CartAddResult(newAmount, overflowed, 0, amount, newAmount);

			if (cartItem == null) {
				cartDao.create(transaction, new CartItemRelation(userId, itemId, result.getNewAmount()));
			} else {
				cartDao.updateAmount(transaction, userId, itemId, result.getNewAmount());
			}

			transaction.commit();

			return null;
		} catch (IOException e) {
			throw new IllegalStateException(e);
		} finally {
			if (transaction.isActive()) {
				try {
					transaction.rollback();
				} catch(RuntimeException e) {
					logger.warn(e.getMessage(),e);
				}
			}
		}
	}


	@Override
	public Cart getCart(String userId) {
		try {
			transaction.begin();

			Cart cart = new CartGetter(cartDao, itemDao).getCart(transaction, userId);

			transaction.commit();
			return cart;
		} finally {
			if (transaction.isActive()) {
				try {
					transaction.rollback();
				} catch(RuntimeException e) {
					logger.warn(e.getMessage(),e);
				}
			}
		}
	}


	@Override
	public void removeItem(String userId, int itemId) {
		try {
			transaction.begin();

			cartDao.remove(transaction, userId, itemId);

			transaction.commit();
		} catch (IOException e) {
			throw new IllegalStateException(e);
		} finally {
			if (transaction.isActive()) {
				try {
					transaction.rollback();
				} catch(RuntimeException e) {
					logger.warn(e.getMessage(),e);
				}
			}
		}
	}


	@Override
	public void clear(String userId) {
		// TODO
	}
}
