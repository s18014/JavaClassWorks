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


public class MemoryCartService implements CartService {
	/*
	 * このクラスはDummyCartServiceとほとんど同じコードです。
	 * 唯一、このdummyDBインスタンスがサーバ上でひとつだけのMapになります。
	 * そのため、安全に操作する限り、このMapを擬似的なデータベースとしてデータを保存できます。
	 * 
	 * （※ただし、APサーバはたくさんのユーザをサポートするために増設される可能性があり、
	 * その時にデータがばらばらのサーバに存在するようになってしまいます
	 * そのため、このようなプログラムを実際に使ってはいけません）
	 */
	private static final Map<String, Cart> dummyDB = new HashMap<>();
	private ItemService dummyItemDB = new DummyItemService();


	@Override
	public CartAddResult addCart(String userId, int itemId, int amount) {
		List<ItemStock> items = dummyItemDB.getOnSale();
		Cart current = getCart(userId);
		List<CartItem> list = new ArrayList<>();
		int total = 0;

		if (current != null) {
			for (CartItem cartItem : current.getCartItems()) {
				if (cartItem.getItem().getId() == itemId) {
					amount += cartItem.getRelation().getAmount();
				} else {
					list.add(cartItem);
					total += cartItem.getItem().getPrice() * cartItem.getRelation().getAmount();
				}
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

		synchronized (dummyDB) {
			dummyDB.put(userId, new Cart(list, total, true));
		}

		return new CartAddResult(amount, 0, 0, 0, 0);
	}


	@Override
	public Cart getCart(String userId) {
		Cart result;

		synchronized (dummyDB) {
			result = dummyDB.get(userId);
		}

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
		synchronized (dummyDB) {
			dummyDB.remove(userId);
		}
	}
}
