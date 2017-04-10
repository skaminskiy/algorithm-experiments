package org.ska.datastructures.LinkedLists;

public class MyLinkedList<T> {
    
    public MyLinkedList() {}
    
    public MyLinkedList(Node<T> head) {
        this.head = head;
    }
    
     public Node<T> head;
}
