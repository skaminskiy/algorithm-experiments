package org.ska.BitManipulation;

public class NextNumber {
    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(nextSmallestNumber(0b10010))); //0b10001
        //System.out.println(Integer.toBinaryString(nextLargestNumber(0b10010))); //0b10100
    }
    
    static int nextSmallestNumber(int number) {
        
        int cursor = number;
        int prevBit = -1;
        
        while (cursor > 0) {
            
            int currentBit = cursor & 1;
            
            if (prevBit == 0 & currentBit == 1) {
                
            }
            
            cursor >>>= 1;
            prevBit = currentBit;
        }
        
        return number;
    }
    
}
