package com.smakhorin.easycodeandroidtask.core.domain;

import com.smakhorin.easycodeandroidtask.core.data.HandleError;

public class HandleDomainError implements HandleError {
    @Override
    public Exception handle(Exception error) {
        return error;
    }
}
