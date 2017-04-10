package org.ska.datastructures.LinkedLists;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class RemoveDups {
    public static void main(String[] args) {

        
        Node<String> head = new Node<String>();
        head.data = "aa";
        Node<String> next1 = new Node<String>();
        next1.data = "bb";
        Node<String> next2 = new Node<String>();
        next2.data = "bb";
        Node<String> next3 = new Node<String>();
        next3.data = "cc";
        
        head.next = next1;
        next1.next = next2;
        next2.next = next3;

        
        MyLinkedList<String> list = new MyLinkedList<String>(head); //(Arrays.asList("aa", "cc", "bb", "cc")
        
        remove3(list);
        
        System.out.println(list.head.data); //aa
        System.out.println(list.head.next.data); //cc
        System.out.println(list.head.next.next.data); //bb
        System.out.println(list.head.next.next.next); //null
        
//        System.out.println(list.size()); //3
//        System.out.println(list.get(0)); //aa
//        System.out.println(list.get(1)); //cc
//        System.out.println(list.get(2)); //bb

       }
        
        
        static void remove(LinkedList<String> list) {
            HashMap<String, Boolean> map = new HashMap();

            for (String el : list) {
                if (map.containsKey(el)) {
                    list.remove(el);
                } else {
                    map.put(el, true);
                }
            }
        }
        
        static void remove2(LinkedList<String> list) {
            
            
            ListIterator<String> it1 = list.listIterator(0);

            while(it1.hasNext()) {
               
                String value = it1.next();
                if (value == null) {
                    continue;
                }
                
                ListIterator<String> it2 = list.listIterator(it1.nextIndex());
                while (it2.hasNext()) {
                    if (value.equals(it2.next())) {
                        it2.set(null);
                    }
                }
            }
            
            ListIterator<String> it3 = list.listIterator(0);
            while(it3.hasNext()) {
                    if (it3.next() == null) {
                        it3.remove();
                    }
            }
           
        }
        
        
        
        static void remove3(MyLinkedList<String> list) {
            
            Node<String> next1 = list.head;
            
            while(next1 != null) {
                
                String value = next1.data;
                
                Node<String> next2 = next1.next;
                Node<String> next3 = next1;
                while(next2 != null) {
                    
                    if (next2.data.equals(value)) {
                        next3.next = next2.next;
                    }
                    next3 = next2;
                    next2 = next2.next;
                }
                
                next1 = next1.next;
            }
        }
}
