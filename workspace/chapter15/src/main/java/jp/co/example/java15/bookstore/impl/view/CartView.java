package jp.co.example.java15.bookstore.impl.view;

import java.util.List;

import jp.co.example.java15.bookstore.spec.dto.Cart;


public class CartView {
	private final Cart cart;
	private final List<String> messages;


	public CartView(Cart cart, List<String> message) {
		this.cart = cart;
		this.messages = message;
	}


	public Cart getCart() {
		return cart;
	}


	public List<String> getMessages() {
		return messages;
	}
}
