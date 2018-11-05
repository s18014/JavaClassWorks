import java.util.*;
public class Test {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        Iterator<Integer> i = list.iterator();
        System.out.println(list.get(-1));
    }
}
