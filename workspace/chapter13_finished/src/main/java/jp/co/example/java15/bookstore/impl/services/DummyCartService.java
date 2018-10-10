package jp.co.example.java15.bookstore.impl.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jp.co.example.java15.bookstore.spec.dto.Cart;
import jp.co.example.java15.bookstore.spec.dto.CartAddResult;
import jp.co.example.java15.bookstore.spec.dto.CartItem;
import jp.co.example.java15.bookstore.spec.dto.CartItemRelation;
import jp.co.example.java15.bookstore.spec.dto.ItemStock;
import jp.co.example.java15.bookstore.spec.services.CartService;
import jp.co.example.java15.bookstore.spec.services.ItemService;


public class DummyCartService implements CartService {
	private final Map<String, Cart> dummyDB = new HashMap<>();
	private final ItemService dummyItemDB = new DummyItemService();


	@Override
	public CartAddResult addCart(String userId, int itemId, int amount) {
		List<ItemStock> items = dummyItemDB.getOnSale();
		Cart current = getCart(userId);
		List<CartItem> list = new ArrayList<>();
		int total = 0;

		for (CartItem cartItem : current.getCartItems()) {
			if (cartItem.getItem().getId() == itemId) {
				amount += cartItem.getRelation().getAmount();
			} else {
				list.add(cartItem);
				total += cartItem.getItem().getPrice() * cartItem.getRelation().getAmount();
			}
		}

		for (ItemStock stock : items) {
			if (stock.getItem().getId() == itemId) {
				CartItemRelation relation = new CartItemRelation(userId, itemId, amount);
				CartItem item = new CartItem(relation, stock.getItem());

				total += item.getItem().getPrice() * amount;
				list.add(item);
				break;
			}
		}

		dummyDB.put(userId, new Cart(list, total, true));

		return new CartAddResult(amount, 0, 0, 0, 0);
	}


	@Override
	public Cart getCart(String userId) {
		Cart result = dummyDB.get(userId);

		if (result == null) {
			result = new Cart(Collections.<CartItem> emptyList(), 0, true);
		}

		return result;
	}


	@Override
	public void removeItem(String userId, int itemId) {
		// TODO Auto-generated method stub
	}


	@Override
	public void clear(String userId) {
		dummyDB.remove(userId);
	}
}
