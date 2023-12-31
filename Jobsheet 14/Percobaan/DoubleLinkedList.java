package Percobaan;

public class DoubleLinkedList<E> {
    Node<E> head;
    int size;

    public DoubleLinkedList (){
        head = null;
        size = 0;
    }

    public boolean isEmpety() {
        return head == null;
    }

    public void addFirst (E item) {
        if (isEmpety()) {
            head = new Node<E>(null, item, null);
        } else {
            Node<E> newNode = new Node<E>(null, item, head);
            head.prev = newNode;
            head = newNode;
        }
        size ++;
    }

    public void addLast (E item) {
        if (isEmpety()) {
            addFirst(item);
        } else {
            Node<E> current = head;
            while (current.next != null) {
                current = current.next;
            }
            Node<E> newNode = new Node<E>(current, item, null);
            current.next = newNode;
            size++;
        }
    }

    public void add (E item, int index) throws Exception {
        if (isEmpety()) {
            addFirst(item);
        } else if (index < 0 || index > size) {
            throw new Exception("Nilai indeks di luar batas");
        } else {
            Node<E> current = head; 
            int i = 0;
            while (i<index) {
                current = current.next;
                i++;
            }
            if (current.prev == null) {
                Node<E> newNode = new Node<E>(null, item, current);
                current.prev = newNode;
                head = newNode;
            } else {
                Node<E> newNode = new Node<E>(current.prev, item, current);
                newNode.prev = current.prev;
                newNode.next = current;
                current.prev.next = newNode;
                current.prev=newNode;
            }
        }
        size ++;
    }

    public int size (){
        return size;
    }

    public void clear (){
        head = null;
        size = 0;
    }

    public void print (){
        if (!isEmpety()) {
            Node<E> tmp = head;
            while (tmp != null) {
                System.out.print(tmp.data + "\t");
                tmp = tmp.next;
            }
            System.out.println("\nBerhasil Diisi");
        } else {
            System.out.println("Linked List Masih Kosong");
        }
    }

    // Percobaan 2

    public void removeFirst() throws Exception {
        if (isEmpety()) {
            throw new Exception("Linked List Masih Kosong");
        } else if (size == 1) {
                removeLast();
        } else {
            head = head.next;
            head.prev = null;
            size--;
        }
    }

    public void removeLast () throws Exception {
        if (isEmpety()) {
            throw new Exception("Linked list masih kosong");
        } else if (head.next == null) {
            head = null;
            size--;
            return;
        }
        Node<E> current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.prev.next = null;
        size--;
        
    }

    public void remove(int index) throws Exception {
        if (isEmpety() || index >= size) {
            throw new Exception("Nilai Indexs diluar batas");
        } else if (index == 0) {
            removeFirst();
        } else {
            Node<E> current = head;
            int i = 0;
            while (i < index) {
                current = current.next;
                i++;
            } 

            if (current.next == null) {
                current.prev.next = null;
            } else if (current.prev == null ) {
                current = current.next;
                current.prev = null;
                head = current;
            } else {
                current.prev.next = current.next;
                current.next.prev = current.prev;
            }
            size--;
        }
            
    }

    // percobaan 3

    public E getFirst  () throws Exception {
        if (isEmpety()) {
            throw new Exception("Linked List Masih Kosong");
        } 
        return head.data;
    }

    public E getLast () throws Exception {
        if (isEmpety()) {
            throw new Exception("Linked List Masih Kosong");
        } 
        Node<E> tmp = head;
        while (tmp.next !=null) {
            tmp = tmp.next;
        }       
        return tmp.data;
    }

    public E get (int index) throws Exception {
        if (isEmpety()) {
            throw new Exception("Linked List Masih Kosong");
        } 
        Node<E> tmp = head;
        for (int i = 0; i < index; i++) {
            tmp = tmp.next;
        }
        return tmp.data;
    }

    public boolean getData (int data){
            Node<E> temp = head;
            for (int i = 0; i < size; i++) {
                if (temp.data.equals(data)) {
                    return true;
                }
            }
            return false;
    }

}
