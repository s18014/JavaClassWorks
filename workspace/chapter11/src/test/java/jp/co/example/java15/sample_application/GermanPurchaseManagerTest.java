package jp.co.example.java15.sample_application;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GermanPurchaseManagerTest {

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
	public void testPurchaseFiveItem1() {
		Account guest = new Account("Abel", Country.GERMANY);
		PurchaseManager manager = PurchaseManagerFactory.getManager(guest);
		manager.purchase(1, 5);
		assertThat(tempOutStream.toString(),
				is("Danke für den Kauf: \"バグ取り少年\" (5)" + LINE_SEPARATOR
						+"Der Gesamtpreis ist 7350." + LINE_SEPARATOR));
	}

	@Test
	public void testPurchaseItemNotExist() {
		Account guest = new Account("Dorothee", Country.GERMANY);
		PurchaseManager manager = PurchaseManagerFactory.getManager(guest);
		manager.purchase(0, 4);
		assertThat(tempOutStream.toString(),
				is("Es wurden keine Produkte gefunden." + LINE_SEPARATOR));
	}

}
