package org.longjiahao.notes.designPattens;

/**
 * DCL double check lock
 * 需要加volatile防止指令重排序
 */
public class SingleTonTest03 {

    private volatile static SingleTonTest02 INSTANCE;

    public SingleTonTest02 getInstance() {
        if (INSTANCE == null) {
            synchronized (SingleTonTest03.class) {
                if (INSTANCE == null) {
//                    try {
//                        Thread.sleep(1);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                    INSTANCE = new SingleTonTest02();
                }

            }
        }
        return INSTANCE;
    }
}
