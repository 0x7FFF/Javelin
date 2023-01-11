package com.smakhorin.easycodeandroidtask.core;

import org.json.JSONException;

import java.io.IOException;

public interface Result<T> {
    T get() throws JSONException, IOException;
}
