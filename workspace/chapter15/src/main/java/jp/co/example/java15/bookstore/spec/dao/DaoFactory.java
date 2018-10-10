package jp.co.example.java15.bookstore.spec.dao;


public interface DaoFactory {
	public CartItemRelationDao getCartItemRelationDao();
	public ItemDao getItemDao();
	public StockDao getStockDao();
	public OrderHeaderDao getOrderHeaderDao();
	public OrderDetailDao getOrderDetailDao();
	public Transaction getTransaction();
	public FlashDao getFlashDao();
}
