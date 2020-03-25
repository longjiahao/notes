package org.longjiahao.notes.juc;


/**
 * 缓存行对齐测试
 */
public class CacheLineTest01 {

    private volatile static long x1, x2, x3, x4, x5, x6, x7;

    private volatile static long x = 0L;

    private volatile static long y1, y2, y3, y4, y5, y6, y7;

    private volatile static long y = 0L;


    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() -> {
            for (; x < 1000_0000L; ) {
                x++;
            }
        });

        Thread t2 = new Thread(() -> {
            for (; y < 1000_0000L; ) {
                y++;
            }
        });

        Long start = System.currentTimeMillis();
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(System.currentTimeMillis() - start);
    }

}
