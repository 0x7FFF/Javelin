package com.smakhorin.easycodeandroidtask.main.data.config;

import static org.junit.Assert.assertEquals;

import com.smakhorin.easycodeandroidtask.main.domain.ConfigDomain;

import org.junit.Test;

public class ConfigMapperTest {

    @Test
    public void testMapper() {
        ConfigDomain expected = new ConfigDomain.Base(true, false, "9am-5pm");

        Config.Mapper<ConfigDomain> mapper = new Config.Mapper.Base();
        Boolean isChatEnabled = true;
        Boolean isCallEnabled = false;
        String workHours = "9am-5pm";
        ConfigDomain config = mapper.map(isChatEnabled, isCallEnabled, workHours);

        assertEquals(expected, config);
    }

}
