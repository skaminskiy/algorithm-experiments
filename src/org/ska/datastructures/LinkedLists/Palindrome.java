package org.ska.datastructures.LinkedLists;

public class Palindrome {
    public static void main(String[] args) {
        
        
        Node<Character> head = new Node<Character>();
        head.data = 'f';
        Node<Character> next1 = new Node<Character>();
        next1.data = 'h';
        Node<Character> next2 = new Node<Character>();
        next2.data = 'o';
        Node<Character> next3 = new Node<Character>();
        next3.data = 'h';
        Node<Character> next4 = new Node<Character>();
        next4.data = 'o';
        
        head.next = next1;
        next1.next = next3;
        //next2.next = next3;
        next3.next = next4;
        
        System.out.println(isPalindrome(head)); //true
      }
    
    static boolean isPalindrome(Node<Character> node) {
        
        Result result = isPalindrome(node, node, 0);
        return result.isPalindrome;
    }
    
    static Result isPalindrome(Node<Character> head, Node<Character> tail, int count) {
        
        Result result;
        
        if (tail.next != null) {
            result = isPalindrome(head, tail.next, count+1);
            
            if (result.count <= 1) {
                return result;
            }
            
            result.isPalindrome = result.isPalindrome && (result.head.data == tail.data);
            result.count = result.count - 1;
        } else {
            result = new Result();
            result.isPalindrome = head.data == tail.data;
            result.count = count / 2;
        }
        
        result.head = head.next;
        return result;
    }
    
    static class Result {
        boolean isPalindrome = true;
        Node<Character> head;
        int count;
    }
}
