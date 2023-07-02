package Percobaan;

public class Node <E> {
    E data;
    Node<E> prev, next;

    Node(Node<E> prev, E data, Node<E> next) {
        this.prev = prev;
        this.data = data;
        this.next = next;
    }
}
