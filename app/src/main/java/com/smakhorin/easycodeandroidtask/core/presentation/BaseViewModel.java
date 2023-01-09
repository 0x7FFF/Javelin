package com.smakhorin.easycodeandroidtask.core.presentation;

import android.os.Handler;
import android.os.Looper;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import com.smakhorin.easycodeandroidtask.core.Callback0;
import com.smakhorin.easycodeandroidtask.core.communication.Communication;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BaseViewModel<T> extends ViewModel implements Communication.Observe<T> {

    protected Communication.Mutable<T> communication;

    private final Lock viewModelScopeLock = new ReentrantLock();

    private final Handler handler = new Handler(Looper.getMainLooper());

    private CountDownLatch countDownLatch;

    public BaseViewModel(Communication.Mutable<T> communication) {
        this.communication = communication;
    }

    @Override
    public void observe(LifecycleOwner owner, Observer<T> observer) {
        communication.observe(owner, observer);
    }

    protected void handle(int numberOfOperations, Callback0 atFinish, @NonNull Runnable... block) {
        countDownLatch = new CountDownLatch(numberOfOperations);
        for (Runnable runnable : block) {
            new BaseThread(() -> {
                runnable.run();
                countDownLatch.countDown();
            }, viewModelScopeLock).start();
        }
        new Thread(() -> {
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            atFinish.onSuccess();
        }).start();
    }

    protected void postOnMainThread(Runnable block) {
        handler.post(block);
    }
}
