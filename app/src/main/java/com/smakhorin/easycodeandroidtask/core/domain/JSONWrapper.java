package com.smakhorin.easycodeandroidtask.core.domain;

import androidx.annotation.NonNull;

import com.smakhorin.easycodeandroidtask.core.data.TestJSONException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.util.Map;

public interface JSONWrapper {

    int getInt(@NonNull String name) throws JSONException;
    String getString(@NonNull String name) throws JSONException;
    boolean getBoolean(@NonNull String name) throws JSONException;
    JSONObject getJSONObject(@NonNull String name) throws JSONException;

    JSONWrapper getJSONWrapper(@NonNull String name) throws JSONException;

    JSONArray getJSONArray(@NonNull String name) throws JSONException;

    abstract class Abstract extends JSONObject implements JSONWrapper {
        public Abstract() {
            super();
        }

        public Abstract(@NonNull Map copyFrom) {
            super(copyFrom);
        }

        public Abstract(@NonNull JSONTokener readFrom) throws JSONException {
            super(readFrom);
        }

        public Abstract(@NonNull String json) throws JSONException {
            super(json);
        }

        public Abstract(@NonNull JSONObject copyFrom, @NonNull String[] names) throws JSONException {
            super(copyFrom, names);
        }

        @NonNull
        @Override
        public String getString(@NonNull String name) throws JSONException {
            return super.getString(name);
        }

        @Override
        public int getInt(@NonNull String name) throws JSONException {
            return super.getInt(name);
        }

        @Override
        public boolean getBoolean(@NonNull String name) throws JSONException {
            return super.getBoolean(name);
        }

        @NonNull
        @Override
        public JSONObject getJSONObject(@NonNull String name) throws JSONException {
            return super.getJSONObject(name);
        }

        @Override
        public JSONWrapper getJSONWrapper(@NonNull String name) throws JSONException {
            return new Base(name);
        }

        @NonNull
        @Override
        public JSONArray getJSONArray(@NonNull String name) throws JSONException {
            return super.getJSONArray(name);
        }
    }

    class Base extends Abstract {
        public Base(@NonNull String json) throws JSONException {
            super(json);
        }
    }

    class Fake extends Abstract {
        @NonNull
        @Override
        public String getString(@NonNull String key) throws JSONException {
            if(key.equals("name")) {
                return "John";
            }
            if(key.equals("city")) {
                return "New York";
            }
            throw new TestJSONException();
        }

        @Override
        public int getInt(@NonNull String key) throws JSONException {
            if(key.equals("age")) {
                return 30;
            }
            throw new TestJSONException();
        }
    }
}
