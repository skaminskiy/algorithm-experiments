package org.ska.algorithms.sorting;

public class SparseSearch {
    public static int getIndex(String value, String[] arr) {
        
        int start = 0;
        int end = arr.length;
        
        while(true) {
            
            int mid = (start + end) / 2;
            
            if (start == end) {
                if (arr[mid].equals(value)) {
                    return mid;
                } else {
                    return -1;
                }
            }
            if (end - start == 1) {
                if (end != mid && arr[end].equals(value)) {
                    return end;
                }
                if (start != mid && arr[start].equals(value)) {
                    return start;
                }
                return -1;
            }
            
            
            int left = mid;
            int right = mid;
            
            if (arr[mid].isEmpty()) {
                while(arr[left].isEmpty() && left > start) {
                    left = left - 1;
                }
                
                if (!arr[left].isEmpty()) {
                    if (arr[left].equals(value)) {
                        return left;
                    }
                    
                    if (arr[left].compareTo(value) > 0)  {
                        end = left - 1;
                    } else {
                        start = mid + 1;
                    }
                    continue;
                } else {
                    start = mid + 1;
                }
            }

            if (arr[mid].equals(value)) {
                return mid;
            }
            
            if (arr[mid].compareTo(value) > 0)  {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
            

        }
    }
}
