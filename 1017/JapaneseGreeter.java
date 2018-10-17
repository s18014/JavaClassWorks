public class JapaneseGreeter implements Greeter {
    @Override
    public void login(Account guest) {
        System.out.println(String.format("Konichiwa %s san", guest.getName()));
    }

    @Override
    public void logout(Account guest) {
        System.out.println("Sayonara");
    }

    @Override
    public void like(Account guest) {
        System.out.println("Arigatou");
    }
}
