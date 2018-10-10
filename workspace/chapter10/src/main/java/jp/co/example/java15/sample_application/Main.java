package jp.co.example.java15.sample_application;

public class Main {

	public static void main(String[] args) {
		Account guest = new Account(args[0], Country.valueOf(args[1]));
		Greeter greeter = GreeterFactory.getGreeter(guest);
		greeter.login(guest);
		greeter.like(guest);
		greeter.logout(guest);
	}
}
