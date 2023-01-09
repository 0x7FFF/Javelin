package com.smakhorin.easycodeandroidtask.core.presentation;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;

public class BaseThread extends Thread {
    private final Lock lock;

    private final Runnable target;

    public BaseThread(Runnable target, Lock scope) {
        this.target = target;
        this.lock = scope;
    }

    @Override
    public void run() {
        lock.lock();
        try {
            target.run();
        } finally {
            lock.unlock();
        }
    }

    @Override
    public synchronized void start() {
        super.start();
    }
}
