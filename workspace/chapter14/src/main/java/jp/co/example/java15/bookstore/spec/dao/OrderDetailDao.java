package jp.co.example.java15.bookstore.spec.dao;

import java.io.IOException;
import java.util.List;

import jp.co.example.java15.bookstore.spec.dto.OrderDetail;


public interface OrderDetailDao {
	public void create(Transaction transaction, List<OrderDetail> orderDetails) throws IOException;
	public List<OrderDetail> findByHeaderId(Transaction transaction, int orderHeaderId) throws IOException;
}
