//package org.ska.javaExp;
//
//import java.util.*;
//import java.lang.*;
//import java.io.*;
//
//public class GenericMethodTest<T extends Number & Comparable<T> & Iterable, G extends Number> {
//    // generic method printArray
//    public <E extends Integer, R>  R printArray( E[] inputArray, R fdgdf ) {
//        // Display array elements
//        for(E element : inputArray) {
//            //System.out.printf("%s ", element);
//
//            element = element.get + 1;
//        }
//        System.out.println();
//
//        return fdgdf;
//    }
//
//    public <T extends Number & Comparable<T>>  double sum(List<? super Number> list, E dsfg){
//        double sum = 0;
//        for(Object n : list){
//            sum += n.doubleValue();
//        }
//        return sum;
//    }
//
//    public static void main(String args[]) {
//        // Create arrays of Integer, Double and Character
//        Integer[] intArray = { 1, 2, 3, 4, 5 };
//        Double[] doubleArray = { 1.1, 2.2, 3.3, 4.4 };
//        Character[] charArray = { 'H', 'E', 'L', 'L', 'O' };
//
//        System.out.println("Array integerArray contains:");
//        printArray(intArray);   // pass an Integer array
//
//        System.out.println("\nArray doubleArray contains:");
//        printArray(doubleArray);   // pass a Double array
//
//        System.out.println("\nArray characterArray contains:");
//        printArray(charArray);   // pass a Character array
//    }
//}
