package com.smakhorin.easycodeandroidtask.main.data.config;

import static org.junit.Assert.*;

import com.smakhorin.easycodeandroidtask.core.data.TestIOException;
import com.smakhorin.easycodeandroidtask.core.data.TestJSONException;

import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class ConfigServiceTest {

    private static final int FILE_RAW_ID = 0;
    private static final int IO_EXCEPTION_RAW_ID = 1;
    private static final int JSON_EXCEPTION_RAW_ID = 2;

    private ConfigService configService;

    @Before
    public void setUp() {
        configService = new ConfigService.Fake();
    }

    @Test
    public void testData() throws IOException, JSONException {
        Config expected = new Config.Base(true,false,"9:00-17:00");
        Config config = configService.data(FILE_RAW_ID);
        assertEquals(expected, config);
    }

    @Test(expected = TestIOException.class)
    public void testData_IOException() throws JSONException, IOException {
        Config config = configService.data(IO_EXCEPTION_RAW_ID);
        assertNull(config);
    }

    @Test(expected = TestJSONException.class)
    public void testData_JSONException() throws JSONException, IOException {
        Config config = configService.data(JSON_EXCEPTION_RAW_ID);
        assertNull(config);
    }
}
