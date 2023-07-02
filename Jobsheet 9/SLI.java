class Node {
    int data;
    Node next; 

    public Node (int nilai, Node berikutnya ){
        this.data = nilai;
        this.next = berikutnya;
    }
}

class SinggleLinkedList {
    Node head;
    Node tail;

    public boolean isEmpty (){
        return head == null;
    }

    public void print (){
        if (!isEmpty()){
            Node tmp = head;
            System.out.print("Isi Linked List :\t");
            while (tmp != null) {
                System.out.print(tmp.data + "\t");
                tmp = tmp.next;
            }
            System.out.println("");
        } else {
            System.out.println("Linked List Kosong");
        }
    }

    public void addFrist (int input) {
        Node ndInput = new Node(input, null);
        if (isEmpty()) {
            head = ndInput;
            tail = ndInput;
        } else {
            ndInput.next = head;
            head = ndInput;
        }
    }

    public void addLast (int input){
        Node ndInput = new Node(input, null);
        if (isEmpty()) {
            head = ndInput;
            tail = ndInput;
        } else {
            tail.next = ndInput;
            tail = ndInput;
        }
    }

    public void insertAfter (int key, int input){
        Node ndInput = new Node(input, null);
        Node temp = head;
        do {
            if (temp.data == key) {
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

    public void insertBefore (int key, int input){
        Node  ndInput = new Node(input, null);
        Node temp = head;
        do {
            if (temp.next.data == key) {
                ndInput.next = temp.next;
                temp.next = ndInput;
                break;
            }
            temp = temp.next;
         } while (temp!= null);
    }



    public void insertAt (int index, int input){
        if (index < 0) {
            System.out.println("Indexs Salah");
        } else if (index == 0) {
            addFrist(input);
        } else {
            Node temp = head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            temp.next = new Node(input, temp.next);
            if (temp.next.next==null) {
                tail=temp.next;
            }
        }
    }

    public int getData (int index){
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.data;
    }

    public int indexOf (int key){
        Node temp = head;
        int index = 0;
        while (temp != null && temp.data != key) {
            temp = temp.next;
            index++;
        }

        if (temp == null) {
            return -1;
        } else {
            return index;
        }
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

    public void removeLast(){
        if (isEmpty()) {
            System.out.println("Linked List MAsih Kosong, Tidak Dapat Dihapus");
        } else if (head == tail) {
            head = tail = null;
        } else {
            Node temp = head ;
            while (temp.next != tail) {
                temp = temp.next;
            }
            temp.next = null;
            tail = temp;
        }
    }

    public void remove (int key) {
        if (isEmpty()) {
            System.out.println("Linked List MAsih Kosong, Tidak Dapat Dihapus");
            
        } else{
            Node temp = head;
            while (temp != null) {
                if ((temp.data == key) && (temp == head)) {
                    this.removeFirst();
                    break;
                } else if (temp.next.data == key){
                    temp.next = temp.next.next;
                    if (temp.next == null) {
                        tail = temp;
                    }
                    break;
                }
                temp = temp.next;
            }
        }
    }

    public void removeAt (int index){
        if (index == 0){
            removeFirst();
        } else {
            Node temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            temp.next = temp.next.next;
            if (temp.next == null) {
                tail = temp;
            }
        }
    }


}


public class SLI {
    public static void main(String[] args) {
        SinggleLinkedList singLL = new SinggleLinkedList();
        singLL.print();
        singLL.addFrist(890);
        singLL.print();
        singLL.addLast(760);
        singLL.print();
        singLL.addFrist(700);
        singLL.print();
        singLL.insertAfter(700, 999);
        singLL.print();
        singLL.insertBefore(999, 123);
        singLL.print();
        singLL.insertAt(4, 833);
        singLL.print();

        System.out.println("Data Pada Indeks ke-1 = "+ singLL.getData(1));
        System.out.println("Data 3 Pada INdeks ke-" + singLL.indexOf(760));

        singLL.remove(999);
        singLL.print();
        singLL.removeAt(0);
        singLL.print();
        singLL.removeFirst();
        singLL.print();
        singLL.removeLast();
    }
    
}