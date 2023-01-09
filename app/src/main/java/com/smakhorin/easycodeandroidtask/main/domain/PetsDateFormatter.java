package com.smakhorin.easycodeandroidtask.main.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

public interface PetsDateFormatter {
    String format(Date date);

    class Base implements PetsDateFormatter {
        private static final String OUTPUT_FORMAT = "HH:mm:ss dd-MM-yyyy";

        @Override
        public String format(Date date) {
            return new SimpleDateFormat(OUTPUT_FORMAT).format(date);
        }
    }
}
