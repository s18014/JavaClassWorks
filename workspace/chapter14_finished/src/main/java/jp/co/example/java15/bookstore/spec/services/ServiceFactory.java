package jp.co.example.java15.bookstore.spec.services;


public interface ServiceFactory {
	public CartService getCartService();
	public ItemService getItemService();
	public OrderService getOrderService();
	public ManageOrderService getManageOrderService();
	public FlashService getFlashService();
}
