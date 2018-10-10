package jp.co.example.java15.bookstore.impl.services;

import java.util.ArrayList;
import java.util.List;

import jp.co.example.java15.bookstore.spec.dto.Item;
import jp.co.example.java15.bookstore.spec.dto.ItemStock;
import jp.co.example.java15.bookstore.spec.dto.Stock;
import jp.co.example.java15.bookstore.spec.services.ItemService;


public class DummyItemService implements ItemService {
	private final List<ItemStock> dummyStock = new ArrayList<>();


	public DummyItemService() {
		dummyStock.add(new ItemStock(
				new Item(1, "パーフェクトJava", 3456, "/images/9784774139906.jpg", null),
				new Stock(1, 20)));
		dummyStock.add(new ItemStock(
				new Item(2, "パーフェクトPython", 3456, "/images/TH160_9784774155395.jpg", null),
				new Stock(2, 8)));
	}


	@Override
	public List<ItemStock> getOnSale() {
		return dummyStock;
	}
}
