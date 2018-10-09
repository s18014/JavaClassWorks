<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<c:import url="/WEB-INF/jsp/common/htmlheader.jsp" />
</head>

<body>
	<c:import url="/WEB-INF/jsp/common/header.jsp" />

	<c:url value="/jerseymapped/defineduri/java15/bookstore" var="root"/>
	<div class="container">
		<c:forEach var="itemStock" items="${it.items}" varStatus="status">
		<div class="row">
			<div class="col-md-2">
				<img src="<c:url value="${itemStock.item.picture}" />" id="itemImage-<c:out value="${itemStock.item.id}"/>" class="img-rounded"/>
			</div>
			<div class="col-md-9 col-md-offset-1">
				<div>
					<h2 id="itemName-<c:out value="${itemStock.item.id}"/>"><c:out value="${itemStock.item.name}"/></h2>
				</div>

				<div id="itemPrice-<c:out value="${itemStock.item.id}"/>">
					<c:out value="${itemStock.item.price}" /> YEN
				</div>

				<c:if test="${itemStock.stock.stock > 0}">
				<div>
					<form id="form-<c:out value="${itemStock.item.id}"/>" class="form-inline" action="${root}/addCart" method="POST">
						<input type="hidden" name="item-id" value="<c:out value="${itemStock.item.id}"/>" />
						<select name="amount" class="form-control" id="itemAmount-<c:out value="${itemStock.item.id}"/>">
							<c:forEach begin="1" end="9" step="1" varStatus="status">
							<c:if test="${status.count <= itemStock.stock.stock}" >
							<option value="${status.count}"><c:out value="${status.count}" /></option>
							</c:if>
							</c:forEach>
						</select>
						<button class="btn" type="submit" id="itemAddCart-<c:out value="${itemStock.item.id}"/>">カートに追加</button>
					</form>
				</div>
				</c:if>
			</div>
		</div>
		</c:forEach>

		<div class="row">
			<a class="btn" href="${root}/showCart" id="showCart">カートを確認</a>
		</div>
	</div>

	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
	<script type="text/javascript" src="<c:url value="/bootstrap/js/bootstrap.min.js"/>"></script>
</body>
</html>