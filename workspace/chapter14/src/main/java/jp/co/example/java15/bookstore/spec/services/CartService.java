package jp.co.example.java15.bookstore.spec.services;

import jp.co.example.java15.bookstore.spec.dto.Cart;
import jp.co.example.java15.bookstore.spec.dto.CartAddResult;


public interface CartService {
	public CartAddResult addCart(String userId, int itemId, int amount);
	public Cart getCart(String userId);
	public void removeItem(String userId, int itemId);
	public void clear(String userId);
}
