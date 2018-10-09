package jp.co.example.java15.sample_application;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EnglishPurchaseManagerTest {

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
	public void testPurchaseTwoItem2() {
		Account guest = new Account("Bob", Country.USA);
		PurchaseManager manager = PurchaseManagerFactory.getManager(guest);
		manager.purchase(2, 2);
		assertThat(tempOutStream.toString(),
				is("Thank You for purchasing: \"ゼロからのJava\" (2)" + LINE_SEPARATOR
						+"The total price is 7560." + LINE_SEPARATOR));
	}

	@Test
	public void testPurchaseItemNotExist() {
		Account guest = new Account("Eve", Country.USA);
		PurchaseManager manager = PurchaseManagerFactory.getManager(guest);
		manager.purchase(0, 10);
		assertThat(tempOutStream.toString(),
				is("No products were found." + LINE_SEPARATOR));
	}
}
