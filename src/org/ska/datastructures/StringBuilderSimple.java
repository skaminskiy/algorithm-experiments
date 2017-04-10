package org.ska.datastructures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringBuilderSimple {
    
    private ArrayList<String> list = new ArrayList<String>();
    
    public StringBuilderSimple append(char[] str) {
        list.add(new String(str));
        
        return this;
    }
    
    public StringBuilderSimple append(String str) {
        list.add(str);
        
        return this;
    }
    
    private int getCount() {
        int count = 0;
        for(int x=0; x<list.size(); x++) {
            count = count + list.get(x).length();
        }
        
        return count;
    }
    
    public String toString() {
        
        char[] result = new char[getCount()];
         
        int index = 0;
        
        for(int i=0; i<list.size(); i++) {
            
            char[] subResult = list.get(i).toCharArray();
            
            System.arraycopy(subResult, 0, result, index, subResult.length);
            index = index + subResult.length;
            
            
//            for(int j=0; j<list.get(i).length(); j++) {
//                result[index] = list.get(i).charAt(j);
//                index = index + 1;
//            }
        }
        
        return new String(result);
    }
}
