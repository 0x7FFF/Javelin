package com.smakhorin.easycodeandroidtask.core;

public interface Mapper<S, R> {
    R map(S data);

    interface Unit<T> extends Mapper<T, Void> {}
}
