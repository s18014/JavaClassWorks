public class FrenchGreeter implements Greeter {
    @Override
    public String login(Account guest) {
        return String.format("Bonjour, %s", guest.getName());
    }

    @Override
    public String logout(Account guest) {
        return "Au revoir";
    }

    @Override
    public String like(Account guest) {
        return "Merci beaucoup";
    }
}
