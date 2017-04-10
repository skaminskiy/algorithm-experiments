package org.ska.datastructures.ArrayAndString;

public class Tester {
public static void main(String[] args) {

        System.out.println(StringExp.URLify("Mr John Smith    ")); //"Mr%20John%20Smith"
        System.out.println(StringExp.URLify(" Mr Smith    ")); //"%20Mr%20Smith"
        System.out.println(StringExp.URLify("   ")); //"%20"
        System.out.println(StringExp.URLify(null)); //""
   }
}
