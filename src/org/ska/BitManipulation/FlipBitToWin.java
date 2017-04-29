package org.ska.BitManipulation;

public class FlipBitToWin {
    
    public static void main(String[] args) {
        //System.out.println(calculateMaxLength(0b11011101111)); //8
        
        
        //System.out.println(Integer.toBinaryString(0b101 & 0b1)); //8
        //System.out.println(Integer.toBinaryString((1 <<< 0b101))); //8
    }
    
    static int calculateMaxLength(int value) {
        int result = 0;
        
        while( value > 0 ) {
            
            int prevLength = 0;
            int currentLength = 0;
            
            int prevBit = 0;
            int currentBit = 0;
            
            currentBit = value & 1;
            
            if (prevBit != currentBit) {
                prevLength = currentLength;
                currentLength = 1;
            } else {
                currentLength = currentLength + 1;
            }
            
            if (currentBit == 0) {
                if (currentLength > 1) {
                    result = Math.max(result, prevLength + 1);
                } else {
                    
                }
            }

            
//          if (currentLength > 1) {
//              
//          }
            
            
            value >>>= 1;
        }
        
        
//        for(int i = 0; i < 32; i++) {
//            int newValue = flipBit(value, i);
//            if (newValue != value) {
//                result = Math.max(calculateLength(newValue), result);
//            }
//        }
        
        return result;
    }
    
//    static int flipBit(int value, int index) {
//        int mask = ~(1 << index+1);
//        return (value & mask) | (1 << index+1);
//    }
//    
//    static int calculateLength(int value) {
//        value >>>= 1;
//        return Integer.BYTES;
//    }

}
