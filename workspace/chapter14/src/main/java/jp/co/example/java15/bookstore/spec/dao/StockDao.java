package jp.co.example.java15.bookstore.spec.dao;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import jp.co.example.java15.bookstore.spec.dto.Stock;


public interface StockDao {
	public List<Stock> getAllOrderedByItemId(Transaction transaction) throws IOException;
	public List<Stock> findByItemIdWithLock(Transaction transaction, Set<Integer> idList) throws IOException;
	public void updateStock(Transaction transaction, int itemId, int newStock) throws IOException;
	public Stock find(Transaction transaction, int itemId) throws IOException;
}
