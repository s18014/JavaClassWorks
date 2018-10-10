package jp.co.example.java15.bookstore.impl.dao;

import jp.co.example.java15.bookstore.spec.dao.CartItemRelationDao;
import jp.co.example.java15.bookstore.spec.dao.DaoFactory;
import jp.co.example.java15.bookstore.spec.dao.FlashDao;
import jp.co.example.java15.bookstore.spec.dao.ItemDao;
import jp.co.example.java15.bookstore.spec.dao.OrderDetailDao;
import jp.co.example.java15.bookstore.spec.dao.OrderHeaderDao;
import jp.co.example.java15.bookstore.spec.dao.StockDao;
import jp.co.example.java15.bookstore.spec.dao.Transaction;


public class DefaultDaoFactory implements DaoFactory {
	public DefaultDaoFactory() {}


	@Override
	public CartItemRelationDao getCartItemRelationDao() {
		return new CartItemRelationDaoImpl();
	}


	@Override
	public ItemDao getItemDao() {
		return new ItemDaoImpl();
	}


	@Override
	public StockDao getStockDao() {
		return new StockDaoImpl();
	}


	@Override
	public Transaction getTransaction() {
		return new TransactionImpl();
	}


	@Override
	public OrderHeaderDao getOrderHeaderDao() {
		return new OrderHeaderDaoImpl();
	}


	@Override
	public OrderDetailDao getOrderDetailDao() {
		return new OrderDetailDaoImpl();
	}


	@Override
	public FlashDao getFlashDao() {
		return new FlashDaoImpl();
	}
}
