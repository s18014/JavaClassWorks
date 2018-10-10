package jp.co.example.java15.sample_application;

public class Main {

	/**
	 * 実行時引数として
	 * 1番目 名前
	 * 2番目 国籍 
	 * 3番目 購入する商品のID 
	 * 4番目 購入する個数 
	 * を指定。
	 * @param args
	 */
	public static void main(String[] args) {
		Account guest = new Account(args[0], Country.valueOf(args[1]));
		Greeter greeter = GreeterFactory.getGreeter(guest);
		greeter.login(guest);
		PurchaseManager manager = PurchaseManagerFactory.getManager(guest);
		manager.purchase(Integer.parseInt(args[2]), Long.parseLong(args[3]));
		greeter.like(guest);
		greeter.logout(guest);
	}
}
