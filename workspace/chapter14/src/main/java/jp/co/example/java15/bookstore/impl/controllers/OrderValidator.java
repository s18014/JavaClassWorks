package jp.co.example.java15.bookstore.impl.controllers;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;


public class OrderValidator {
	private static final Charset MS932 = Charset.forName("MS932");


	public static Map<String, String> validate(String name, String address) {
		Map<String, String> messages = new HashMap<String, String>();
		String addressMessage = validateAddress(address);

		if (addressMessage != null) {
			messages.put("address", addressMessage);
		}

		String nameMessage = validateName(name);

		if (nameMessage != null) {
			messages.put("name", nameMessage);
		}

		return messages;
	}


	private static String validateAddress(String address) {
		if (address == null || address.isEmpty()) {
			return "住所が入力されていません";
		}

		if (address.getBytes(MS932).length > 200) {
			return "住所は200Byte以内で入力してください";
		}

		return null;
	}


	private static String validateName(String name){
		if (name == null || name.isEmpty()) {
			return "氏名が入力されていません";
		}

		if (name.getBytes(MS932).length > 40) {
			return "氏名は40Byte以内で入力してください";
		}

		return null;
	}
}
