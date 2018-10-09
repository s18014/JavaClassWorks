package jp.co.example.java15.bookstore.impl.view;

import jp.co.example.java15.bookstore.spec.dto.ItemStock;


public class ItemListView {
	private final Iterable<ItemStock> items;


	public ItemListView(Iterable<ItemStock> items) {
		this.items = items;
	}


	public Iterable<ItemStock> getItems() {
		return items;
	}
}
