package com.smakhorin.easycodeandroidtask.main.data.config;

import androidx.annotation.RawRes;

import com.smakhorin.easycodeandroidtask.main.data.FileReader;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public interface ConfigService {
    Config.Base data(@RawRes int fileRawId) throws IOException, JSONException;


    class Base implements ConfigService {

        private final FileReader.Json jsonReader;

        public Base(FileReader.Json jsonReader) {
            this.jsonReader = jsonReader;
        }

        @Override
        public Config.Base data(@RawRes int fileRawId) throws IOException, JSONException {
            JSONObject rawData = jsonReader.readRawFile(fileRawId);
            JSONObject settings = rawData.getJSONObject("settings");
            Boolean isChatEnabled = settings.getBoolean("isChatEnabled");
            Boolean isCallEnabled = settings.getBoolean("isCallEnabled");
            String workHours = settings.getString("workHours");
            return new Config.Base(isChatEnabled, isCallEnabled, workHours);
        }
    }
}
