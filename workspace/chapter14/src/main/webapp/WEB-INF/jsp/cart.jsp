<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<c:import url="/WEB-INF/jsp/common/htmlheader.jsp" />
</head>

<body>
	<c:import url="/WEB-INF/jsp/common/header.jsp" />

	<c:url value="/jerseymapped/defineduri/java15/bookstore" var="root"/>
	<div class="container">
		<c:forEach var="message" items="${it.messages}" varStatus="status">
			<p class="bg-danger">
				<c:out value="${message}"/>
			</p>
		</c:forEach>

		<c:if test="${fn:length(it.cart.cartItems) > 0}">
		<c:forEach var="cartItem" items="${it.cart.cartItems}" varStatus="status">
		<div class="row">
			<div class="col-md-2">
				<img src="<c:url value="${cartItem.item.picture}" />" id="itemImage-<c:out value="${cartItem.item.id}"/>">
			</div>
			<div class="col-md-8">
				<div id="itemName-<c:out value="${cartItem.item.id}"/>">
					<h2><c:out value="${cartItem.item.name }"/></h2>
				</div>
				<div id="itemPrice-<c:out value="${cartItem.item.id}"/>">
					価格 : <c:out value="${cartItem.item.price }"/> 円
				</div>
				<div id="itemAmount-<c:out value="${cartItem.item.id}"/>">
					数量 : <c:out value="${cartItem.relation.amount }"/> 個
				</div>
				<form id="form-clear-<c:out value="${cartItem.item.id}"/>" action="${root}/removeFromCart" method="POST">
					<input type="hidden" name="item-id" value="<c:out value="${cartItem.item.id}"/>" id="itemId-<c:out value="${cartItem.item.id}"/>">
					<input class="btn" type="submit" value="取消" id="itemCancelButton-<c:out value="${cartItem.item.id}"/>">
				</form>
			</div>
		</div>
		</c:forEach>

		<div class="row">
			<h2>合計</h2>

			<div id="totalPrice-<c:out value="${cartItem.item.id}"/>">
				<c:out value="${it.cart.total}"/> 円
			</div>
		</div>

		<div class="row">
			<div class="col-md-2">
				<form id="form-clear-cart" action="${root}/clearCart" method="POST">
					<input class="btn" type="submit" value="カートをクリア" id="celarCartButton">
				</form>
			</div>

			<c:if test="${it.cart.valid}">
			<div class="col-md-2">
				<a class="btn" href="${root}/prepareOrder" id="purchaseButton">購入画面へ進む</a>
			</div>
			</c:if>
		</div>
		</c:if>

		<c:if test="${fn:length(it.cart.cartItems) <= 0}">
		<h2 id="emptyCartTitle">カートは空です</h2>
		</c:if>

		<div class="row">
			<div class="col-md-2">
				<a class="btn" href="${root}" id="gotoItemListButton">買い物を続ける</a>
			</div>
		</div>
	</div>

	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
	<script type="text/javascript" src="<c:url value="/bootstrap/js/bootstrap.min.js"/>"></script>
</body>
</html>