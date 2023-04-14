package com.smakhorin.easycodeandroidtask.sl;

import androidx.lifecycle.ViewModel;

import com.smakhorin.easycodeandroidtask.MainActivityViewModel;
import com.smakhorin.easycodeandroidtask.core.module.DependencyContainer;
import com.smakhorin.easycodeandroidtask.core.module.Module;

public class MainActivityDependencyContainer implements DependencyContainer {
    private final DependencyContainer dependencyContainer;
    private final CoreModule coreModule;

    public MainActivityDependencyContainer(DependencyContainer dependencyContainer,
                                           CoreModule coreModule) {
        this.dependencyContainer = dependencyContainer;
        this.coreModule = coreModule;
    }

    @Override
    public <T extends ViewModel> Module<?> module(Class<T> clazz) {
        if (clazz == MainActivityViewModel.class) {
            return new MainActivityModule(coreModule);
        } else {
            return dependencyContainer.module(clazz);
        }
    }
}
