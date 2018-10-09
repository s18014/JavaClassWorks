package jp.co.example.java15.bookstore.spec.services;

import java.util.List;

import jp.co.example.java15.bookstore.spec.dto.CartItem;
import jp.co.example.java15.bookstore.spec.dto.Item;
import jp.co.example.java15.bookstore.spec.dto.Stock;


public interface OrderService {
	public void order(String userId, String name, String address) throws StockShortageException;


	public static final class StockShortageException extends Exception {
		private static final long serialVersionUID = 1L;
		private final List<StockShortage> stockShortage;


		public StockShortageException(List<StockShortage> shortage) {
			this.stockShortage = shortage;
		}


		public List<StockShortage> getStockShortage() {
			return stockShortage;
		}
	}


	public static final class StockShortage {
		private final Item item;
		private final CartItem originCartItem;
		private final Stock stock;


		public StockShortage(Item item, CartItem originCartItem, Stock stock) {
			this.item = item;
			this.originCartItem = originCartItem;
			this.stock = stock;
		}


		public Item getItem() {
			return item;
		}


		public CartItem getOriginCartItem() {
			return originCartItem;
		}


		public Stock getStock() {
			return stock;
		}
	}
}
