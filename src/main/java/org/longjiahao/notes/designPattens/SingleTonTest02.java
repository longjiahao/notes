package org.longjiahao.notes.designPattens;

public class SingleTonTest02 {

    private static SingleTonTest02 INSTANCE;


    public SingleTonTest02 getInstance() {
        if (INSTANCE == null) {
//            try {
//                Thread.sleep(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            INSTANCE = new SingleTonTest02();
        }
        return INSTANCE;
    }
}
