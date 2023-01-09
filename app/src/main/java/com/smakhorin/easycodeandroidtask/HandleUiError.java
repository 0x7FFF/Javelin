package com.smakhorin.easycodeandroidtask;

import com.smakhorin.easycodeandroidtask.core.ResourceManager;
import com.smakhorin.easycodeandroidtask.core.communication.GlobalErrorCommunication;

public class HandleUiError extends HandleUiErrorAbstract {

    public HandleUiError(ResourceManager resourceManager, GlobalErrorCommunication.Update globalErrorCommunication) {
        super(resourceManager, globalErrorCommunication);
    }

}
