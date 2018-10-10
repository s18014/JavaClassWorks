package jp.co.example.java15.bookstore.impl.view;

import java.util.List;

import jp.co.example.java15.bookstore.spec.services.OrderService.StockShortage;


public class StockShortageView {
	private final List<StockShortage> stockShortages;


	public StockShortageView(List<StockShortage> stockShortage) {
		this.stockShortages = stockShortage;
	}


	public List<StockShortage> getStockShortages() {
		return stockShortages;
	}
}
