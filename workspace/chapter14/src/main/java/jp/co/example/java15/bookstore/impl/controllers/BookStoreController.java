package jp.co.example.java15.bookstore.impl.controllers;

import static jp.co.example.java15.bookstore.impl.controllers.ResponseUtil.redirect;
import static jp.co.example.java15.bookstore.impl.controllers.ResponseUtil.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import jp.co.example.java15.bookstore.impl.services.DummyCartService;
import jp.co.example.java15.bookstore.impl.services.DummyItemService;
import jp.co.example.java15.bookstore.impl.view.CartView;
import jp.co.example.java15.bookstore.impl.view.ItemListView;
import jp.co.example.java15.bookstore.impl.view.OrderView;
import jp.co.example.java15.bookstore.impl.view.StockShortageView;
import jp.co.example.java15.bookstore.impl.view.ThanksView;
import jp.co.example.java15.bookstore.spec.dto.Cart;
import jp.co.example.java15.bookstore.spec.dto.CartAddResult;
import jp.co.example.java15.bookstore.spec.dto.Customer;
import jp.co.example.java15.bookstore.spec.dto.ItemStock;
import jp.co.example.java15.bookstore.spec.services.CartService;
import jp.co.example.java15.bookstore.spec.services.FlashService;
import jp.co.example.java15.bookstore.spec.services.OrderService;
import jp.co.example.java15.bookstore.spec.services.OrderService.StockShortage;
import jp.co.example.java15.bookstore.spec.services.OrderService.StockShortageException;
import jp.co.example.java15.bookstore.spec.services.ServiceFactory;


@Path("/jerseymapped/defineduri/java15/bookstore")
@Produces(MediaType.TEXT_HTML)
public class BookStoreController {
	private HttpServletRequest request;


	private CartService getCartService() {
		return new DummyCartService();
	}


	@POST
	@Path("/addCart")
	public Response addCart(@FormParam("item-id") int itemId,
			@FormParam("amount") int amount) {
		CartService cartService = getCartService();

		CartAddResult result = cartService.addCart("testUser", itemId, amount);
		Cart cart = cartService.getCart("testUser");
		List<String> messages = new ArrayList<>();

		if (result.getOverflowed() > 0) {
			messages.add("カートに入れられる最大数は " + result.getMaxCapacity() + "です。");
		}

		if (result.getShortage() > 0) {
			messages.add("在庫数が " + result.getShortage() + "個 不足しています。");
		}

		return view("/cart.jsp", new CartView(cart, messages));
	}


	private final ServiceFactory serviceFactory;


	public BookStoreController() {
		try {
			serviceFactory = (ServiceFactory) Class.forName(
							"jp.co.example.java15.bookstore.impl.services.DefaultServiceFactory")
					.newInstance();
		} catch (InstantiationException e) {
			throw new IllegalStateException(e);
		} catch (IllegalAccessException e) {
			throw new IllegalStateException(e);
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException(e);
		}
	}


	@POST
	@Path("/clearCart")
	public Response clearCart() {
		String userId = request.getSession().getId();

		getCartService().clear(userId);

		return showCart();
	}


	@POST
	@Path("/order")
	public Response order(@FormParam("name") String name, @FormParam("address") String address ) {
		Map<String, String> messages = OrderValidator.validate(name, address);
		String userId = request.getSession().getId();

		Cart cart = getCartService().getCart(userId);

		if (messages.isEmpty()) {
			OrderService orderService = serviceFactory.getOrderService();
			FlashService flashService = serviceFactory.getFlashService();

			try {
				orderService.order(userId, name, address);
				flashService.put(FlashService.ORDERED_CART, cart);

				return redirect("/jerseymapped/defineduri/java15/bookstore/thanks");
			} catch (StockShortageException e) {
				flashService.put(FlashService.STOCK_SHORTAGE , e.getStockShortage());

				return redirect("/jerseymapped/defineduri/java15/bookstore/stockShortage");
			}
		}

		return view("/order.jsp", new OrderView(cart, new Customer(name, address), messages));
	}


	@GET
	@Path("/prepareOrder")
	public Response prepareOrder() {
		String userId = request.getSession().getId();
		Cart cart = getCartService().getCart(userId);

		if (cart.getTotal() == 0) {
			return redirect("/jerseymapped/defineduri/java15/bookstore/");
		}

		return view("/order.jsp", new OrderView(cart, new Customer("", ""), new HashMap<String, String>()));
	}


	@POST
	@Path("/removeFromCart")
	public Response removeFromCart(@FormParam("item-id") int itemId) {
		getCartService().removeItem("testUser", itemId);

		return showCart(new ArrayList<String>());
	}


	@GET
	@Path("/showCart")
	public Response showCart() {
		return showCart(new ArrayList<String>());
	}


	@GET
	@Path("/")
	public Response showList() {
		Iterable<ItemStock> items = (new DummyItemService()).getOnSale();
		return view("/index.jsp", new ItemListView(items));
	}


	@GET
	@Path("/stockShortage")
	public Response showRecoveredCart() {
		FlashService flashService = serviceFactory.getFlashService();

		@SuppressWarnings("unchecked")
		List<StockShortage> shortage = flashService.get(FlashService.STOCK_SHORTAGE, List.class);

		return view("/stockShortage.jsp", new StockShortageView(shortage));
	}


	@GET
	@Path("/thanks")
	public Response thanks() {
		FlashService flashService = serviceFactory.getFlashService();
		Cart orderHeaderId = flashService.get(FlashService.ORDERED_CART, Cart.class);

		if (orderHeaderId == null) {
			throw new IllegalStateException();
		}

		return view("/thanks.jsp", new ThanksView(orderHeaderId));
	}


	private Response showCart(List<String> messages) {
		String userId = request.getSession().getId();
		Cart cart = getCartService().getCart(userId);

		return view("/cart.jsp", new CartView(cart, messages));
	}
}
