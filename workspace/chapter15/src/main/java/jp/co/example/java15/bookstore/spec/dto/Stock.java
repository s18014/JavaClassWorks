package jp.co.example.java15.bookstore.spec.dto;


public class Stock {
	private final int itemId;
	private final int stock;


	public Stock(int itemId, int stock) {
		this.itemId = itemId;
		this.stock = stock;
	}


	public int getItemId() {
		return itemId;
	}


	public int getStock() {
		return stock;
	}
}
