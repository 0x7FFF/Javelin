package com.smakhorin.easycodeandroidtask.main.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public interface PetsDateParser {
    Date convert(String input);

    class Base implements PetsDateParser {
        private static final String INPUT_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";

        @Override
        public Date convert(String input) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(INPUT_FORMAT);
            try {
                return simpleDateFormat.parse(input);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
