package com.smakhorin.easycodeandroidtask.main.data.config;

import androidx.annotation.Nullable;

import com.smakhorin.easycodeandroidtask.main.data.pets.Pet;
import com.smakhorin.easycodeandroidtask.main.domain.ConfigDomain;

import java.io.Serializable;
import java.util.Objects;

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

        @Override
        public int hashCode() {
            return Objects.hash(isChatEnabled, isCallEnabled, workHours);
        }

        @Override
        public boolean equals(@Nullable Object other) {
            if (other == null || getClass() != other.getClass()) return false;
            Config.Base otherClass = (Config.Base) other;
            return Objects.equals(isChatEnabled, otherClass.isChatEnabled) &&
                Objects.equals(isCallEnabled, otherClass.isCallEnabled) &&
                Objects.equals(workHours, otherClass.workHours);
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
