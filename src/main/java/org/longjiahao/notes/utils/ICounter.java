package org.longjiahao.notes.utils;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 通用计数器模块接口ICounter，用于系统内部的请求量计数，
 * 多个线程会频繁调用hit()方法进行计数
 *
 * 请实现ICounter接口(请关注接口实现，不需要写测试用例)，并满足以下要求：
 *  1.功能实现(不使用redis等外部存储)
 *  2.性能问题
 *  3.线程安全
 *  4.连续运行一年，内存不溢出
 */

interface ICounter {
    // 调用一次，计数加1
    void hit();

    // 获取当前的计数统计状态
    StatData getStat();
}

class StatData {
    // 最近10秒的每秒平均计数量
    public long last10SecondAverage;

    // 最近10分钟的每分钟平均计数量
    public long last10MinuteAverage;

    // 最近60分钟的每分钟平均计数量
    public long last60MinuteAverage;

    // 最近60秒的每秒计数量的集合
    public List<Long> last60SecondHistory;

}

// TODO 请实现ICounter接口，(请关注接口实现，不需要写测试用例!!!)

class ICounterImpl implements ICounter {

    private volatile long count;

    private volatile long averageCount;

    private volatile StatData statData;

    long last10SecondAverageBegin = System.currentTimeMillis();
    long last10MinuteAverageBegin = System.currentTimeMillis();
    long last60MinuteAverageBegin = System.currentTimeMillis();
    long last60SecondHistoryBegin = System.currentTimeMillis();

    @Override
    public synchronized void hit() {
        averageCount++;
        StatData statData = getStat();

        if (System.currentTimeMillis() - last10SecondAverageBegin < 1000 * 10) {
            statData.last10SecondAverage += averageCount;
            averageCount = 0;
        } else {
            last10SecondAverageBegin = System.currentTimeMillis() - 1000 * 10;
        }

        if (System.currentTimeMillis() - last10MinuteAverageBegin < 1000 * 10 * 60) {
            statData.last10MinuteAverage += averageCount;
            averageCount = 0;
        } else {
            last10MinuteAverageBegin = System.currentTimeMillis() - 1000 * 10 * 60;
        }

    }

    @Override
    public StatData getStat() {
        if (statData != null) {
            return statData;
        } else {
            return new StatData();
        }
    }



}
