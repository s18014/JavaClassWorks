package jp.co.example.java15.bookstore.impl.controllers;

import static jp.co.example.java15.bookstore.impl.controllers.ResponseUtil.view;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import jp.co.example.java15.bookstore.impl.services.DummyCartService;
import jp.co.example.java15.bookstore.impl.services.DummyItemService;
import jp.co.example.java15.bookstore.impl.view.CartView;
import jp.co.example.java15.bookstore.impl.view.ItemListView;
import jp.co.example.java15.bookstore.spec.dto.Cart;
import jp.co.example.java15.bookstore.spec.dto.ItemStock;
import jp.co.example.java15.bookstore.spec.services.CartService;


@Path("/jerseymapped/defineduri/java15/bookstore")
@Produces(MediaType.TEXT_HTML)
public class BookStoreController {
	@Context
	private HttpServletRequest request;

	private CartService cartService = new DummyCartService();


	@POST
	@Path("/addCart")
	public Response addCart(@FormParam("item-id") int itemId,
			@FormParam("amount") int amount) {
		return null;
	}


	@GET
	@Path("/showCart")
	public Response showCart() {
		return showCart(new ArrayList<String>());
	}


	@GET
	public Response showList() {
		Iterable<ItemStock> items = (new DummyItemService()).getOnSale();
		return view("/index.jsp", new ItemListView(items));
	}


	private Response showCart(List<String> messages) {
		Cart cart = cartService.getCart("testUser");

		return view("/cart.jsp", new CartView(cart, messages));
	}
}
