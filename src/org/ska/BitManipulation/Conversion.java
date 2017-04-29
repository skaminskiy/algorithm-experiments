package org.ska.BitManipulation;

public class Conversion {
    public static void main(String[] args) {
        System.out.println(getBitNumber(0b11100, 0b01111)); //3
    }
    
    static int getBitNumber(int a, int b) {
        int result = 0;
        int xor = a^b;
        
        while (xor > 0) {
            if ((xor & 1) == 1) {
                result++;
            }
            
            xor >>>= 1;
        }
        
        return result;
    }

}
