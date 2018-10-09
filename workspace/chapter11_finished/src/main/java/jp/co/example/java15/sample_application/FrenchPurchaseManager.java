package jp.co.example.java15.sample_application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;

public class FrenchPurchaseManager implements PurchaseManager {

	@Override
	public void purchase(int purchasedItemId, long amount) {

		File itemInfoFile = new File("resources/item.csv");
		try (
			FileReader fileReader = new FileReader(itemInfoFile);
			BufferedReader bufferedReader = new BufferedReader(fileReader);) {

			PriceCalculatorUtils priceCalculatorUtils = new PriceCalculatorUtils();
			PurchaseItemDTO purchaseItemDTO = priceCalculatorUtils.getPurchaseItemInfo(
					purchasedItemId, amount, bufferedReader);

			if (purchaseItemDTO == null || !purchaseItemDTO.isExistsItem()) {
				System.out.println("Aucun produit n'a été trouvé.");
				return;
			}

			BigDecimal totalPrice = priceCalculatorUtils.getTotalPrice(amount, purchaseItemDTO.getPriceEntry());

			showPurchaseMessage(amount, purchaseItemDTO.getItemName(), totalPrice);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void showPurchaseMessage(long amount, String itemName,
			BigDecimal totalPrice) {
		System.out.println("Merci pour acheter: \"" + itemName + "\" (" + amount + ")");
		System.out.println("Le prix total est " + totalPrice + ".");
	}

}
