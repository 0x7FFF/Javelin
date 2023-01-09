package com.smakhorin.easycodeandroidtask.main.data.config;

import com.smakhorin.easycodeandroidtask.main.domain.ConfigDomain;

import java.io.Serializable;

public interface Config {

    <T> T map(Mapper<T> mapper);

    class Empty implements Config {

        @Override
        public <T> T map(Mapper<T> mapper) {
            return mapper.map(null,null,null);
        }
    }

    class Base implements Serializable, Config {
        private final Boolean isChatEnabled;
        private final Boolean isCallEnabled;
        private final String workHours;

        public Base(Boolean isChatEnabled, Boolean isCallEnabled, String workHours) {
            this.isChatEnabled = isChatEnabled;
            this.isCallEnabled = isCallEnabled;
            this.workHours = workHours;
        }

        @Override
        public <T> T map(Mapper<T> mapper) {
            return mapper.map(isChatEnabled,isCallEnabled,workHours);
        }
    }

    interface Mapper<T> {
        T map(Boolean isChatEnabled, Boolean isCallEnabled, String workHours);

        class Base implements Mapper<ConfigDomain> {

            @Override
            public ConfigDomain map(Boolean isChatEnabled, Boolean isCallEnabled, String workHours) {
                return new ConfigDomain.Base(isChatEnabled, isCallEnabled, workHours);
            }
        }
    }
}
