package com.smakhorin.easycodeandroidtask.core.data;

import androidx.annotation.Nullable;

public class TestException extends Exception {
    @Nullable
    @Override
    public String getMessage() {
        return "Test";
    }
}

