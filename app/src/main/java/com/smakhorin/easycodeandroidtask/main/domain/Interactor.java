package com.smakhorin.easycodeandroidtask.main.domain;

import com.smakhorin.easycodeandroidtask.core.Callback1;
import com.smakhorin.easycodeandroidtask.core.data.HandleError;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public interface Interactor {

    <T> void execute(
        Callback1<T> successful,
        Callable<T> block
    );

    abstract class Abstract implements Interactor {

        private final ThreadPoolExecutor executor;

        private final HandleError handleError;

        public Abstract(HandleError handleError) {
            this(handleError, new ThreadPoolExecutor(4, 4, 100, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>()));
        }

        public Abstract(HandleError handleError, ThreadPoolExecutor threadPoolExecutor) {
            this.handleError = handleError;
            this.executor = threadPoolExecutor;
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
