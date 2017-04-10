package org.ska.datastructures.LinkedLists;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.ListIterator;


public class Partition {
    public static void main(String[] args) {
        
//      Node<Integer> head = new Node<Integer>();
//      head.data = 3;
//      Node<Integer> next1 = new Node<Integer>();
//      next1.data = 5;
//      Node<Integer> next2 = new Node<Integer>();
//      next2.data = 8;
//      Node<Integer> next3 = new Node<Integer>();
//      next3.data = 5;
//      Node<Integer> next4 = new Node<Integer>();
//      next4.data = 10;
//      Node<Integer> next5 = new Node<Integer>();
//      next5.data = 2;
//      Node<Integer> next6 = new Node<Integer>();
//      next6.data = 1;
//      
//      head.next = next1;
//      next1.next = next2;
//      next2.next = next3;
//      next3.next = next4;
//      next4.next = next5;
//      next5.next = next6;
//
//      
//      MyLinkedList<Integer> list = new MyLinkedList<Integer>(head);
//      
//      makePartition(list, 5);
//        
//      System.out.println(list.head.data);
//      System.out.println(list.head.next.data);
//      System.out.println(list.head.next.next.data);
//      System.out.println(list.head.next.next.next.data);
//      System.out.println(list.head.next.next.next.next.data);
//      System.out.println(list.head.next.next.next.next.next.data);
//      System.out.println(list.head.next.next.next.next.next.next.data);
//      System.out.println(list.head.next.next.next.next.next.next.next);
        
        
        LinkedList<Integer> list = new LinkedList<Integer>(Arrays.asList(3, 5, 8, 5, 10, 2, 1));
        makePartition2(list, 5);
        
        for (int el: list) {
            System.out.println(el);
        }
        
        
    }
    
    static void makePartition(MyLinkedList<Integer> list, int value) {
        
       Node<Integer> current = list.head;
        
       while(current.next != null) {
           
           if (current.next.data < value) {
               
               Node<Integer> newHead = current.next;
               
               current.next = current.next.next;
               newHead.next = list.head;
               list.head = newHead;
           } else {
               current = current.next;
           }
           
       }
    }
    
    static void makePartition2(LinkedList<Integer> list, int value) {
        
        
        ListIterator<Integer> iterator = list.listIterator();
        LinkedList<Integer> tailList = new LinkedList<Integer>();
        
        while (iterator.hasNext()) {
            int nextValue = iterator.next();
            if (nextValue >= value) {
                iterator.remove();
                tailList.add(nextValue);
            }
        }
        
        list.addAll(tailList);
     }
}
