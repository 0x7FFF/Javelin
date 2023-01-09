package com.smakhorin.easycodeandroidtask.core;

import org.json.JSONException;

import java.io.IOException;

public interface Supplier<T> {
    T get() throws JSONException, IOException;
}
