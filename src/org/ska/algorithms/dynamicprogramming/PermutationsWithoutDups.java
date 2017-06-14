package org.ska.algorithms.dynamicprogramming;

import java.util.ArrayList;

public class PermutationsWithoutDups {
    public static void main(String[] args) {
        //printPermutations(new Character[]{'A', 'B', 'C'}, new ArrayList<StringBuilder>(), 0);
        
        //printPermutations2(new Character[]{'A', 'B', 'C'});
        
        permutation("ABC");
    }
    
    static void printPermutations(Character[] characters, ArrayList<StringBuilder> permutations, int index) {
        
        if (characters.length == index) {
            for (StringBuilder item : permutations) {
                System.out.println(item.toString());
            }
            return;
        }
        
        ArrayList<StringBuilder> list = new ArrayList<StringBuilder>();
        
        if (permutations.size() == 0) {
            list.add(new StringBuilder(characters[index].toString()));
        }
        
        Character currentCharacter = characters[index];
        for (int i = 0; i < permutations.size(); i ++) {
            StringBuilder permutation = permutations.get(i); 
            for (int j = 0; j <= permutation.length(); j++) {
                
                StringBuilder subList = new StringBuilder(permutation);
                subList.insert(j, currentCharacter);
                
                list.add(subList);
            }
        }
        

        printPermutations(characters, list, index + 1);
    }
    
    
    static void printPermutations2(Character[] characters) {
        
        ArrayList<StringBuilder> permutations = new ArrayList<StringBuilder>(); 
        ArrayList<StringBuilder> result = new ArrayList<StringBuilder>();

        for (int i = 0; i < characters.length; i ++) {
            Character currentCharacter = characters[i];
            
            permutations = result;
            result = new ArrayList<StringBuilder>();
            
            if (permutations.size() == 0) {
                result.add(new StringBuilder(characters[i].toString()));
            }
            
            for (int j = 0; j < permutations.size(); j ++) {
                StringBuilder permutation = permutations.get(j); 
                for (int y = 0; y <= permutation.length(); y++) {
                    
                    StringBuilder subList = new StringBuilder(permutation);
                    subList.insert(y, currentCharacter);
                    
                    result.add(subList);
                }
            }
        }

      for (StringBuilder item : result) {
          System.out.println(item.toString());
      }
    }
    
    
    
    static void permutation(String str) {
        permutation(str, "");
    }
        
    static void permutation(String str, String prefix) {
        if (str.length() == 0) {
            System.out.println(prefix);
        } else {
            for (int i = 0; i < str.length(); i++) {
                String rem = str.substring(0, i) + str.substring (i + 1);
                permutation(rem, prefix + str.charAt(i));
            }
        }
    }
}
