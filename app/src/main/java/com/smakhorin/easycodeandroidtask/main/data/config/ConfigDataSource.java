package com.smakhorin.easycodeandroidtask.main.data.config;

import androidx.annotation.RawRes;

import com.smakhorin.easycodeandroidtask.core.data.HandleError;
import com.smakhorin.easycodeandroidtask.core.data.TestException;
import com.smakhorin.easycodeandroidtask.main.data.DataSource;

public interface ConfigDataSource {
    Config latestData(@RawRes int fileRawId) throws Exception;

    class Base extends DataSource.Abstract implements ConfigDataSource {
        private final ConfigService configService;

        public Base(HandleError handleError, ConfigService configService) {
            super(handleError);
            this.configService = configService;
        }

        @Override
        public Config latestData(@RawRes int fileRawId) throws Exception {
            return handle(() -> configService.data(fileRawId));
        }
    }

    final class Fake extends DataSource.Abstract implements ConfigDataSource {

        Fake(HandleError handleError) {
            super(handleError);
        }

        @Override
        public Config latestData(int fileRawId) throws Exception {
            if (fileRawId == 0) {
                return new Config.Base(true,true,"any");
            }
            throw new TestException();
        }
    }
}
