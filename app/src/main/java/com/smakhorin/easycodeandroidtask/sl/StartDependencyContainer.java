package com.smakhorin.easycodeandroidtask.sl;

import androidx.lifecycle.ViewModel;

import com.smakhorin.easycodeandroidtask.StartActivityViewModel;
import com.smakhorin.easycodeandroidtask.core.module.DependencyContainer;
import com.smakhorin.easycodeandroidtask.core.module.Module;

public class StartDependencyContainer implements DependencyContainer {
    private final DependencyContainer dependencyContainer;
    private final CoreModule coreModule;

    public StartDependencyContainer(DependencyContainer dependencyContainer,
                                    CoreModule coreModule) {
        this.dependencyContainer = dependencyContainer;
        this.coreModule = coreModule;
    }

    @Override
    public <T extends ViewModel> Module<?> module(Class<T> clazz) {
        if (clazz == StartActivityViewModel.class) {
            return new StartModule(coreModule);
        } else {
            return dependencyContainer.module(clazz);
        }
    }
}
