<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<c:import url="/WEB-INF/jsp/common/htmlheader.jsp" />
</head>

<body>
	<c:import url="/WEB-INF/jsp/common/header.jsp" />

	<div class="container">
		<!-- TODO 商品全部を表示してください -->
		<!-- TODO form の idはform-商品IDでお願いします / action の url に URI を設定して下さい -->
		<div class="row">
			<div class="col-md-2">
				<!-- TODO srcを埋めてください / idはitemImage-商品IDでお願いします -->
				<img src="/" id="itemImage-商品ID" class="img-rounded"/>
			</div>
			<div class="col-md-9 col-md-offset-1">
				<div>
					<!-- TODO 商品名を出力してください / idはitemName-商品IDでお願いします -->
					<h2 id="itemName-商品ID">我が社の素敵な商品</h2>
				</div>

				<!-- TODO 商品価格を出力してください / idはitemPrice-商品IDでお願いします -->
				<div id="itemPrice-商品ID">
					Priceless YEN
				</div>

				<!-- TODO 以下、在庫切れの時は表示しないでください -->
				<div>
					<!-- TODO 発注量項目 / idはitemAmount-商品IDでお願いします -->
					<select name="amount" class="form-control" id="itemAmount-商品ID">
						<!-- TODO 発注量を10個未満に制限してください -->
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
						<option value="6">6</option>
						<option value="7">7</option>
						<option value="8">8</option>
						<option value="9">9</option>
					</select>
					<!-- TODO ボタンの idはitemAddCart-商品IDでお願いします -->
					<button class="btn" type="submit" id="itemAddCart-xxxx">カートに追加</button>
				</div>
				<!-- TODO 在庫ある時だけ表示はここまで -->
			</div>
		</div>

		<!-- TODO カートを確認するリンクは商品一覧の下に配置してください -->
		<div class="row">
			<!-- TODO hrefを埋めてください -->
			<a class="btn" href="/" id="showCart">カートを確認</a>
		</div>
	</div>
</body>
</html>