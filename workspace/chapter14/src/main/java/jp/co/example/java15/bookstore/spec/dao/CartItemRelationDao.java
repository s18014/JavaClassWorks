package jp.co.example.java15.bookstore.spec.dao;

import java.io.IOException;
import java.util.List;

import jp.co.example.java15.bookstore.spec.dto.CartItemRelation;


public interface CartItemRelationDao {
	public CartItemRelation findByUserIdAndItemId(Transaction transaction, String userId, int itemId) throws IOException;
	public void create(Transaction transaction, CartItemRelation item) throws IOException;
	public void updateAmount(Transaction transaction, String userId, int itemId, int newAmount) throws IOException;
	public List<CartItemRelation> findByUserId(Transaction transaction, String userId) throws IOException;
	public void remove(Transaction transaction, String userId, int itemId) throws IOException;
	public void removeByUserId(Transaction transaction, String userId) throws IOException;
}
