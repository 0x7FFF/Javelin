package com.smakhorin.easycodeandroidtask.main.data;

import static org.junit.Assert.*;

import org.junit.Test;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

public class DateGeneratorTest {
    private static final String INPUT_SUNDAY = "S 12:00";
    private static final String INPUT_MONDAY = "M 10:00";
    private static final String INPUT_FRIDAY = "F 18:00";

    @Test
    public void testGenerateFromInputString_sunday() throws ParseException {
        DateGenerator dateGenerator = new DateGenerator.Base();
        Date result = dateGenerator.generateFromInputString(INPUT_SUNDAY);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(result);

        assertEquals(Calendar.SUNDAY, calendar.get(Calendar.DAY_OF_WEEK));
        assertEquals(12, calendar.get(Calendar.HOUR_OF_DAY));
        assertEquals(0, calendar.get(Calendar.MINUTE));
    }

    @Test
    public void testGenerateFromInputString_monday() throws ParseException {
        DateGenerator dateGenerator = new DateGenerator.Base();
        Date result = dateGenerator.generateFromInputString(INPUT_MONDAY);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(result);

        assertEquals(Calendar.MONDAY, calendar.get(Calendar.DAY_OF_WEEK));
        assertEquals(10, calendar.get(Calendar.HOUR_OF_DAY));
        assertEquals(0, calendar.get(Calendar.MINUTE));
    }

    @Test
    public void testGenerateFromInputString_friday() throws ParseException {
        DateGenerator dateGenerator = new DateGenerator.Base();
        Date result = dateGenerator.generateFromInputString(INPUT_FRIDAY);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(result);

        assertEquals(Calendar.FRIDAY, calendar.get(Calendar.DAY_OF_WEEK));
        assertEquals(18, calendar.get(Calendar.HOUR_OF_DAY));
        assertEquals(0, calendar.get(Calendar.MINUTE));
    }
}
