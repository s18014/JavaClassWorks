public class Main {
    public static void main(String[] args) {
        Weekday weekday = Weekday.FRIDAY;
        greet(weekday);
    }

    private static void greet(Weekday weekday) {
        switch (weekday) {
            case SUNDAY:
            case SATURDAY:
                print(Messages.HOLIDAYS);
                break;
            case FRIDAY:
                print(Messages.FRIDAY);
                break;
            default:
                print(Messages.WEEKDAYS);
                break;
        }
    }

    private static void print(Object obj) {
        System.out.println(obj);
    }
}
