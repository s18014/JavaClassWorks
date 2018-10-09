package jp.co.example.java15.sample_application;

public class Account {
	private final Country country;
	private final String name;

	public Account(String name, Country country) {
		this.country = country;
		this.name = name;
	}

	public Country getCountry() {
		return country;
	}

	public String getName() {
		return name;
	}
}
