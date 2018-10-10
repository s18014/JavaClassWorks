package jp.co.example.java15.bookstore.impl.controllers;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/jerseymapped/defineduri/java15/hello")
public class Java15Controller {
	@GET
	public Response welcome() {
		// TODO welcome ページを作成する
		return ResponseUtil.view("/welcome.jsp", null);
	}
}
