package com.smakhorin.easycodeandroidtask.main.data.config;

import androidx.annotation.RawRes;

import com.smakhorin.easycodeandroidtask.R;
import com.smakhorin.easycodeandroidtask.main.domain.ConfigDomain;

public interface ConfigRepository {
    ConfigDomain config() throws Exception;

    class Base implements ConfigRepository {

        @RawRes
        private final int configRawResId = R.raw.config;

        private final ConfigDataSource configDataSource;
        private final Config.Mapper<ConfigDomain> mapper;


        public Base(ConfigDataSource configDataSource, Config.Mapper<ConfigDomain> mapper) {
            this.configDataSource = configDataSource;
            this.mapper = mapper;
        }

        @Override
        public synchronized ConfigDomain config() throws Exception {
            return configDataSource.latestData(configRawResId).map(mapper);
        }
    }
}
