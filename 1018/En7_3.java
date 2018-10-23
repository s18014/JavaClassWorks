import java.util.*;

public class En7_3 {
    public static void main(String[] args) {
        Map<String, String> fruits = new HashMap<>();
        fruits.put("りんご", "apple");
        fruits.put("orange", "オレンジ");
        fruits.put("banana", "バナナ");

        System.out.println(fruits.get("りんご"));
    }
}
