package com.smakhorin.easycodeandroidtask.main.domain;

import com.smakhorin.easycodeandroidtask.main.data.DateGenerator;
import com.smakhorin.easycodeandroidtask.main.data.StringConcatenator;
import com.smakhorin.easycodeandroidtask.main.data.StringSplitter;
import com.smakhorin.easycodeandroidtask.main.data.TimeInterval;

import java.text.ParseException;
import java.util.Date;

public interface ConfigTimeIntervalParser {
    TimeInterval parse(String input);

    class Base implements ConfigTimeIntervalParser {

        private final StringSplitter stringSplitter;

        private final StringConcatenator stringConcatenator;

        private final DateGenerator dateGenerator;

        public Base(StringSplitter stringSplitter, StringConcatenator stringConcatenator, DateGenerator dateGenerator) {
            this.stringSplitter = stringSplitter;
            this.stringConcatenator = stringConcatenator;
            this.dateGenerator = dateGenerator;
        }

        @Override
        public TimeInterval parse(String input) {
            String[] partsDirty = stringSplitter.splitAfterFirstSpace(input);
            String[] startTimeDirty = stringSplitter.splitUsingSymbol(partsDirty[0], "-");
            String[] endTimeDirty = stringSplitter.splitUsingSymbol(partsDirty[1], " - ");
            String[] partsClean = stringConcatenator.concatPairs(startTimeDirty[0], endTimeDirty[0], startTimeDirty[1], endTimeDirty[1]);
            try {
                Date startTime = dateGenerator.generateFromInputString(partsClean[0]);
                Date endTime = dateGenerator.generateFromInputString(partsClean[1]);
                return new TimeInterval.Base(startTime, endTime);
            } catch (ParseException e) {
                e.printStackTrace();
                return null;
            }
        }
    }
}
