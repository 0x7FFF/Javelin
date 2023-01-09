package com.smakhorin.easycodeandroidtask.sl;

import com.smakhorin.easycodeandroidtask.StartActivityViewModel;
import com.smakhorin.easycodeandroidtask.core.communication.NavigationCommunication;
import com.smakhorin.easycodeandroidtask.core.module.Module;

public class StartModule implements Module<StartActivityViewModel> {
    private final CoreModule coreModule;

    public StartModule(CoreModule coreModule) {
        this.coreModule = coreModule;
    }

    @Override
    public StartActivityViewModel viewModel() {
        return new StartActivityViewModel(
                coreModule.provideCanGoBack(),
                new NavigationCommunication.Base(),
                coreModule.provideProgressCommunication(),
                coreModule.provideGlobalErrorCommunication()
        );
    }
}
