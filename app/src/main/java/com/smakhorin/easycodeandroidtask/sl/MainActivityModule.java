package com.smakhorin.easycodeandroidtask.sl;

import com.smakhorin.easycodeandroidtask.MainActivityViewModel;
import com.smakhorin.easycodeandroidtask.core.communication.NavigationCommunication;
import com.smakhorin.easycodeandroidtask.core.module.Module;

public class MainActivityModule implements Module<MainActivityViewModel> {
    private final CoreModule coreModule;

    public MainActivityModule(CoreModule coreModule) {
        this.coreModule = coreModule;
    }

    @Override
    public MainActivityViewModel viewModel() {
        return new MainActivityViewModel(
            coreModule.provideCanGoBack(),
            coreModule.provideNavigationCommunication(),
            coreModule.provideProgressCommunication(),
            coreModule.provideGlobalErrorCommunication()
        );
    }
}
