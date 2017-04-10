package org.ska.datastructures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringBuilder {
    
    private char[] list = new char[0];
    private int count = 0;
    
    private void ensureCapacityInternal(int minimumCapacity) {
         if (minimumCapacity - list.length > 0) {
             expandCapacity(minimumCapacity);
         }
    }
    
    private void expandCapacity(int minimumCapacity) {
         int newCapacity = list.length * 2 + 2;
         if (newCapacity - minimumCapacity < 0)
             newCapacity = minimumCapacity;
         if (newCapacity < 0) {
             if (minimumCapacity < 0) // overflow
                 throw new OutOfMemoryError();
             newCapacity = Integer.MAX_VALUE;
         }
         list = Arrays.copyOf(list, newCapacity);
    }
    
    public StringBuilder append(char[] str) {
        int len = str.length;
        ensureCapacityInternal(count + len);
        System.arraycopy(str, 0, list, count, len);
        count += len;
        return this;
    }
    
    public StringBuilder append(String str) {
        
        if (str == null) str = "null";
         int len = str.length();
         ensureCapacityInternal(count + len);
         str.getChars(0, len, list, count);
         count += len;
         return this;
    }
    
    public String toString() {
        return new String(list, 0, count);
    }

    public StringBuilder replace(int start, int end, String str) {
        if (start < 0)
             throw new StringIndexOutOfBoundsException(start);
         if (start > count)
             throw new StringIndexOutOfBoundsException("start > length()");
         if (start > end)
             throw new StringIndexOutOfBoundsException("start > end");
 
         if (end > count)
             end = count;
         int len = str.length();
         int newCount = count + len - (end - start);
         ensureCapacityInternal(newCount);
 
         System.arraycopy(list, end, list, start + len, count - end);
         str.getChars(0, len, list, start);
         count = newCount;
         return this;
    }
    
}
