package jp.co.example.java15.sample_application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.StringTokenizer;

public class JapanesePurchaseManager implements PurchaseManager {

	@Override
	public void purchase(int purchasedItemId, long amount) {

		// 商品情報の読み込み処理。
		// item.csvから全商品のデータを読み込む。
		File itemInfoFile = new File("resources/item.csv");
		try (
			FileReader fileReader = new FileReader(itemInfoFile);
			BufferedReader bufferedReader = new BufferedReader(fileReader);) {
			/*
			 * 【注意】このCSVファイルの読み込み処理はサンプル用です。
			 * 実際の業務では、自前の実装ではなく、CSVを処理するためのライブラリを使うようにしてください。
			 */
			String itemName = null;
			String priceEntry = null;
			boolean existsItem = false;

			String line;
			// 読み込んだ商品データの中から、購入対象の商品を探す。
			while ((line = bufferedReader.readLine()) != null) {
				StringTokenizer tokenizer = new StringTokenizer(line, ",");
				int itemId = Integer.parseInt(tokenizer.nextToken());
				if (purchasedItemId == itemId) {
					itemName = tokenizer.nextToken();
					priceEntry = tokenizer.nextToken();
					long stockAmount = Long.parseLong(tokenizer.nextToken());

					// 在庫数をチェック
					if (amount > stockAmount) {
						break;
					}
					existsItem = true;
					break;
				}
			}

			// 商品が存在しない場合、メッセージを出力して終了する。
			if (!existsItem) {
				System.out.println("商品が存在しません。");
				return;
			}

			// 購入金額を計算する。
			BigDecimal price = new BigDecimal(priceEntry);
			BigDecimal total = price.multiply(BigDecimal.valueOf(amount));

			// 購入情報を表示する。
			System.out.println("購入商品は \"" + itemName + "\" (" + amount + ") です。");
			System.out.println("合計金額は" + total + "です。");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
