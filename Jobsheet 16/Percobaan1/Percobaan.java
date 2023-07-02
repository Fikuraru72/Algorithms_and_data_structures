package Percobaan1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Percobaan {
    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>();
        l.add(1);
        l.add(2);
        l.add(3);
        // l.add("Cireng");
        System.out.printf("Element 0 : %d Total Elemen : %d element terakhir : %s \n", l.get(0), l.size(), l.get(l.size()-1));
        l.add(4);
        l.remove(0);
        System.out.printf("Element 0 : %d Total Elemen : %d element terakhir : %s \n", l.get(0), l.size(), l.get(l.size()-1));
        
        LinkedList<String> name = new LinkedList<>();
        name.add("Noureen");
        name.add("Akhlenna");
        name.add("Shannum");
        name.add("Uwais");
        name.add("Al-Qarni");

        System.out.printf("Element 0 : %s Total Elemen : %s element terakhir : %s \n", name.get(0), name.size(), name.get(name.size()-1));
        name.set(0, "My Kid");
        System.out.printf("Element 0 : %s Total Elemen : %s element terakhir : %s \n", name.get(0), name.size(), name.get(name.size()-1));
        System.out.println("Name : "+ name.toString());
        name.push("Mei-Mei");
        System.out.printf("Element 0 : %s Total Elemen : %s element terakhir : %s \n", name.getFirst(), name.size(), name.getLast());
        System.out.println("Name : "+ name.toString());
    }
    
}