package com.smakhorin.easycodeandroidtask.core.data;

import android.os.Build;

import androidx.annotation.RequiresApi;

import org.json.JSONException;

public class TestJSONException extends JSONException {

    public TestJSONException() {
        super("Test");
    }

    public TestJSONException(String s) {
        super(s);
    }

    @RequiresApi(api = Build.VERSION_CODES.O_MR1)
    public TestJSONException(String message, Throwable cause) {
        super(message, cause);
    }

    @RequiresApi(api = Build.VERSION_CODES.O_MR1)
    public TestJSONException(Throwable cause) {
        super(cause);
    }
}
