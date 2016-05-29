package com.mygaienko.rt_system.model;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by enda1n on 29.05.2016.
 */
public class Lock {

    private static ReentrantLock lock = new ReentrantLock();

    public static void lock() {
        lock.lock();
    }

    public static void releaseLock() {
        lock.unlock();
    }
}
