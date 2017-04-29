package org.ska.BitManipulation;

import java.util.BitSet;

public class Insertion {
     public static void main(String[] args) {
            
            System.out.println(Integer.toBinaryString(insert2(0b10000000000, 0b10011, 2, 6))); //10001001100
            System.out.println(Integer.toBinaryString(insert2(0b10101110101, 0b10011, 2, 6))); //10101001101
     }
     
     static int insert2(int n, int m, int j, int i) {
         
         int mask = (-1 << i) | (-1 >>> (32 - j));

         return (n & mask) | (m << j) ;
     }
     
     static int insert(int n, int m, int j, int i) {
         
         BitSet result = BitSet.valueOf(new long[]{(long)n});
         
         for (; j <= i; j++) {
             result.clear(j);
         }
         
         BitSet mSet = BitSet.valueOf(new long[]{(long)(m*4)});
         
         result.or(mSet);
         
         return (int)result.toLongArray()[0];
     }
}
