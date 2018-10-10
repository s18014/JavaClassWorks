package jp.co.example.java15.bookstore.impl.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import jp.co.example.java15.bookstore.spec.dao.ItemDao;
import jp.co.example.java15.bookstore.spec.dao.StockDao;
import jp.co.example.java15.bookstore.spec.dao.Transaction;
import jp.co.example.java15.bookstore.spec.dto.Item;
import jp.co.example.java15.bookstore.spec.dto.ItemStock;
import jp.co.example.java15.bookstore.spec.dto.Stock;
import jp.co.example.java15.bookstore.spec.services.ItemService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ItemServiceImpl implements ItemService {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	private final ItemDao itemDao;
	private final StockDao stockDao;
	private final Transaction transaction;


	public ItemServiceImpl(Transaction transaction, ItemDao itemDao, StockDao stockDao) {
		this.itemDao = itemDao;
		this.stockDao = stockDao;
		this.transaction = transaction;
	}


	@Override
	public List<ItemStock> getOnSale() {
		return filterItemStock(findItemStock());
	}


	private List<ItemStock> filterItemStock(List<ItemStock> target) {
		Iterator<ItemStock> it = target.iterator();

		for (;it.hasNext();) {
			ItemStock itemStock = it.next();

			if (itemStock.getItem().getReleaseDate().after(new Date())) {
				it.remove();
				continue;
			}
		}

		return target;
	}


	private List<ItemStock> findItemStock() {
		try {
			transaction.begin();

			Iterable<Item> items = itemDao.getAllOrderdById(transaction);
			Iterator<Stock> stocks = stockDao.getAllOrderedByItemId(transaction).iterator();

			List<ItemStock> itemStocks = new ArrayList<ItemStock>();

			Stock currentStock = stocks.hasNext() ? stocks.next() : null;

			for (Item item : items) {
				if (currentStock == null) {
					break;
				}

				while(currentStock != null) {
					if (currentStock.getItemId() > item.getId()) {
						break;
					}

					if (currentStock.getItemId() < item.getId()) {
						currentStock = stocks.hasNext() ? stocks.next() : null;
						continue;
					}

					if (currentStock.getItemId() == item.getId()) {
						itemStocks.add(new ItemStock(item, currentStock));
						currentStock = stocks.hasNext() ? stocks.next() : null;
					}
				}
			}

			transaction.commit();

			return itemStocks;
		} catch (IOException e) {
			throw new IllegalStateException(e);
		} finally {
			if (transaction.isActive()) {
				try {
					transaction.rollback();
				} catch (RuntimeException e) {
					logger.warn(e.getMessage(),e);
				}
			}
		}
	}
}
