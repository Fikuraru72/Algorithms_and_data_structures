package Percobaan2;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Stack;

public class Percobaan2 {
    public static void main(String[] args) {
        Stack<String> fruits = new Stack<>();
        // List<String> fruits = new Stack<>();
        fruits.push("Banana");
        fruits.add("Orange");
        fruits.add("Watermelon");
        fruits.add("Leci");
        fruits.push("Salak");

        for (String fruit : fruits) {
            System.out.printf("%s ", fruit );
        }

        System.out.println("\n"+ fruits.toString());

        while (!fruits.empty()) {
            System.out.printf("%s ", fruits.pop());
        }

        fruits.push("melon");
        fruits.push("Durian");

        System.out.println();
        for (Iterator<String> it = fruits.iterator(); it.hasNext(); ) {
            String fruit = it.next();
            System.out.printf("%s ", fruit);
        }

        System.out.println();
        fruits.stream().forEach(e -> { System.out.printf("%s ", e);});
        
        System.out.println();
        for (int i = 0; i < fruits.size(); i++) {
            System.out.printf("%s ", fruits.get(i));
        }

        fruits.set(0, "Strawberry");
        System.out.println();
        fruits.stream().forEach(e -> { System.out.printf("%s ", e);});
        System.out.println();

        fruits.push("Manggo");
        fruits.push("Guava");
        fruits.push("Avocado");
        System.out.println("Data Awal : ");
        for (String fruit : fruits) {
            System.out.printf("%s ", fruit );
        }
        fruits.sort(Comparator.naturalOrder());
        System.out.println();
        System.out.println("Data Shorting : ");
        for (String fruit : fruits) {
            System.out.printf("%s ", fruit );
        }

    }
}
