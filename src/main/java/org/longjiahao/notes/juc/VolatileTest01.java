package org.longjiahao.notes.juc;

/**
 * 指令重排序测试
 */
public class VolatileTest01 {


    private static int x, y;

    private static int a, b;


    public static void main(String[] args) throws InterruptedException {
        int i = 0;
        for (; ; ) {
            x = 0;
            y = 0;
            a = 0;
            b = 0;
            i++;
            Thread t1 = new Thread(() -> {
                a = 1;
                y = b;
            });

            Thread t2 = new Thread(() -> {
                b = 1;
                x = a;
            });
            t1.start();
            t2.start();
            t1.join();
            t2.join();

            if (x == 0 && y == 0) {
                System.out.println("第" + i + "出现指令重排序");
                break;
            }
        }

        System.out.println("main方法执行结束");
    }

}
