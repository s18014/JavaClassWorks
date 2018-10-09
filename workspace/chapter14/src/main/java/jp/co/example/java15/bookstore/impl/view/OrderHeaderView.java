package jp.co.example.java15.bookstore.impl.view;

import java.util.List;

import jp.co.example.java15.bookstore.spec.dto.OrderHeader;


public class OrderHeaderView {
	private final List<OrderHeader> headers;


	public OrderHeaderView(List<OrderHeader> headers) {
		this.headers = headers;
	}


	public List<OrderHeader> getHeaders() {
		return headers;
	}
}
