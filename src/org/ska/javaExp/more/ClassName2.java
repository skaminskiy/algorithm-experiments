package org.ska.javaExp.more;

import java.rmi.RemoteException;
import org.ska.javaExp.ClassName;

public class ClassName2 extends ClassName {
    private int size = 0;

    public void setSize(int value) {
        this.size = value;
    }

    public int getSize() {
        return this.size;
    }
}
