package org.ska.datastructures.ArrayAndString;

public class StringCompression {
    public static void main(String[] args) {

        System.out.println(StringCompression.compress("aabcccccaaa")); //a2b1c5a3
        System.out.println(StringCompression.compress("acb")); //acb
        System.out.println(StringCompression.compress("acc")); //acc
        System.out.println(StringCompression.compress("aAbcccCCCCaaa")); //a1A1b1c3C4a3
//        System.out.println(StringCompression.compress("   ")); // ""
        System.out.println(StringCompression.compress("aabcccccccccccc")); //a2bc12
        
        System.out.println(StringCompression.compress("")); // ""
        System.out.println(StringCompression.compress(null)); // null
   }
    
    static String compress(String str) {
        
        if (str == null || str.isEmpty()) {
            return str;
        }
        
        char[] result = new char[str.length()];
        
        int index = 0;
        int resltIndex = 0;
        while(index < str.length()) {
            
            char currentCharacter = str.charAt(index);
            int count = StringCompression.getCharactersCount(str, index, currentCharacter);
            
            ResultOfAddingCharacters resultOfAddingCharacters = StringCompression.addCharacters(result, resltIndex, currentCharacter, count);
            if (!resultOfAddingCharacters.result) {
                return str; //compressed string is too long
            }
            resltIndex = resultOfAddingCharacters.index; 
            index = index + count;
        }
        
        return new String(result);
    }
    
    static int getCharactersCount(String str, int index, char character) {
        int count = 0;
        for(int i=index; i<str.length(); i++) {
            if (character != str.charAt(i)) {
                return count;
            }
            
            count = count + 1;
        }
        
        return count;
    }
    
    static ResultOfAddingCharacters addCharacters(char[] result, int index, char character, int count) {
        if (index >= result.length) {
            return new ResultOfAddingCharacters(false, 0);
        }
        result[index] = character;
        index = index + 1;
        
        char[] singleNumbers = new char[countSingleNumbers(count)];
        if (index + singleNumbers.length >= result.length) {
            return new ResultOfAddingCharacters(false, 0);
        }
        
        
        while(count > 0) {
          result[index] = String.valueOf((count % 10)).charAt(0);
          count = Math.abs(count / 10);
        }
        
        return new ResultOfAddingCharacters(true, index);
    }
    
//    static int countSingleNumbers(int number) {
//        int count = 0;
//        while(number > 0) {
//            number = Math.abs(count / 10);
//            count = count + 1;
//          }
//        return count;
//    }
    
    static int countSingleNumbers(int number) {
        int count = 0;
        while(number > 0) {
            number = Math.abs(count / 10);
            count = count + 1;
          }
        return count;
    }
    
    static class ResultOfAddingCharacters {
        public boolean result;
        public int index = 0;
        
        public ResultOfAddingCharacters(boolean result, int index) {
            this.result = result;
            this.index = index;
        }
    }
}
