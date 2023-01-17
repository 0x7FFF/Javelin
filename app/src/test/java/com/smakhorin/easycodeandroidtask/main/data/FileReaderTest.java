package com.smakhorin.easycodeandroidtask.main.data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.smakhorin.easycodeandroidtask.core.data.TestIOException;
import com.smakhorin.easycodeandroidtask.core.domain.JSONWrapper;

import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class FileReaderTest {
    private FileReader fileReader;

    @Before
    public void setUp() {
        fileReader = new FileReader.Fake();
    }

    @Test
    public void testReadRawFile() throws IOException, JSONException {
        JSONWrapper jsonObject = fileReader.readRawFile(0);
        assertEquals("John", jsonObject.getString("name"));
        assertEquals(30, jsonObject.getInt("age"));
        assertEquals("New York", jsonObject.getString("city"));
    }

    @Test(expected = TestIOException.class)
    public void testReadRawFile_IOException() throws IOException, JSONException {
        JSONWrapper jsonObject = fileReader.readRawFile(1);
        assertNull(jsonObject);
    }

    @Test(expected = JSONException.class)
    public void testReadRawFile_JSONException() throws IOException, JSONException {
        JSONWrapper jsonObject = fileReader.readRawFile(2);
        assertNull(jsonObject);
    }
}
