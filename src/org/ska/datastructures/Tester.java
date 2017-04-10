package org.ska.datastructures;

import java.util.HashMap;

public class Tester {
    public static void main(String[] args) {
        
        
//        StringBuilder builder = new StringBuilder();
//        builder.append(new char[] {'f', 'u'});
//        builder.append("world");
//        
//        builder.replace(3, 6, "xxx");
//        
//        System.out.println(builder.toString());
        
        
//        ArrayList<Integer> list = new ArrayList<Integer>();
//        
//        Integer obj1 = 1;
//        Integer obj2 = 2;
//        Integer obj3 = 3;
//        
//        list.add(obj1);
//        list.add(obj2);
//        list.add(obj3);
//        
//        
//        System.out.println(list.indexOf(obj2));
        
  MyHashMap<Integer, String> list = new MyHashMap<Integer, String>();
        
        Integer obj1 = 1;
        Integer obj2 = 2;
        Integer obj3 = 3;
        
        
        for (int i=0; i<1000; i ++) {
            list.put(i, String.valueOf(i));
        }
        
        list.put(null, "-1");
        
//        list.put(1, "ddd");
//        list.put(2, "aaa");
//        list.put(2, "aaa2");
//        list.put(3, "fff");
        
        
        System.out.println(list.get(null));
        
        
        
     }

}
