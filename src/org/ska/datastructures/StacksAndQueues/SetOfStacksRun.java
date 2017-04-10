package org.ska.datastructures.StacksAndQueues;

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
        
        public SetOfStacks(int limit) {
           this.limit = limit;
        }
        
        public void push(T item) {
            
        }
        
        public T pop() {
            return null;
        }
        
        public T peek() {
            return null;
        }
       
        public boolean isEmpty() {
            return false;
        }
        
        public T popAt(int index) {
            return null;
        }
        
        static class OneStack<T> {
            
            private final int limit;
            
            public OneStack(int limit) {
               this.limit = limit;
            }
            
            
        }
    }
}
