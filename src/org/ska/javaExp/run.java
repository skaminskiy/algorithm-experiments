package org.ska.javaExp;

import java.util.Hashtable;
import org.ska.javaExp.more.ClassName2;

public class run {
    public static void main(String[] args) throws CloneNotSupportedException {

        Hashtable<Integer,String> myTable= new Hashtable<Integer,String>();
        myTable.put(1, "John");
        myTable.put(1, "John");
        //myTable.put(3, null); /* NullPointerEcxeption at runtime*/
        System.out.println(myTable.get(1));
        System.out.println(myTable.get(2));
        //System.out.println(myTable.get(3));

//        ClassName name = new ClassName();
//        name.deposit(1);
//        ClassName2 name2 = new ClassName2();
//
//        //name2.setSize(1);
//
//        System.out.println(((ClassName2)name2.clone()).equals(name));
    }
}
