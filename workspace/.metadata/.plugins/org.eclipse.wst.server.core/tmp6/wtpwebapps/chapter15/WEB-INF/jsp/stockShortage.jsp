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
		<h1 id="sorry-title">
			申し訳ありません。
		</h1>

		<div class="alert alert-block">
			<ul>
				<c:forEach  var="stockShortage" items="${it.stockShortages}" varStatus="status">
				<li id="row-<c:out value="${stockShortage.item.id}"/>-item-name">
					「<c:out value="${stockShortage.item.name}"/>」 はご指定の数量が用意できませんでした。
				</li>
				</c:forEach>
			</ul>
		</div>

		<div>
			<a class="btn" href="${root}/showCart" id="show-cart">カートへ戻る</a>
		</div>

		<div>
			<a class="btn" href="${root}" id="show-item-list">商品リストへ戻る</a>
		</div>
	</div>

	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
	<script type="text/javascript" src="<c:url value="/bootstrap/js/bootstrap.min.js"/>"></script>
</body>
</html>