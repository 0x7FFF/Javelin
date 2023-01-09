package com.smakhorin.easycodeandroidtask.main.data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public interface DateGenerator {
    Date generateFromInputString(String input) throws ParseException;

    class Base implements DateGenerator {

        @Override
        public Date generateFromInputString(String input) throws ParseException {
            // Determine the day of the week based on the input string
            int dayOfWeek = Calendar.SUNDAY; // Sunday
            if (input.startsWith("M")) {
                dayOfWeek = Calendar.MONDAY; // Monday
            } else if (input.startsWith("F")) {
                dayOfWeek = Calendar.FRIDAY; // Friday
            }

            // Parse the time from the input string
            String timeString = input.substring(2).trim();
            SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
            Date time = timeFormat.parse(timeString);

            // Calculate the current date and time
            Calendar calendar = Calendar.getInstance();
            int currentDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
            long currentTime = calendar.getTimeInMillis() % (24 * 60 * 60 * 1000);

            // Calculate the date and time for the input string
            long inputTime = (time == null) ? 0 : time.getTime();
            long inputDate = calendar.getTimeInMillis() - currentTime - (long) (currentDayOfWeek - dayOfWeek) * 24 * 60 * 60 * 1000;

            // Create a Date object for the input string
            return new Date(inputDate + inputTime);
        }
    }
}
