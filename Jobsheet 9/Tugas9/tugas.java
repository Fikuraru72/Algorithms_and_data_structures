import java.util.Scanner;

class Node2 {
    String data;
    Node2 next;

    public Node2 (String data, Node2 Selanjutnya){
        this.data = data;
        this.next = Selanjutnya;
    }
}

class LinkedList{
    Node2 head;
    Node2 tail;

    public boolean isEmpty (){
        return head == null;
    }

    public void print (){
        if (!isEmpty()){
            Node2 tmp = head;
            System.out.println("Isi Linked List :\t");
            while (tmp != null) {
                System.out.println(tmp.data + "\t");
                tmp = tmp.next;
            }
            System.out.println("");
        } else {
            System.out.println("Linked List Kosong");
        }
    }

    public void addFrist (String input) {
        Node2 ndInput = new Node2(input, null);
        if (isEmpty()) {
            head = ndInput;
            tail = ndInput;
        } else {
            ndInput.next = head;
            head = ndInput;
        }
    }

    public void addLast (String input){
        Node2 ndInput = new Node2(input, null);
        if (isEmpty()) {
            head = ndInput;
            tail = ndInput;
        } else {
            tail.next = ndInput;
            tail = ndInput;
        }
    }

    public void insertAfter (String key, String input){
        Node2 ndInput = new Node2(input, null);
        Node2 temp = head;
        do {
            if (temp.data.equalsIgnoreCase(key)) {
                ndInput.next = temp.next;
                temp.next = ndInput;
                if (ndInput.next==null) {
                    tail=ndInput;
                }
                break;
            }
        temp = temp.next;
        } while (temp != null);
    }

    public void insertBefore (String key, String input){
        Node2  ndInput = new Node2(input, null);
        Node2 temp = head;
        do {
            if (temp.next.data.equalsIgnoreCase(key)) {
                ndInput.next = temp.next;
                temp.next = ndInput;
                break;
            }
            temp = temp.next;
         } while (temp!= null);
    }


    public void removeFirst (){
        if (isEmpty()) {
            System.out.println("Linked List MAsih Kosong, Tidak Dapat Dihapus");
        } else if(head == tail) {
            head = tail = null;
        } else {
            head = head.next;
        }
    }

    public String getData (int index){
        Node2 temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.data;
    }

    public int indexOf (String key){
        Node2 temp = head;
        int index = 0;
        while (temp != null && temp.data.equalsIgnoreCase(key)) {
            temp = temp.next;
            index++;
        }

        if (temp == null) {
            return -1;
        } else {
            return index;
        }
    }


}

public class tugas {
    public static void main(String[] args) {
        LinkedList Lks = new LinkedList();
        Scanner sc = new Scanner(System.in);
        Scanner scr = new Scanner(System.in);
        
        boolean key = true;
        while (key) {
            System.out.println();
            System.out.println("Menu Pilihan");
            System.out.println("0. Print Antrian");
            System.out.println("1. Tambah Antrian");
            System.out.println("2. Kurangi Antrian");
            System.out.println("3. Cek Antrian (index)");
            System.out.println("4. Cek Antrian (Nama)");
            System.out.print("Masukan Index : ");
            int in = sc.nextInt();

            if (in == 1) {
                System.out.print("Masukan Nama : ");
                String ins = scr.nextLine();
                Lks.addLast(ins);
            } else if (in == 2){
                Lks.removeFirst();
            } else if (in == 3) {
                System.out.print("Masukan Index : ");
                int inx = sc.nextInt();
                System.out.println("Antrian Index ke-"+inx+" adalah "+ Lks.getData(inx));
            } else if (in == 4 ) {
                System.out.print("Masukan Nama : ");
                String nm = scr.nextLine();
                System.out.println("Antrian dengan nama "+ nm + " pada index ke-"+ Lks.indexOf(nm));
            } else if (in == 0) {
                Lks.print();
            }
        }

       


    }
}
