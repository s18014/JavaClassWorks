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
		<table id="order-header-table">
			<tr>
				<th>Total</th>
				<th>Name</th>
				<th>Address</th>
			</tr>
			<c:forEach var="orderHeader" items="${it.headers}" varStatus="status">
			<tr>
				<td><c:out value="${orderHeader.total}"/></td>
				<td><c:out value="${orderHeader.name}"/></td>
				<td><c:out value="${orderHeader.address}"/></td>
				<td><a class="btn" href="${root}/orderDetail/${orderHeader.id }" id="row-<c:out value="${orderHeader.id}"/>-show-detail">Detail</a></td>
			</tr>
			</c:forEach>
		</table>
	</div>

	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
	<script type="text/javascript" src="<c:url value="/bootstrap/js/bootstrap.min.js"/>"></script>
</body>
</html>