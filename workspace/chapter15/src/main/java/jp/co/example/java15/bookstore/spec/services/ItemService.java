package jp.co.example.java15.bookstore.spec.services;

import java.util.List;

import jp.co.example.java15.bookstore.spec.dto.ItemStock;


public interface ItemService {
	public List<ItemStock> getOnSale();
}
