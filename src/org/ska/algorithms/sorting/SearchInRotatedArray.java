package org.ska.algorithms.sorting;

import java.util.Arrays;

public class SearchInRotatedArray {
//    public static int findIndex(int value, int[] arr) {
//        
//      int divider = 0;
//      for(int i=0; i<arr.length; i++) {
//          if(i != 0 && arr[i] < arr[i-1]) {
//              divider = i;
//              break;
//          }
//      }
//      
//      int retVal = -1;
//      if (divider > 0) {
//          retVal = Arrays.binarySearch(Arrays.copyOfRange(arr, 0, divider), value);
//          if (retVal > -1) {
//              return retVal;
//          }
//      }
//      
//
//      retVal = Arrays.binarySearch(Arrays.copyOfRange(arr, divider, arr.length), value);
//      if (retVal > -1) {
//          return retVal + divider;
//      }
//      
//      return -1;
//    }
    
    public static int findIndex(int key, int[] arr) {
        
          int mid = 0;
          for(int i=0; i<arr.length; i++) {
              if(i != 0 && arr[i] < arr[i-1]) {
                  mid = i;
                  break;
              }
          }
      
        if (mid > 0) {
            int retVal = binarySearch(arr, 0, mid, key);
            if (retVal > -1) {
                return retVal;
            }
        } 
        
        return binarySearch(arr, mid, arr.length, key);
    }
    
    private static int binarySearch(int[] a, int fromIndex, int toIndex, int key) {
         int low = fromIndex;
         int high = toIndex - 1;
 
         while (low <= high) {
             int mid = (low + high) >>> 1;
             int midVal = a[mid];
 
             if (midVal < key)
                 low = mid + 1;
             else if (midVal > key)
                 high = mid - 1;
             else
                 return mid; // key found
         }
         return -(low + 1);  // key not found.
     }
}
