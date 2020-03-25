package org.longjiahao.notes.designPattens;

public class SingleTonTest01 {

    private static SingleTonTest01 INSTANCE = new SingleTonTest01();


    public SingleTonTest01 getInstance() {
        return INSTANCE;
    }
}
