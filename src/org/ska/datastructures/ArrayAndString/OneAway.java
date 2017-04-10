package org.ska.datastructures.ArrayAndString;

public class OneAway {
    
    public static void main(String[] args) {

        System.out.println(OneAway.oneAway("pale", "ple")); //true
        System.out.println(OneAway.oneAway("pales", "pale")); //true
        System.out.println(OneAway.oneAway("pale", "bale")); //true
        System.out.println(OneAway.oneAway("pale", "bake")); //false
        
        System.out.println(OneAway.oneAway("pale", "palepale")); //false
        System.out.println(OneAway.oneAway("", "f")); //true
        System.out.println(OneAway.oneAway(null, "f")); //false
   }
    
static boolean oneAway(String str1, String str2) {
        
        if (str1 == null || str2 == null) {
            return false;
        }
        if (Math.abs(str1.length() - str2.length()) > 1) {
            return false;
        }
        
        int index1 = 0;
        int index2 = 0;
        int count = 0;
        
        while(index1 < str1.length() || index2 < str2.length()) {
            
            if (count > 1) {
                return false;
            }
            
            if (index1 >= str1.length() || index2 >= str2.length()) {
                index1 = index1 + 1;
                index2 = index2 + 1;
                count = count + 1; //insert or delete
                if (count > 1) {
                    return false;
                }
                continue;
            }
            
            char char1 = str1.charAt(index1);
            char char2 = str2.charAt(index2);
            
            if (char1 == char2) {
                index1 = index1 + 1;
                index2 = index2 + 1;
                continue;
            }
            
            if (index2 + 1 < str2.length() && char1 == str2.charAt(index2 + 1)) {
                index2 = index2 + 1; 
                count = count + 1; //insert or delete
            } else if (index1 + 1 < str1.length() && char2 == str1.charAt(index1 + 1)) {
                index1 = index1 + 1;
                count = count + 1; //insert or delete
            } else {
                index1 = index1 + 1;
                index2 = index2 + 1;
                count = count + 1; //edit
            }
        }
        
        return true;
    }

//    static boolean oneAway(String str1, String str2) {
//        
//        if (str1 == null || str2 == null) {
//            return false;
//        }
//        if (Math.abs(str1.length() - str2.length()) > 1) {
//            return false;
//        }
//        
//        int index1 = 0;
//        int index2 = 0;
//        int count = 0;
//        
//        while(index1 < str1.length() || index2 < str2.length()) {
//            
//            if (count > 1) {
//                return false;
//            }
//            
//            if (index1 >= str1.length() || index2 >= str2.length()) {
//                index1 = index1 + 1;
//                index2 = index2 + 1;
//                count = count + 1; //insert or delete
//                if (count > 1) {
//                    return false;
//                }
//                continue;
//            }
//            
//            char char1 = str1.charAt(index1);
//            char char2 = str2.charAt(index2);
//            
//            if (char1 == char2) {
//                index1 = index1 + 1;
//                index2 = index2 + 1;
//                continue;
//            }
//            
//            if (index2 + 1 < str2.length() && char1 == str2.charAt(index2 + 1)) {
//                index2 = index2 + 1; 
//                count = count + 1; //insert or delete
//            } else if (index1 + 1 < str1.length() && char2 == str1.charAt(index1 + 1)) {
//                index1 = index1 + 1;
//                count = count + 1; //insert or delete
//            } else {
//                index1 = index1 + 1;
//                index2 = index2 + 1;
//                count = count + 1; //edit
//            }
//        }
//        
//        return true;
//    }
}
