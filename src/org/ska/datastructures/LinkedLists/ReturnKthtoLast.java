package org.ska.datastructures.LinkedLists;

import java.util.Arrays;
import java.util.LinkedList;

public class ReturnKthtoLast {
    public static void main(String[] args) {

        
//        Node<String> head = new Node<String>();
//        head.data = "aa";
//        Node<String> next1 = new Node<String>();
//        next1.data = "ggg";
//        Node<String> next2 = new Node<String>();
//        next2.data = "bbb";
//        Node<String> next3 = new Node<String>();
//        next3.data = "bb";
//        Node<String> next4 = new Node<String>();
//        next4.data = "cc";
        
//        head.next = next1;
//        next1.next = next2;
//        next2.next = next3;
//        next3.next = next4;

        
        LinkedList<String> list = new LinkedList<String>(Arrays.asList("aa", "cc", "bb", "cc")); //(
        
        String node = getKth2(list, 1);
        
        //System.out.println(node); //bb
        System.out.println(node); //bb
        
   }
    
    static Node<String> getKth(MyLinkedList<String> list, int index) {
        
        if (index < 0) {
            return null;
        }
        
        Node<String> current = list.head;
        int count = 0;
        
        while(current != null) {
            count = count + 1;
            current = current.next;
        }
        
        if (index >= count) {
            return null;
        }
        
        current = list.head;
        for (int i = 0; i < count - index - 1; i++) {
            current = current.next;
        }

        return current;
        
    }
    
    static String getKth2(LinkedList<String> list, int index) {
        
        if (index < 0) {
            return null;
        }
        
        int count = list.size();
        
        if (index >= count) {
            return null;
        }
        
//        current = list.head;
//        for (int i = 0; i < count - index - 1; i++) {
//            current = current.next;
//        }
//
        return list.get(count - index - 1);
        
    }

}
