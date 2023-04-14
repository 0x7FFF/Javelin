package com.smakhorin.easycodeandroidtask.core;

import android.os.Build;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import java.util.concurrent.atomic.AtomicBoolean;

public class SingleLiveEvent<T> extends MutableLiveData<T> {

    AtomicBoolean mPending = new AtomicBoolean(false);

    @RequiresApi(api = Build.VERSION_CODES.N)
    @MainThread
    @Override
    public void observe(@NonNull LifecycleOwner owner, @NonNull Observer<? super T> observer) {
        super.observe(
            owner,
            (Observer<T>) (t -> {
                if (mPending.compareAndSet(true, false)) {
                    observer.onChanged(t);
                }
            })
        );
    }

    @MainThread
    @Override
    public void setValue(T value) {
        mPending.set(true);
        super.setValue(value);
    }
}
