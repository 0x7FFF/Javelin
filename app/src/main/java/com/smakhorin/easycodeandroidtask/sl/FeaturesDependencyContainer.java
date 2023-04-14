package com.smakhorin.easycodeandroidtask.sl;

import androidx.lifecycle.ViewModel;

import com.smakhorin.easycodeandroidtask.core.data.HandleError;
import com.smakhorin.easycodeandroidtask.core.domain.HandleDomainError;
import com.smakhorin.easycodeandroidtask.core.module.DependencyContainer;
import com.smakhorin.easycodeandroidtask.core.module.Module;
import com.smakhorin.easycodeandroidtask.main.data.config.ConfigDataSource;
import com.smakhorin.easycodeandroidtask.main.data.config.ConfigService;
import com.smakhorin.easycodeandroidtask.main.data.pets.PetsDataSource;
import com.smakhorin.easycodeandroidtask.main.data.pets.PetsService;
import com.smakhorin.easycodeandroidtask.main.presentation.MainFragmentViewModel;
import com.smakhorin.easycodeandroidtask.webscreen.WebFragmentViewModel;

public class FeaturesDependencyContainer implements DependencyContainer {

    private final CoreModule coreModule;
    private final DependencyContainer dependencyContainer;

    private final ConfigDataSource configDataSource;

    private final PetsDataSource petsDataSource;

    public FeaturesDependencyContainer(CoreModule coreModule, DependencyContainer dependencyContainer) {
        HandleError handleDomainError = new HandleDomainError();

        this.coreModule = coreModule;
        this.dependencyContainer = dependencyContainer;
        this.configDataSource = new ConfigDataSource.Base(
                handleDomainError,
                new ConfigService.Base(coreModule.provideJsonReader())
        );
        this.petsDataSource = new PetsDataSource.Base(
                handleDomainError,
                new PetsService.Base(coreModule.provideJsonReader())
        );
    }

    @Override
    public <T extends ViewModel> Module<?> module(Class<T> clazz) {
        if (clazz == MainFragmentViewModel.class) {
            return new MainModule(coreModule, configDataSource, petsDataSource);
        }
        if (clazz == WebFragmentViewModel.class) {
            return new WebModule(coreModule);
        }

        return dependencyContainer.module(clazz);
    }
}
