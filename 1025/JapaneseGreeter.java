public class JapaneseGreeter implements Greeter {
    @Override
    public String login(Account guest) {
        return String.format("Konichiha %s san", guest.getName());
    }

    @Override
    public String logout(Account guest) {
        return "Sayonara";
    }

    @Override
    public String like(Account guest) {
        return "Arigatou";
    }
}
