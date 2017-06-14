//package org.ska.algorithms.dynamicprogramming;
//
//import java.util.ArrayList;
//
//public class PermutationsWithDups {
//    
//    public static void main(String[] args) {
//        
//        printPermutations2(new Character[]{'A', 'A', 'B', 'A'});
//        
//        //printPermutations2(new Character[]{'A', 'A', 'A', 'B'});
//        
//        //permutation("AAAB");
//    }
//    
//    static void printPermutations2(Character[] characters) {
//        
//        ArrayList<StringBuilder> permutations = new ArrayList<StringBuilder>(); 
//        ArrayList<StringBuilder> result = new ArrayList<StringBuilder>();
//
//        for (int i = 0; i < characters.length; i ++) {
//            Character currentCharacter = characters[i];
//            
//            permutations = result;
//            result = new ArrayList<StringBuilder>();
//            
//            if (permutations.size() == 0) {
//                result.add(new StringBuilder(characters[i].toString()));
//            }
//            
//            for (int j = 0; j < permutations.size(); j ++) {
//                StringBuilder permutation = permutations.get(j); 
//                for (int y = 0; y <= permutation.length(); y++) {
//                    
//                    StringBuilder subList = new StringBuilder(permutation);
//                    
////                    if (subList.length() > 0 && (y - 1) > -1 && subList.charAt(y - 1) == currentCharacter) {
////                        continue;
////                    }
//                    
//                    subList.insert(y, currentCharacter);
//                    
//                    result.add(subList);
//                }
//            }
//        }
//
//      for (StringBuilder item : result) {
//          System.out.println(item.toString());
//      }
//    }
//    
//    static void permutation(String str) {
//        permutation(str, "");
//    }
//    
//    static void permutation(String str, String prefix) {
////        if (str.length() == 0) {
////            System.out.println(prefix);
////        } else {
////            for (int i = 0; i < str.length(); i++) {
////                String rem = str.substring(0, i) + str.substring (i + 1);
////                permutation(rem, prefix + str.charAt(i));
////            }
////        }
//    }
//}
