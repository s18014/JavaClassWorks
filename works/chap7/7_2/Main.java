import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> fruits = new ArrayList<>();
        fruits.add("pen");
        fruits.add("apple");
        fruits.add("pineapple");
        Collection.reverse(fruits);
        System.out.printl(fruits);

        Collections.sort(fruits, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });

        System.out.println(fruits);
    }
}
