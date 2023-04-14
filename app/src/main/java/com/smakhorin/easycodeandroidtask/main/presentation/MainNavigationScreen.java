package com.smakhorin.easycodeandroidtask.main.presentation;

import com.smakhorin.easycodeandroidtask.core.NavigationScreen;
import com.smakhorin.easycodeandroidtask.core.ShowStrategy;
import com.smakhorin.easycodeandroidtask.main.presentation.MainFragment;

public class MainNavigationScreen extends NavigationScreen {
    public MainNavigationScreen() {
        super(
            "MainScreen",
            MainFragment.class,
            ShowStrategy.REPLACE.INSTANCE,
            null
        );
    }
}
