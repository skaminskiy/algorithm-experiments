package org.ska.BitManipulation;

import java.math.BigDecimal;

public class PrintBinary {
    public static void main(String[] args) {
        
        System.out.println(print(new BigDecimal("0.80"))); //10001001100 //1001000
 }
 
    static String print(BigDecimal num) {
        StringBuilder binary = new StringBuilder();
        
        if (num.compareTo(new BigDecimal(1)) >= 0 || num.compareTo(new BigDecimal(0)) <= 0) {
             return "ERROR:";
         }
        

         binary.append(".");
          while (num.compareTo(new BigDecimal(0)) == 1) {
             if (binary.length() >= 132) {
                 return "ERROR"  + binary.toString();
             }
            
             BigDecimal r = num.multiply(new BigDecimal("2"));
             if (r.compareTo(new BigDecimal(1)) >= 0) { //>=
                 binary.append(1);
                 num = r.subtract(new BigDecimal("1"));
             } else {
                binary.append(0);
                num = r;
             }
         }
         
         return binary.toString();
    }
    
    
    static String print2(BigDecimal num) {
         if (num.compareTo(new BigDecimal(1)) >= 0 || num.compareTo(new BigDecimal(0)) <= 0) {
             return "ERROR";
         }
        
         StringBuilder binary = new StringBuilder();
         BigDecimal frac = new BigDecimal("0.5");
         binary.append(".");
         while (num.compareTo(new BigDecimal(0)) == 1) {
    
             if ( binary.length() > 32) {
                 return "ERROR";
             }
             if (num.compareTo(frac) >= 0) {
                 binary.append(1);
                 num = num.subtract(frac);
             } else {
                 binary.append(0);
             }
             frac = frac.divide(new BigDecimal("2"));
        }
     return binary.toString( );
    }
}
