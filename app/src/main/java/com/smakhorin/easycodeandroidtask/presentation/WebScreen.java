package com.smakhorin.easycodeandroidtask.presentation;

import androidx.annotation.NonNull;

import com.smakhorin.easycodeandroidtask.core.NavigationScreen;
import com.smakhorin.easycodeandroidtask.core.ShowStrategy;
import com.smakhorin.easycodeandroidtask.main.presentation.MainFragment;

public class WebScreen extends NavigationScreen {
    public WebScreen() {
        super(
                "WebNavigationScreen",
                MainFragment.class,
                ShowStrategy.ADD.INSTANCE
        );
    }
}
