package org.ska.algorithms.dynamicprogramming;

import java.util.ArrayList;
import java.util.HashMap;

public class TripleStep {
    public static void main(String[] args) {
        //System.out.println("resilt:" + countPossibleWaysBruteForse(4, "")); //
        
        //countPossibleWays(4, "");
        
        System.out.println("resilt:" + countPossibleWaysIteractive(7));
    }

    static int countPossibleWaysBruteForse(int n, String result) {
         
        if (n == 0) {
            System.out.println(result);
            return 1;
        }
        
        if (n < 0) {
            return 0; 
        }

        int count = 0;
        
        for (int i = 1; i <= 3; i++) {
            
            count = count + countPossibleWaysBruteForse(n - i, result + ";" + Integer.toString(i));
            
        }
        
        return count;
    }
    

    static int countPossibleWays(int n, HashMap<Integer, Integer> map, String result) {
        
       
        if (n == 0) {
            System.out.println(result);
            return 1;
        }
        
        if (n < 0) {
            return 0; 
        }

        int count = 0;
        
        for (int i = 1; i <= 3; i++) {
            
            if (map.containsKey(n - i)) {
                count = count + map.get(n - i);
            } else {
                int newCount = countPossibleWays(n - i, map, result + ";" + Integer.toString(i));
                map.put(n - i, newCount);
                
                count = count + newCount; 
            }

        }
        
        return count;
    }
    
    static int countPossibleWaysIteractive(int n) {
      
      int count = 0;
      ArrayList<Integer> list = new ArrayList<Integer>();
        
      for (int i = 1; i <= n; i++) {
          count = 0;
          
          for (int j = 1; j <= 3; j++) {
              
              if (j == i) {
                  count = count + 1;
              }
              
              for (int x = 0; x < list.size(); x++) {
                    if (x + 1 + j == i) {
                        count = count + list.get(x);
                    }
                  
              }
              
          }
          
          list.add(count);
      }
        
      return count;
    }
}
