package org.ska.datastructures.StacksAndQueues;

import java.util.ArrayList;

import org.ska.datastructures.LinkedLists.Node;

public class SetOfStacksRun {
    public static void main(String[] args) {
        
        SetOfStacks<Integer> stack = new SetOfStacks<Integer>(3);
        stack.push(5);
        stack.push(28);
        stack.push(7);
        stack.push(8);
        stack.push(1);
        stack.push(15);
        stack.push(7);
        stack.push(21);
        
//        System.out.println(stack.popAt(1)); //15
//        System.out.println(stack.popAt(1)); //1
//        System.out.println(stack.popAt(1)); //8
//        System.out.println(stack.popAt(1)); //21

          System.out.println(stack.peek()); //21
          System.out.println(stack.isEmpty()); //false
          System.out.println(stack.pop()); //21
          System.out.println(stack.pop()); //7
          System.out.println(stack.pop()); //15
          System.out.println(stack.pop()); //1
          System.out.println(stack.isEmpty()); //false
          
          System.out.println(stack.popAt(1)); //8
          System.out.println(stack.peek()); //7
          
      }
      
    static public class SetOfStacks<T> {
        
        private final int limit;
        private final ArrayList<OneStack<T>> list = new ArrayList<OneStack<T>>();
        
        public SetOfStacks(int limit) {
           this.limit = limit;
        }
        
        private void shift(ArrayList<OneStack<T>> list, int stackIndex) {
            OneStack<T> nextStack = null;
            OneStack<T> stack = null;
            
            if (list.size() > stackIndex + 1) {
                nextStack = list.get(stackIndex+1);
            }
            if (list.size() > stackIndex) {
                stack = list.get(stackIndex);
            }
            
            if (stack == null) {
                return;
            }
            
            if (stack.size == 0) {
                list.remove(stackIndex);
                return;
            }
            
            if (nextStack == null) {
                return;
            }
            
  
            stack.last.next = nextStack.first;
            stack.last = nextStack.first;
            nextStack.first = nextStack.first.next;
            stack.last.next = null;
            stack.size++;
            nextStack.size--;

            shift(list, stackIndex+1);
        }
        
        public void push(T item) {
            Node<T> node = new Node<T>(item);
            
            if (list.size() > 0) {
                OneStack<T> firstStack = list.get(list.size() - 1);
                
                if (firstStack.size < this.limit) {
                    
                    node.next = firstStack.first;
                    firstStack.first = node;
                    firstStack.size++;
                    return;
                }
            }
            
            list.add(new OneStack<T>(node));
        }
        
        public T pop() {
            return popAt(list.size() - 1);
        }
        
        public T peek() {
            if (list.size() > 0) {
                return list.get(list.size() - 1).first.data;
            }
            
            return null;
        }
       
        public boolean isEmpty() {
            return list.size() == 0;
        }
        
        public T popAt(int index) {
            if (list.size() < index+1) {
                return null;
            }
            
            OneStack<T> stack = list.get(index);
            
            Node<T> node = stack.first;
            stack.first = node.next;
            stack.size--;
            shift(list, index);
            
            return node.data;
        }
        
        static class OneStack<T> {
            
            private Node<T> first = null;
            private Node<T> last = null;
            private int size;
            
            public OneStack(Node<T> first) {
               this.first = first;
               this.last = first;
               this.size = 1;
            }
        }
        
        static class Node<T> {
            
          public Node<T> next;
          private T data;
            
          public Node(T data) {
              this.data = data;
          }
        }
    }
}
