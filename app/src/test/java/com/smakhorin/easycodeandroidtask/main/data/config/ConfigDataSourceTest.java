package com.smakhorin.easycodeandroidtask.main.data.config;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.smakhorin.easycodeandroidtask.core.data.HandleError;
import com.smakhorin.easycodeandroidtask.core.data.TestException;

import org.junit.Test;

public class ConfigDataSourceTest {

    private final HandleError handleError = new HandleError.Fake();
    private final ConfigDataSource configDataSource = new ConfigDataSource.Fake(handleError);
    private static final int FILE_RAW_ID = 0;
    private static final int INVALID_FILE_RAW_ID = 1;

    @Test
    public void testLatestData_success() throws Exception {
        Config expected = new Config.Base(true,true,"any");

        Config result = configDataSource.latestData(FILE_RAW_ID);
        assertEquals(result, expected);
    }

    @Test(expected = TestException.class)
    public void testLatestData_error() throws Exception {
        Config result = configDataSource.latestData(INVALID_FILE_RAW_ID);
        assertNull(result);
    }
}
