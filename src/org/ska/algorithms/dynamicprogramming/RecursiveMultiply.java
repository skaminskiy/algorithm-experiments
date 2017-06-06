package org.ska.algorithms.dynamicprogramming;

public class RecursiveMultiply {
    
    public static void main(String args[]) {
        System.out.println(multiply(4, 6, 0)); //24
    }
    
    
    static int multiply(int first, int second, int count) {
        
        int firstAdd = 0;
        int secondAdd = 0;
        
        if ((first & 1) == 1) {
            firstAdd = 1;
        }
        if ((second & 1) == 1) {
            secondAdd = 1;
        }
        
        first = first >> 1;
        second = second >> 1;
        
        
        if (first == 1 && second == 1) {
            if (first == 1) {
                return (((second + secondAdd) << count) + firstAdd) << count;
            } else {
                return (((first + firstAdd) << count) + secondAdd) << count;
            }
        }
        
        return multiply(first, second, count + 1);
    }
    
}
