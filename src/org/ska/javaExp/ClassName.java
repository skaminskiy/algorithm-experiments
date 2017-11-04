package org.ska.javaExp;

import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class ClassName implements Cloneable {

//    public ClassName() {
//        //names = Arrays.asList("global", "relay");
//    }
//
    public void deposit(int amount) { //

        int visited[][] = new int[2][3];

        if (visited[0][0] >= 1) {
            System.out.println("!!!");
        }

        Stack<String> fgdsf = new Stack<>();

        // Method implementation
        //throw new RemoteException();
     }
//
//    //private final List<String> names = Arrays.asList("global", "relay");
//
//    public void deposit2(List<String> newnames) { //
//
//        //names = newnames;
//     }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
