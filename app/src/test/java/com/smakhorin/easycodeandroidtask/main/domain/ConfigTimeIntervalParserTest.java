package com.smakhorin.easycodeandroidtask.main.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.smakhorin.easycodeandroidtask.main.data.DateGenerator;
import com.smakhorin.easycodeandroidtask.main.data.StringConcatenator;
import com.smakhorin.easycodeandroidtask.main.data.StringSplitter;
import com.smakhorin.easycodeandroidtask.main.data.TimeInterval;

import org.junit.Before;
import org.junit.Test;

public class ConfigTimeIntervalParserTest {
    private ConfigTimeIntervalParser parser;

    @Before
    public void setUp() {
        StringSplitter stringSplitter = new StringSplitter.Base();
        StringConcatenator stringConcatenator = new StringConcatenator.Base();
        DateGenerator dateGenerator = new DateGenerator.Base();

        parser = new ConfigTimeIntervalParser.Base(stringSplitter, stringConcatenator, dateGenerator);
    }

    @Test
    public void testParse() {
        TimeInterval interval = parser.parse("M-F 9:00 - 18:00");
        assertEquals("Mon Jan 16 09:00:00 MSK 2023", interval.getStartTime().toString());
        assertEquals("Fri Jan 20 18:00:00 MSK 2023", interval.getEndTime().toString());
    }

    @Test(expected = NullPointerException.class)
    public void testParse_NPE() {
        TimeInterval interval = parser.parse(null);
        assertNull(interval);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testParse_EmptyString() {
        TimeInterval interval = parser.parse("");
        assertNull(interval);
    }
}
