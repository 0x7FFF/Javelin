package com.smakhorin.easycodeandroidtask;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;

import com.smakhorin.easycodeandroidtask.core.CanGoBack;
import com.smakhorin.easycodeandroidtask.core.presentation.BackPress;
import com.smakhorin.easycodeandroidtask.core.NavigationScreen;
import com.smakhorin.easycodeandroidtask.core.Visibility;
import com.smakhorin.easycodeandroidtask.core.communication.GlobalErrorCommunication;
import com.smakhorin.easycodeandroidtask.core.communication.NavigationCommunication;
import com.smakhorin.easycodeandroidtask.core.communication.ProgressCommunication;
import com.smakhorin.easycodeandroidtask.main.presentation.MainNavigationScreen;

public class StartActivityViewModel extends BackPress.Activity.ViewModel<String> {
    private final NavigationCommunication.Mutable navigationCommunication;
    private final ProgressCommunication.Mutable progressCommunication;

    public StartActivityViewModel(CanGoBack canGoBack,
                                  @NonNull NavigationCommunication.Mutable navigationCommunication,
                                  @NonNull ProgressCommunication.Mutable progressCommunication,
                                  @NonNull GlobalErrorCommunication.Mutable communication) {
        super(canGoBack, communication);
        this.navigationCommunication = navigationCommunication;
        navigationCommunication.map(
                new MainNavigationScreen()
        );
        this.progressCommunication = progressCommunication;
    }

    void observeNavigation(LifecycleOwner owner, Observer<NavigationScreen> observer) {
        navigationCommunication.observe(owner, observer);
    }

    void observeProgress(LifecycleOwner owner, Observer<Visibility> observer) {
        progressCommunication.observe(owner, observer);
    }

}
