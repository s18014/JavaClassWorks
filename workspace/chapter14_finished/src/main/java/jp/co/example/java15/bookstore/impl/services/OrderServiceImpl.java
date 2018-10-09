package jp.co.example.java15.bookstore.impl.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jp.co.example.java15.bookstore.impl.services.shared.CartClearer;
import jp.co.example.java15.bookstore.impl.services.shared.CartGetter;
import jp.co.example.java15.bookstore.spec.dao.CartItemRelationDao;
import jp.co.example.java15.bookstore.spec.dao.ItemDao;
import jp.co.example.java15.bookstore.spec.dao.OrderDetailDao;
import jp.co.example.java15.bookstore.spec.dao.OrderHeaderDao;
import jp.co.example.java15.bookstore.spec.dao.StockDao;
import jp.co.example.java15.bookstore.spec.dao.Transaction;
import jp.co.example.java15.bookstore.spec.dto.Cart;
import jp.co.example.java15.bookstore.spec.dto.CartItem;
import jp.co.example.java15.bookstore.spec.dto.OrderDetail;
import jp.co.example.java15.bookstore.spec.dto.OrderHeader;
import jp.co.example.java15.bookstore.spec.dto.Stock;
import jp.co.example.java15.bookstore.spec.services.OrderService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class OrderServiceImpl implements OrderService {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	private final OrderHeaderDao orderHeaderDao;
	private final OrderDetailDao orderDetailDao;
	private final StockDao stockDao;
	private final CartItemRelationDao cartDao;
	private final ItemDao itemDao;
	private final Transaction transaction;


	public OrderServiceImpl(OrderHeaderDao orderHeaderDao,
			OrderDetailDao orderDetailDao, StockDao stockDao,
			CartItemRelationDao cartDao, ItemDao itemDao,
			Transaction transaction) {
		super();
		this.orderHeaderDao = orderHeaderDao;
		this.orderDetailDao = orderDetailDao;
		this.stockDao = stockDao;
		this.cartDao = cartDao;
		this.itemDao = itemDao;
		this.transaction = transaction;
	}


	@Override
	public void order(String userId, String name, String address) throws StockShortageException{
		try {
			transaction.begin();

			Cart cart = new CartGetter(cartDao, itemDao).getCart(transaction, userId);

			List<StockCartItemRelation> locked = getStockWithLock(cart);
			List<StockCartItemRelation> shortages = checkShortage(userId, locked);

			if (!shortages.isEmpty()) {
				List<StockShortage> stockShortages = reduceCartItemAmount(userId, cart, shortages);
				transaction.commit();
				throw new StockShortageException(stockShortages);
			}

			reduceStock(locked);
			issueOrder(locked, cart, name, address);

			new CartClearer(cartDao).clear(transaction, userId);

			transaction.commit();
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


	private static final class StockCartItemRelation {
		private final Stock stock;
		private final CartItem cartItem;

		public StockCartItemRelation(Stock stock, CartItem cartItem) {
			this.stock = stock;
			this.cartItem = cartItem;
		}
	}


	private List<StockCartItemRelation> getStockWithLock(Cart cart) throws IOException {
		Map<Integer, CartItem> idList = new HashMap<>();

		for (CartItem cartItem : cart.getCartItems()) {
			idList.put(cartItem.getItem().getId(), cartItem);
		}

		List<Stock> stocks = stockDao.findByItemIdWithLock(transaction, idList.keySet());
		List<StockCartItemRelation> locked = new ArrayList<StockCartItemRelation>();

		for (Stock stock : stocks) {
			locked.add(new StockCartItemRelation(stock, idList.get(stock.getItemId())));
		}

		return locked;
	}


	private List<StockCartItemRelation> checkShortage(String userId, List<StockCartItemRelation> stocks) {
		List<StockCartItemRelation> shortageList = new ArrayList<OrderServiceImpl.StockCartItemRelation>();

		for (StockCartItemRelation stockCartRelation : stocks) {
			if (stockCartRelation.stock.getStock() < stockCartRelation.cartItem.getRelation().getAmount()) {
				shortageList.add(stockCartRelation);
			}
		}

		return shortageList;
	}


	private List<StockShortage> reduceCartItemAmount(String userId, Cart cart,
			List<StockCartItemRelation> shortageList) throws IOException {
		List<StockShortage> result = new ArrayList<OrderService.StockShortage>();

		for (StockCartItemRelation shortage : shortageList) {
			result.add(new StockShortage(shortage.cartItem.getItem(), shortage.cartItem, shortage.stock));

			if (shortage.stock.getStock() <= 0) {
				cartDao.remove(transaction, userId, shortage.stock.getItemId());
				continue;
			}

			cartDao.updateAmount(transaction, userId, shortage.stock.getItemId(), shortage.stock.getStock());
		}

		return result;
	}


	private void reduceStock(List<StockCartItemRelation> locked) throws IOException {
		for (StockCartItemRelation stockCartItemRelation : locked) {
			stockDao.updateStock(transaction,
					stockCartItemRelation.stock.getItemId(),
					stockCartItemRelation.stock.getStock() - stockCartItemRelation.cartItem.getRelation().getAmount());
			
		}
	}


	private void issueOrder(List<StockCartItemRelation> locked, Cart cart, String name, String address) throws IOException {
		int orderHeaderId = orderHeaderDao.getSequence(transaction);
		orderHeaderDao.create(transaction, new OrderHeader(orderHeaderId, cart.getTotal(), name, address));

		List<OrderDetail> orderDetails = new ArrayList<>();

		for (StockCartItemRelation stockCartItemRelation : locked) {
			orderDetails.add(new OrderDetail(
					orderHeaderId, stockCartItemRelation.stock.getItemId(),
					stockCartItemRelation.cartItem.getRelation().getAmount()));
		}

		orderDetailDao.create(transaction, orderDetails);
	}
}