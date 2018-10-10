package jp.co.example.java15.bookstore.impl.controllers;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import jp.co.example.java15.bookstore.impl.view.WelcomeView;

@Path("/jerseymapped/defineduri/java15/hello")
public class Java15Controller {
	@GET
	public Response welcome() {
		return ResponseUtil.view("/welcome.jsp", new WelcomeView("Hello world!"));
	}
}
