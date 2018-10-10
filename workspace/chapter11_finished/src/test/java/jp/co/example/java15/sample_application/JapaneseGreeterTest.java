package jp.co.example.java15.sample_application;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class JapaneseGreeterTest {

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
	public void testLogin() {
		Account guest = new Account("山田太郎", Country.JAPAN);
		Greeter greeter = GreeterFactory.getGreeter(guest);
		greeter.login(guest);
		assertThat(tempOutStream.toString(), is("こんにちは、山田太郎さん。" + LINE_SEPARATOR));
	}

	@Test
	public void testLogout() {
		Account guest = new Account("鈴木二朗", Country.JAPAN);
		Greeter greeter = GreeterFactory.getGreeter(guest);
		greeter.logout(guest);
		assertThat(tempOutStream.toString(), is("さようなら。" + LINE_SEPARATOR));
	}

	@Test
	public void testLike() {
		Account guest = new Account("伊藤和子", Country.JAPAN);
		Greeter greeter = GreeterFactory.getGreeter(guest);
		greeter.like(guest);
		assertThat(tempOutStream.toString(), is("ありがとうございます。" + LINE_SEPARATOR));
	}

}
