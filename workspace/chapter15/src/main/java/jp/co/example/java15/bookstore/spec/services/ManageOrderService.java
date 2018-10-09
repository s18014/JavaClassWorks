package jp.co.example.java15.bookstore.spec.services;

import java.util.List;

import jp.co.example.java15.bookstore.spec.dto.Order;
import jp.co.example.java15.bookstore.spec.dto.OrderHeader;


public interface ManageOrderService {
	public List<OrderHeader> getOrderHeaders();
	public Order getOrder(int orderId);
}
