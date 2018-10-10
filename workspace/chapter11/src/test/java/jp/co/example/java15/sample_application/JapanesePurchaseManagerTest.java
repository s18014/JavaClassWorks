package jp.co.example.java15.sample_application;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class JapanesePurchaseManagerTest {

	private PrintStream storedStream;
	private ByteArrayOutputStream tempOutStream;
	private static final String LINE_SEPARATOR = System
			.getProperty("line.separator");

	@Before
	public void setUp() {
		storedStream = System.out;
		tempOutStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(tempOutStream));
	}

	@After
	public void tearDown() {
		System.setOut(storedStream);
	}

	@Test
	public void testPurchaseThreeItem1() {
		Account guest = new Account("山田太郎", Country.JAPAN);
		PurchaseManager manager = PurchaseManagerFactory.getManager(guest);
		manager.purchase(1, 3);
		assertThat(tempOutStream.toString(),
				is("購入商品は \"バグ取り少年\" (3) です。" + LINE_SEPARATOR
						+"合計金額は4410です。" + LINE_SEPARATOR));
	}

	@Test
	public void testPurchaseItemNotExist() {
		Account guest = new Account("鈴木二朗", Country.JAPAN);
		PurchaseManager manager = PurchaseManagerFactory.getManager(guest);
		manager.purchase(0, 5);
		assertThat(tempOutStream.toString(),
				is("商品が存在しません。" + LINE_SEPARATOR));
	}

}
