package com.smakhorin.easycodeandroidtask.main.data;

import com.smakhorin.easycodeandroidtask.core.Matches;

import java.util.Date;

public interface TimeInterval extends Matches<TimeInterval> {
    Date getStartTime();
    Date getEndTime();

    class Base implements TimeInterval {
        private final Date startTime;
        private final Date endTime;

        public Base(Date startTime, Date endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        @Override
        public Date getStartTime() {
            return startTime;
        }

        @Override
        public Date getEndTime() {
            return endTime;
        }

        @Override
        public Boolean matches(TimeInterval otherTimeInterval) {
            return this.getStartTime().before(otherTimeInterval.getStartTime()) && this.getEndTime().after(otherTimeInterval.getEndTime());
        }
    }
}
