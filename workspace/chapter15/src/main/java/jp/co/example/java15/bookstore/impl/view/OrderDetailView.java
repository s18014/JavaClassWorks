package jp.co.example.java15.bookstore.impl.view;

import jp.co.example.java15.bookstore.spec.dto.Order;


public class OrderDetailView {
	private final Order order;


	public OrderDetailView(Order order) {
		this.order = order;
	}


	public Order getOrder() {
		return order;
	}
}
