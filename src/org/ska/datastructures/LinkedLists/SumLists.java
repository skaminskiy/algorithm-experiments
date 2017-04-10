package org.ska.datastructures.LinkedLists;

public class SumLists {
    public static void main(String[] args) {
        
        
      Node<Integer> head11 = new Node<Integer>();
      head11.data = 9;
      Node<Integer> next11 = new Node<Integer>();
      next11.data = 7;
      Node<Integer> next12 = new Node<Integer>();
      next12.data = 8;
      head11.next = next11;
      next11.next = next12;
      
      
      Node<Integer> head21 = new Node<Integer>();
      head21.data = 6;
      Node<Integer> next21 = new Node<Integer>();
      next21.data = 8;
      Node<Integer> next22 = new Node<Integer>();
      next22.data = 5;
      head21.next = next21;
      next21.next = next22;

      MyLinkedList<Integer> result = sum(new MyLinkedList<Integer>(head11), new MyLinkedList<Integer>(head21));
      
        System.out.println(result.head.data); //2
        System.out.println(result.head.next.data); //1
        System.out.println(result.head.next.next.data); //9
        System.out.println(result.head.next.next.next.data);

        
    }
    
    static MyLinkedList<Integer> sum(MyLinkedList<Integer> list1, MyLinkedList<Integer> list2) {
        
        Node<Integer> head = null;
        Node<Integer> next = null;
        Node<Integer> current1 = list1.head;
        Node<Integer> current2 = list2.head;
        int residue = 0;
        
        while (current1 != null || current2 != null || residue > 0) {
            int newValue;
            if (current1 != null && current2 != null) {
                newValue = current1.data + current2.data + residue;
                current1 = current1.next;
                current2 = current2.next;
            } else if (current1 != null) {
                newValue = current1.data + residue;
                current1 = current1.next;
            } else if (current2 != null) {
                newValue = current2.data + residue;
                current2 = current2.next;
            } else {
                newValue = residue;
            }
            
            if (next == null) {
                next = new Node<Integer>();
                next.data = newValue%10;
                head = next;
            } else {
                next.next = new Node<Integer>();
                next.next.data = newValue%10;
                next = next.next;
            }
            
            residue = newValue/10;
        }
        
        return new MyLinkedList<Integer>(head);
    }

}
