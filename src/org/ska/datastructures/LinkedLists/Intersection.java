package org.ska.datastructures.LinkedLists;

public class Intersection {
    public static void main(String[] args) {
        
        Node<Character> head1 = new Node<Character>();
        Node<Character> next1 = new Node<Character>();
        Node<Character> next2 = new Node<Character>();
        Node<Character> next3 = new Node<Character>();
        Node<Character> next4 = new Node<Character>();

        head1.next = next1;
        next1.next = next2;
        next2.next = next3;
        next3.next = next4;
        
        Node<Character> head2 = new Node<Character>();
        Node<Character> next5 = new Node<Character>();
        Node<Character> next6 = new Node<Character>();
        Node<Character> next7 = new Node<Character>();
        Node<Character> next8 = new Node<Character>();

        head2.next = next5;
        next5.next = next6;
        next6.next = next7;
        next7.next = next8;
        next8.next = head1;
        
        System.out.println(isIntersection(head1, head2)); //true
    }
    
    static boolean isIntersection(Node<Character> head1, Node<Character> head2) {
        if (head1.next == null && head2.next == null) {
            return head1 == head2;
        }
        
        return isIntersection(head1.next == null ? head1 : head1.next, 
                head2.next == null ? head2 : head2.next);
    }
    
//    static boolean checkIntersection(Node<Character> head1, Node<Character> head2) {
////        
////        Node<Character> nex1;
////        Node<Character> nex2;
//        
//        if (head1.next == null && head2.next == null) {
//            return head1 == head2;
//        }
//        
//        return checkIntersection(head1.next == null ? head1 : head1.next, 
//                head2.next == null ? head2 : head2.next);
//    }
}
