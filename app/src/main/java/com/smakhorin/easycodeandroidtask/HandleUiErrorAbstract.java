package com.smakhorin.easycodeandroidtask;

import androidx.annotation.StringRes;

import com.smakhorin.easycodeandroidtask.core.ResourceManager;
import com.smakhorin.easycodeandroidtask.core.communication.GlobalErrorCommunication;
import com.smakhorin.easycodeandroidtask.core.data.HandleError;

import org.json.JSONException;

import java.io.IOException;

abstract public class HandleUiErrorAbstract implements HandleError {
    private final ResourceManager resourceManager;
    private final GlobalErrorCommunication.Update globalErrorCommunication;
    private final HandleGenericUiError handleGenericUiError;

    protected HandleUiErrorAbstract(ResourceManager resourceManager, GlobalErrorCommunication.Update globalErrorCommunication) {
        this.resourceManager = resourceManager;
        this.globalErrorCommunication = globalErrorCommunication;
        handleGenericUiError = new HandleGenericUiError(resourceManager, globalErrorCommunication);
    }

    @StringRes
    protected int jsonExceptionMessage = R.string.json_error_message;

    @StringRes
    protected int ioExceptionMessage = R.string.io_error_message;

    @Override
    public Exception handle(Exception error) {
        int messageId = 0;

        //Switch is not available in Java 8.
        if (error instanceof JSONException) {
            messageId = jsonExceptionMessage;
        } else if (error instanceof IOException) {
            messageId = ioExceptionMessage;
        }

        error.printStackTrace(); // Print annyway!

        if (messageId == 0) {
            return handleGenericUiError.handle(error);
        } else {
            globalErrorCommunication.map(resourceManager.string(messageId));
            return error;
        }
    }
}

class HandleGenericUiError implements HandleError {

    private final ResourceManager resourceManager;
    private final GlobalErrorCommunication.Update globalErrorCommunication;

    public HandleGenericUiError(ResourceManager resourceManager, GlobalErrorCommunication.Update globalErrorCommunication) {
        this.resourceManager = resourceManager;
        this.globalErrorCommunication = globalErrorCommunication;
    }

    @Override
    public Exception handle(Exception error) {
        globalErrorCommunication.map(resourceManager.string(R.string.unexpected_error_message));
        return error;
    }
}

