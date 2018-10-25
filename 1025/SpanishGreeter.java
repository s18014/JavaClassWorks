public class SpanishGreeter implements Greeter {
    @Override
    public String login(Account guest) {
        return String.format("Buenos Dias", guest.getName());
    }

    @Override
    public String logout(Account guest) {
        return "Hasta luego";
    }

    @Override
    public String like(Account guest) {
        return "Gracias";
    }
}
