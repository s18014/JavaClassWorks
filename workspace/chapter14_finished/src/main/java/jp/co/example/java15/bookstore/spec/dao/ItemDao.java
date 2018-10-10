package jp.co.example.java15.bookstore.spec.dao;

import java.io.IOException;
import java.util.List;

import jp.co.example.java15.bookstore.spec.dto.Item;


public interface ItemDao {
	public Item find(Transaction transaction, int id) throws IOException;
	public List<Item> getAllOrderdById(Transaction transaction) throws IOException;
}
