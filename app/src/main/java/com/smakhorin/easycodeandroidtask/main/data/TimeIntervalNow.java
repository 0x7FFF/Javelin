package com.smakhorin.easycodeandroidtask.main.data;

import java.util.Date;

public interface TimeIntervalNow {
    TimeInterval now();

    class Base implements TimeIntervalNow {

        @Override
        public TimeInterval now() {
            Date nowDate = new Date();
            return new TimeInterval.Base(nowDate, nowDate);
        }
    }
}
