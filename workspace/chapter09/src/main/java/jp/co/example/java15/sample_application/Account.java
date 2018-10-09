package jp.co.example.java15.sample_application;

public class Account {
	private final String name;
	private final Country country;

	public Account(String name, Country country) {
		this.name = name;
		this.country = country;
	}

	public String getName() {
		return name;
	}

	public Country getCountry() {
		return country;
	}
}
