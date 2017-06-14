package org.ska.algorithms.dynamicprogramming;

import java.util.ArrayList;

public class Parens {
      
    public static void main(String[] args) {
      
        print(3);
    }
    
    static void print(int count) {
        
//        ArrayList<StringBuilder> result = getChilds(count);
//        
//        for (StringBuilder item: result) {
//            System.out.println(item.toString());
//            System.out.println("----");
//        }
        
        ArrayList<String> result = generateParens(count);
        
      for (String item: result) {
          System.out.println(item);
      }
    }
    
    static ArrayList<StringBuilder> getChilds(int count) {
        
        ArrayList<StringBuilder> result = new ArrayList<StringBuilder>(); 
        
        if (count == 0) {
            return result;
        }
        
        ArrayList<StringBuilder> childsResult = getChilds(count - 1);
        
        if (childsResult.size() == 0) {
            result.add(new StringBuilder("()"));
        }
        
        for (int i = 0; i < childsResult.size(); i++) {
            
            StringBuilder builder = new StringBuilder("(" + childsResult.get(i).toString() + ")");
            result.add(builder);
            
            result.add(new StringBuilder("()" + childsResult.get(i).toString()));
            result.add(new StringBuilder(childsResult.get(i).toString() + "()"));
            
        }
        
        return result;
    }
    
    static String getString(ArrayList<StringBuilder> list) {
        
        StringBuilder result = new StringBuilder();
        
        for (StringBuilder item: list) {
            result.append(item.toString());
        }
        
        return result.toString();
    }
    
    
    
    static void addParen(ArrayList<String> list, int leftRem, int rightRem, char[] str, int index) {
         if (leftRem < 0 || rightRem < leftRem) return; // invalid state
            
         if (leftRem == 0 && rightRem == 0) {
             list.add(String.copyValueOf(str));
         } else {
             str[index] = '(';
             addParen(list, leftRem - 1, rightRem, str, index + 1);
        
             str[index] = ')';
             addParen(list, leftRem, rightRem - 1, str, index + 1);
         }
    }
            
    static ArrayList<String> generateParens(int count) {
         char[] str = new char[count*2];
         ArrayList<String> list = new ArrayList<String>();
         addParen(list, count, count, str, 0);
         return list;
    }
}
