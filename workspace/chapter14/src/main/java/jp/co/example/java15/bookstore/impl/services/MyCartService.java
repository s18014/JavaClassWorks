package jp.co.example.java15.bookstore.impl.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jp.co.example.java15.bookstore.impl.services.shared.CartGetter;
import jp.co.example.java15.bookstore.spec.dao.CartItemRelationDao;
import jp.co.example.java15.bookstore.spec.dao.ItemDao;
import jp.co.example.java15.bookstore.spec.dao.StockDao;
import jp.co.example.java15.bookstore.spec.dao.Transaction;
import jp.co.example.java15.bookstore.spec.dto.Cart;
import jp.co.example.java15.bookstore.spec.dto.CartAddResult;
import jp.co.example.java15.bookstore.spec.services.CartService;


public class MyCartService implements CartService {
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
			// TODO cartDao から現在のユーザのカートを取り出しましょう
			// TODO 既存のアイテムの場合には数を増やしましょう
			// TODO カート内に 9 個以上追加できないようにしましょう
			// TODO 価格を再計算しましょう
			// TODO 新規のアイテムの場合には追加しましょう

			transaction.commit();

			return null;
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
		// TODO
	}


	@Override
	public void clear(String userId) {
		// TODO
	}
}
