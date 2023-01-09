package com.smakhorin.easycodeandroidtask.main.data.config;

import androidx.annotation.RawRes;

import com.smakhorin.easycodeandroidtask.core.data.HandleError;
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
}
