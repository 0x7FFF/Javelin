package com.smakhorin.easycodeandroidtask.main.domain;


import androidx.annotation.Nullable;

import com.smakhorin.easycodeandroidtask.core.ui.ItemUi;
import com.smakhorin.easycodeandroidtask.core.ui.MainUi;
import com.smakhorin.easycodeandroidtask.main.data.TimeIntervalNow;
import com.smakhorin.easycodeandroidtask.main.presentation.DisplayDialog;
import com.smakhorin.easycodeandroidtask.main.presentation.adapter.ButtonsUi;
import com.smakhorin.easycodeandroidtask.main.presentation.adapter.WorkingHoursUi;

import java.util.ArrayList;
import java.util.Objects;

public interface ConfigDomain {
    <T> T map(Mapper<T> mapper);

    class Base implements ConfigDomain {
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
            return mapper.map(isChatEnabled, isCallEnabled, workHours);
        }

        @Override
        public boolean equals(@Nullable Object other) {
            if (other == null || getClass() != other.getClass()) return false;
            ConfigDomain.Base otherClass = (ConfigDomain.Base) other;
            return Objects.equals(isChatEnabled, otherClass.isChatEnabled) &&
                Objects.equals(isCallEnabled, otherClass.isCallEnabled) &&
                Objects.equals(workHours, otherClass.workHours);
        }

        @Override
        public int hashCode() {
            return Objects.hash(isChatEnabled, isCallEnabled, workHours);
        }
    }

    interface Mapper<T> {
        T map(Boolean isChatEnabled, Boolean isCallEnabled, String workHours);

        class Base implements Mapper<MainUi> {

            private final ConfigTimeIntervalParser configTimeIntervalParser;

            private final TimeIntervalNow timeIntervalNow;

            private final DisplayDialog displayDialog;

            public Base(ConfigTimeIntervalParser configTimeIntervalParser, TimeIntervalNow timeIntervalNow, DisplayDialog displayDialog) {
                this.configTimeIntervalParser = configTimeIntervalParser;
                this.timeIntervalNow = timeIntervalNow;
                this.displayDialog = displayDialog;
            }

            @Override
            public MainUi map(Boolean isChatEnabled, Boolean isCallEnabled, String workHours) {
                ArrayList<ItemUi> list = new ArrayList<>();
                list.add(new ButtonsUi(isCallEnabled, isChatEnabled, displayDialog));
                list.add(new WorkingHoursUi(configTimeIntervalParser.parse(workHours).matches(timeIntervalNow.now())));
                return new MainUi.Base(list);
            }
        }
    }
}
