package com.smakhorin.easycodeandroidtask.core.data;


public interface HandleError {
    Exception handle(Exception error);

    class Fake implements HandleError {

        @Override
        public Exception handle(Exception error) {
            return new TestException();
        }
    }
}

