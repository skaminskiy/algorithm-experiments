package org.ska.datastructures.ArrayAndString;

public class StringExp {
    static boolean isUnique(String str) {
        return false;
    }
    
    static boolean checkPermutation(String str1, String str2) {
        
        return false;
    }
    
    static String URLify(String str) {
        
        if(str == null) {
            return "";
        }
        
        char[] arr = str.toCharArray();
        
        int index = 0;
        int newIndex = arr.length-1;
        for(int i=arr.length-1; i>=0; i--) {
            if(!Character.isWhitespace(arr[i])) {
                index = i; //find first not empty character from the end of a string
                break;
            }
        }
        
        for(int j=index; j>=0; j--) {
            if(Character.isWhitespace(arr[j])) {
                arr[newIndex] = '0';
                arr[newIndex - 1] = '2';
                arr[newIndex - 2] = '%';
                newIndex = newIndex - 3;
            } else {
                arr[newIndex] = arr[j];
                newIndex = newIndex - 1;
            }
        }

        return new String(arr, 7, 9);
    }
}
