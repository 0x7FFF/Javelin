package com.smakhorin.easycodeandroidtask.main.domain;

import com.smakhorin.easycodeandroidtask.core.Callback0;
import com.smakhorin.easycodeandroidtask.core.Callback1;
import com.smakhorin.easycodeandroidtask.core.data.HandleError;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public interface Interactor {

    <T> void execute(
        Callback1<T> successful,
        Callable<T> block
    );

    abstract class Abstract implements Interactor {

        private final ThreadPoolExecutor executor = new ThreadPoolExecutor(
                4, 4, 100, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());

        private final ReentrantLock lock = new ReentrantLock();

        private final HandleError handleError;

        private CountDownLatch countDownLatch;

        public Abstract(HandleError handleError) {
            this.handleError = handleError;
            executor.prestartAllCoreThreads();
        }

        @Override
        public synchronized <T> void execute(Callback1<T> successful, Callable<T> block) {
            try {
                block.call();

                Future<T> futureResult = executor.submit(block);

                final T result = futureResult.get();

                successful.onSuccess(result);
            } catch (Exception e) {
                handleError.handle(e);
            }
        }
    }
}
