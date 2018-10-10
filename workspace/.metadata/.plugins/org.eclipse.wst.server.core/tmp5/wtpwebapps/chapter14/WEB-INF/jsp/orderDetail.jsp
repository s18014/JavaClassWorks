<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<c:import url="/WEB-INF/jsp/common/htmlheader.jsp" />
</head>

<body>
	<c:import url="/WEB-INF/jsp/common/header.jsp" />

	<c:url value="/jerseymapped/defineduri/java15/administrator" var="root"/>
	<div class="container">
		<div>
			<table id="order-customer-table">
				<tr>
					<th>Total</th>
					<th>Name</th>
					<th>Address</th>
				</tr>
				<tr>
					<td><c:out value="${it.order.header.total }"/></td>
					<td><c:out value="${it.order.header.name }"/></td>
					<td><c:out value="${it.order.header.address }"/></td>
				</tr>
			</table>
		</div>
		<div>
			<table id="order-item-table">
				<tr>
					<th>Item Id</th>
					<th>Amount</th>
				</tr>
				<c:forEach var="orderDetail" items="${it.order.detail}" varStatus="status">
				<tr>
					<td><c:out value="${orderDetail.itemId}"/></td>
					<td><c:out value="${orderDetail.amount}"/></td>
				</tr>
				</c:forEach>
			</table>
		</div>
		<div>
			<a class="btn" href="${root}/orderHeader" id="show-order-header">Order Header List</a>
		</div>
	</div>

	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
	<script type="text/javascript" src="<c:url value="/bootstrap/js/bootstrap.min.js"/>"></script>
</body>
</html>