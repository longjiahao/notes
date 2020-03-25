package org.longjiahao.notes.jvm;

import org.openjdk.jol.info.ClassLayout;

/**
 * Object o = new Object();
 * 该段代码的对象在堆里占用了多少内存
 */
public class HeapTest01 {


    public static void main(String[] args) {
        Object o = new Object();
        System.out.println(ClassLayout.parseInstance(o).toPrintable(o));
    }

}
