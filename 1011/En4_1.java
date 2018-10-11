public class En4_1 {
    public static void main(String[] args) {
        Item pencil = new Item("p-hb-001", "Pokemon pencil", "Nintendo", 1980);
        Item pencil2 = new Item("p-hb-001", "Pokemon pencil", "Nintendo", 1980);
        Item pencil3 = new Item("p-hb-001", "Pokemon pencil", "Sony", 1980);
        Item pencil4 = new Item("p-hb-001", "Pokemon pencil", "Nintendo", 3000);
        Item pencil5 = new Item("p-hb-777", "Pokemon pencil", "Nintendo", 1980);
        Item pencil6 = new Item("p-hb-001", "Pachimon pencil", "Nintendo", 1980);

        checkEquals(pencil, pencil2);
        checkEquals(pencil, pencil3);
        checkEquals(pencil, pencil4);
        checkEquals(pencil, pencil5);
        checkEquals(pencil, pencil6);
    }

    public static void checkEquals(Item item1, Item item2) {
        if (item1.equals(item2)) {
            print(String.format("\"%s\" and \"%2s\" is equal", item1.getName(), item2.getName()));
        } else {
            print(String.format("\"%s\" and \"%2s\" is not equal", item1.getName(), item2.getName()));
        }
    }

    public static void print (Object obj) {
        System.out.println(obj);
    }
}
