package jp.co.example.java15.sample_application;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import jp.co.example.java15.sample_application.Main;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestMain {

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
	public void testJapan() {
		Main.main(new String[] {"hanakoSUZUKI", "JAPAN"});
		assertThat(tempOutStream.toString(),
				is("こんにちは、hanakoSUZUKIさん。" + LINE_SEPARATOR
						+ "ありがとうございます。" + LINE_SEPARATOR
						+ "さようなら。" + LINE_SEPARATOR));
	}
	
	@Test
	public void testFrance() {
		Main.main(new String[] {"hanakoSUZUKI", "FRANCE"});
		assertThat(tempOutStream.toString(),
				is("Bonjour, hanakoSUZUKI." + LINE_SEPARATOR
						+ "Merci beaucoup." + LINE_SEPARATOR
						+ "Au revoir." + LINE_SEPARATOR));
	}
	
	@Test
	public void testGermany() {
		Main.main(new String[] {"hanakoSUZUKI", "GERMANY"});
		assertThat(tempOutStream.toString(),
				is("Guten Tag, hanakoSUZUKI." + LINE_SEPARATOR
						+ "Danke schon." + LINE_SEPARATOR
						+ "Aus Wiedersehen." + LINE_SEPARATOR));
	}
	
	@Test
	public void testUSA() {
		Main.main(new String[] {"hanakoSUZUKI", "USA"});
		assertThat(tempOutStream.toString(),
				is("Hello, hanakoSUZUKI." + LINE_SEPARATOR
						+ "Thank you." + LINE_SEPARATOR
						+ "Goodbye." + LINE_SEPARATOR));
	}

}
