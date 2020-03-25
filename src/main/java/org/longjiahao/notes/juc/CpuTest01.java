package org.longjiahao.notes.juc;

import java.io.IOException;
import java.net.URL;

public class CpuTest01 {


    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    /**
                     * 简单代码只会用到单核
                     */
//                    System.out.println(Thread.currentThread().getName());
                    /**
                     * 复杂代码会用到多核
                     */
                    URL url = null;
                    try {
                        url = new URL("https://www.baidu.com");
                        System.out.println(url.getContent());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        Thread t1 = new Thread(runnable, "Thread01");
        Thread t2 = new Thread(runnable, "Thread02");
        Thread t3 = new Thread(runnable, "Thread03");
        Thread t4 = new Thread(runnable, "Thread04");
        Thread t5 = new Thread(runnable, "Thread05");
        Thread t6 = new Thread(runnable, "Thread06");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();


    }


}
