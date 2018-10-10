package jp.co.example.java15.bookstore.impl.services.shared;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jp.co.example.java15.bookstore.spec.dao.CartItemRelationDao;
import jp.co.example.java15.bookstore.spec.dao.ItemDao;
import jp.co.example.java15.bookstore.spec.dao.Transaction;
import jp.co.example.java15.bookstore.spec.dto.Cart;
import jp.co.example.java15.bookstore.spec.dto.CartItem;
import jp.co.example.java15.bookstore.spec.dto.CartItemRelation;


public class CartGetter {
	private final CartItemRelationDao cartDao;
	private final ItemDao itemDao;


	public CartGetter(CartItemRelationDao cartDao, ItemDao itemDao) {
		this.cartDao = cartDao;
		this.itemDao = itemDao;
	}


	public Cart getCart(Transaction transaction, String userId) {
		try {
			Iterable<CartItemRelation> relations = cartDao.findByUserId(transaction, userId);
			List<CartItem> cartItems = new ArrayList<>();

			for (CartItemRelation relation : relations) {
				cartItems.add(
						new CartItem(relation, itemDao.find(transaction, relation.getItemId())));
			}

			boolean valid = true;
			int total = 0;

			for (CartItem cartItem : cartItems) {
				total += cartItem.getItem().getPrice()
						* cartItem.getRelation().getAmount();
				valid = valid && cartItem.getRelation().getAmount() > 0;
			}

			return new Cart(cartItems, total, valid);
		} catch (IOException e) {
			throw new IllegalStateException(e);
		}
	}
}
