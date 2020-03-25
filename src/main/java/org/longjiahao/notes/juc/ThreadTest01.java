package org.longjiahao.notes.juc;

public class ThreadTest01 {


    private static Integer num = 50;


    public static void main(String[] args) {


        for (int i = 0; i < 50; i++) {
            Thread thread = new Thread(() -> {
                if (num > 0) {
                    System.out.println("线程"+ Thread.currentThread().getName() +"成功售票，余票为：" + --num);
                }
            });
            thread.start();
        }

    }
}
