package com.smakhorin.easycodeandroidtask.core;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.RawRes;
import androidx.annotation.StringRes;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public interface ResourceManager {
    String string(@StringRes int id);

    InputStream rawFile(@RawRes int id);

    class Base implements ResourceManager {

        private final Context context;

        public Base(@NonNull Context context) {
            this.context = context;
        }

        @Override
        public String string(int id) {
            return context.getString(id);
        }

        @Override
        public InputStream rawFile(int id) {
            return context.getResources().openRawResource(id);
        }
    }

    class Fake implements ResourceManager {

        private static final String TEST_JSON = "\"name\":\"John\",\"age\":30,\"city\":\"New York\"";

        @Override
        public String string(int id) {
            return "any";
        }

        @Override
        public InputStream rawFile(int id) {
            return new ByteArrayInputStream(TEST_JSON.getBytes());
        }
    }
}
