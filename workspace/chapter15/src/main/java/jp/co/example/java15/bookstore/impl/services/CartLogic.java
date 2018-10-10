package jp.co.example.java15.bookstore.impl.services;

import jp.co.example.java15.bookstore.spec.dto.CartAddResult;
import jp.co.example.java15.bookstore.spec.dto.CartItemRelation;
import jp.co.example.java15.bookstore.spec.dto.Stock;


final class CartLogic {
	CartAddResult calculate(CartItemRelation cartItem, Stock stock, int amount, int maxCapacity) {
		int newAmount = cartItem != null ? cartItem.getAmount() + amount : amount;
		int overflowed = 0;

		if (newAmount > maxCapacity) {
			overflowed = newAmount - maxCapacity;
			newAmount = maxCapacity;
		}

		int shortage = 0;

		if (newAmount > stock.getStock()) {
			shortage = newAmount - stock.getStock();
			newAmount -= shortage;
		}

		int actualAdded = cartItem != null ? newAmount - cartItem.getAmount() : newAmount;

		CartAddResult result = new CartAddResult(newAmount, overflowed, shortage, actualAdded, maxCapacity);

		return result;
	}
}
