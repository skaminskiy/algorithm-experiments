package org.ska.datastructures.ArrayAndString;

public class StringRotation {
    
    public static void main(String[] args) {

    
    System.out.println(checkRotation("waterbottle", "erbottlewat")); //true
    System.out.println(checkRotation("erbottlewat", "waterbottle")); //true
    System.out.println(checkRotation("waterbottle", "waterbottle")); //true
    System.out.println(checkRotation("waterbottle", "aterbottlew")); //true
    System.out.println(checkRotation("waterbottll", "erbottlewat")); //false
    System.out.println(checkRotation("waterbottle", "erbottlewat ")); //false
    System.out.println(checkRotation("waterbottll", "")); //false
    System.out.println(checkRotation("", "")); //false
    System.out.println(checkRotation(null, null)); //false

   }
    
    
    static boolean checkRotation(String str1, String str2) {
        
        if (str1 == null || str1.isEmpty() || str2 == null || str2.isEmpty()) {
            return false;
        }
        if (str1.length() != str2.length()) {
            return false;
        }
        
        //loop str1
        ////find split
        //check second part

//        int splitIndex = findSplit(str1, str2);
//        if (splitIndex < 0) {
//            return false;
//        }
        
        return isSubString(str1 + str1, str2);
    
        //return isSubString(str1.substring(splitIndex + 1, str1.length()-1), str2);
    }
    
//    static int findSplit(String str1, String str2) {
//        
//          int index = 0;
//          while(index < str1.length()) {
//              
//              if (isSubString(str1.substring(index, str1.length() - 1), str2)) {
//                  return index;
//              }
//              
//              index = index + 1;
//          }
//        
//        return -1;
//    }
    
    static boolean isSubString(String str1, String str2) {
        return str1.indexOf(str2) > -1;
    }
}
