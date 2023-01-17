package com.smakhorin.easycodeandroidtask.main.data;

import androidx.annotation.RawRes;

import com.smakhorin.easycodeandroidtask.core.ResourceManager;
import com.smakhorin.easycodeandroidtask.core.data.TestException;
import com.smakhorin.easycodeandroidtask.core.data.TestIOException;
import com.smakhorin.easycodeandroidtask.core.data.TestJSONException;
import com.smakhorin.easycodeandroidtask.core.domain.JSONWrapper;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

public interface FileReader {
    JSONWrapper readRawFile(@RawRes int fileRawId) throws IOException, JSONException;

    class Json implements FileReader {
        private final ResourceManager resourceManager;

        public Json(ResourceManager resourceManager) {
            this.resourceManager = resourceManager;
        }

        @Override
        public JSONWrapper readRawFile(@RawRes int fileRawId) throws IOException, JSONException {
            InputStream inputStream = resourceManager.rawFile(fileRawId);
            StringBuilder sb = new StringBuilder();
            int i;
            while ((i = inputStream.read()) != -1) {
                sb.append((char) i);
            }
            inputStream.close();
            return new JSONWrapper.Base("{" + sb + "}");
        }
    }

    class Fake implements FileReader {

        public Fake() {}

        @Override
        public JSONWrapper readRawFile(int fileRawId) throws IOException, JSONException {
            if (fileRawId == 0) {
                return new JSONWrapper.Fake();
            }
            if (fileRawId == 1) {
                throw new TestIOException();
            }
            throw new TestJSONException();
        }
    }
}
