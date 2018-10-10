package jp.co.example.java15.sample_application;

import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.StringTokenizer;

public class PriceCalculatorUtils {

	public BigDecimal getTotalPrice(long amount, String priceEntry) {
		BigDecimal unitPrice = new BigDecimal(priceEntry);
		BigDecimal totalPrice = unitPrice.multiply(BigDecimal.valueOf(amount));
		return totalPrice;
	}

	public PurchaseItemDTO getPurchaseItemInfo(int purchasedItemId,
			long amount, BufferedReader bufferedReader) throws IOException {
		PurchaseItemDTO purchaseItemDTO = null;
		String line;
		while ((line = bufferedReader.readLine()) != null) {
			StringTokenizer tokenizer = new StringTokenizer(line, ",");
			int itemId = Integer.parseInt(tokenizer.nextToken());
			if (purchasedItemId == itemId) {
				String itemName = tokenizer.nextToken();
				String priceEntry = tokenizer.nextToken();
				long stockAmount = Long.parseLong(tokenizer.nextToken());

				if (amount > stockAmount) {
					break;
				}
				purchaseItemDTO = new PurchaseItemDTO(itemName, priceEntry, true);
				break;
			}
		}
		return purchaseItemDTO;
	}

}
