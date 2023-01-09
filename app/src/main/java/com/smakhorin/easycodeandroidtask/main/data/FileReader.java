package com.smakhorin.easycodeandroidtask.main.data;

import androidx.annotation.RawRes;

import com.smakhorin.easycodeandroidtask.core.ResourceManager;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

public interface FileReader {
    JSONObject readRawFile(@RawRes int fileRawId) throws IOException, JSONException;

    class Json implements FileReader {
        private final ResourceManager resourceManager;

        public Json(ResourceManager resourceManager) {
            this.resourceManager = resourceManager;
        }

        @Override
        public JSONObject readRawFile(@RawRes int fileRawId) throws IOException, JSONException {
            InputStream inputStream = resourceManager.rawFile(fileRawId);
            StringBuilder sb = new StringBuilder();
            int i;
            while ((i = inputStream.read()) != -1) {
                sb.append((char) i);
            }
            inputStream.close();
            return new JSONObject("{" + sb + "}");
        }
    }
}
