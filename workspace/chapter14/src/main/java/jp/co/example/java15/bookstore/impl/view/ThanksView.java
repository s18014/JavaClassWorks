package jp.co.example.java15.bookstore.impl.view;

import jp.co.example.java15.bookstore.spec.dto.Cart;


public class ThanksView {
	private final Cart orderedCart;


	public ThanksView(Cart order) {
		this.orderedCart = order;
	}


	public Cart getOrderedCart() {
		return orderedCart;
	}
}
