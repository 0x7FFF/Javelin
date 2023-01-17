package com.smakhorin.easycodeandroidtask.core.data;

import androidx.annotation.Nullable;

public interface HandleError {
    Exception handle(Exception error);

    class Fake implements HandleError {

        @Override
        public Exception handle(Exception error) {
            return new TestException();
        }
    }
}

