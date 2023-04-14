package com.smakhorin.easycodeandroidtask.webscreen;


import android.os.Bundle;

import com.smakhorin.easycodeandroidtask.core.NavigationScreen;
import com.smakhorin.easycodeandroidtask.core.ShowStrategy;

public class WebScreen extends NavigationScreen {
    public WebScreen(Bundle args) {
        super(
            "WebNavigationScreen",
            WebFragment.class,
            ShowStrategy.ADD.INSTANCE,
            args
        );
    }

    public WebScreen() {
        super(
            "WebNavigationScreen",
            WebFragment.class,
            ShowStrategy.ADD.INSTANCE,
            null
        );
    }

    static public class Args {
        public String ARG_CONTENT_URL = "ARG_CONTENT_URL";
    }
}
