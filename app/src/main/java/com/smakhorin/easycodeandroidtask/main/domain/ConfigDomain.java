package com.smakhorin.easycodeandroidtask.main.domain;


import com.smakhorin.easycodeandroidtask.core.ui.ItemUi;
import com.smakhorin.easycodeandroidtask.core.ui.MainUi;
import com.smakhorin.easycodeandroidtask.main.data.config.ConfigDataSource;
import com.smakhorin.easycodeandroidtask.main.data.TimeIntervalNow;
import com.smakhorin.easycodeandroidtask.main.presentation.adapter.ButtonsUi;
import com.smakhorin.easycodeandroidtask.main.presentation.adapter.WorkingHoursUi;

import java.util.ArrayList;

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
    }

    interface Mapper<T> {
        T map(Boolean isChatEnabled, Boolean isCallEnabled, String workHours);

        class Base implements Mapper<MainUi> {

            private final ConfigDataSource configDataSource;
            private final ConfigTimeIntervalParser configTimeIntervalParser;

            private final TimeIntervalNow timeIntervalNow;

            public Base(ConfigDataSource configDataSource, ConfigTimeIntervalParser configTimeIntervalParser, TimeIntervalNow timeIntervalNow) {
                this.configDataSource = configDataSource;
                this.configTimeIntervalParser = configTimeIntervalParser;
                this.timeIntervalNow = timeIntervalNow;
            }

            @Override
            public MainUi map(Boolean isChatEnabled, Boolean isCallEnabled, String workHours) {
                ArrayList<ItemUi> list = new ArrayList<>();
                list.add(new ButtonsUi(isCallEnabled, isChatEnabled));
                list.add(new WorkingHoursUi(configTimeIntervalParser.parse(workHours).matches(timeIntervalNow.now())));
                return new MainUi.Base(list);
            }
        }
    }
}
