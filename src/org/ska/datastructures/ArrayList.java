package org.ska.datastructures;

import java.util.Arrays;

public class ArrayList<T> {
    
    Object[] value = new Object[0];
    int count = 0;
    
    public int indexOf(Object o) {
        
        for(int i=0; i<count; i++) {
            if (o.equals(value[i])) {
                return i;
            }
        }
        
        return -1;
    }
    
    public void add(T element) {
        ensureCapacityInternal(count + 1);
        
        value[count] = element;
        count = count + 1;
    }
    
    public void add(int index, T element) {
        
    }
    
    private void ensureCapacityInternal(int minimumCapacity) {
        if (minimumCapacity - value.length > 0) {
            expandCapacity(minimumCapacity);
        }
   }
   
   private void expandCapacity(int minimumCapacity) {
        int newCapacity = value.length * 2 + 2;
        if (newCapacity - minimumCapacity < 0)
            newCapacity = minimumCapacity;
        if (newCapacity < 0) {
            if (minimumCapacity < 0) // overflow
                throw new OutOfMemoryError();
            newCapacity = Integer.MAX_VALUE;
        }
        value = Arrays.copyOf(value, newCapacity);
   }
}
