package com.smakhorin.easycodeandroidtask.main.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public interface PetsDateParser {
    Date convert(String input);

    class Base implements PetsDateParser {

        private final SimpleDateFormat simpleDateFormat;

        public Base() {
            this(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"));
        }

        public Base(String inputFormat) {
            this(new SimpleDateFormat(inputFormat));
        }

        public Base(SimpleDateFormat simpleDateFormat) {
            this.simpleDateFormat = simpleDateFormat;
        }

        @Override
        public Date convert(String input) {
            try {
                return simpleDateFormat.parse(input);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
