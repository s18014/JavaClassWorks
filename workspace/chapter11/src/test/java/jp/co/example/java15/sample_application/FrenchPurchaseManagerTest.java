package jp.co.example.java15.sample_application;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FrenchPurchaseManagerTest {

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
	public void testPurchaseOneItem3() {
		Account guest = new Account("Pierre", Country.FRANCE);
		PurchaseManager manager = PurchaseManagerFactory.getManager(guest);
		manager.purchase(3, 1);
		assertThat(tempOutStream.toString(),
				is("Merci pour acheter: \"かんたんフロントエンド開発\" (1)" + LINE_SEPARATOR
						+"Le prix total est 1890." + LINE_SEPARATOR));
	}

	@Test
	public void testPurchaseItemNotExist() {
		Account guest = new Account("Alice", Country.FRANCE);
		PurchaseManager manager = PurchaseManagerFactory.getManager(guest);
		manager.purchase(0, 7);
		assertThat(tempOutStream.toString(),
				is("Aucun produit n'a été trouvé." + LINE_SEPARATOR));
	}
}
