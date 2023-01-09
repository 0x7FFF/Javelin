package com.smakhorin.easycodeandroidtask.core;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.smakhorin.easycodeandroidtask.core.module.DependencyContainer;

public class ViewModelsFactory implements ViewModelProvider.Factory {

    private final DependencyContainer dependencyContainer;

    public ViewModelsFactory(DependencyContainer dependencyContainer) {
        this.dependencyContainer = dependencyContainer;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T)dependencyContainer.module(modelClass).viewModel();
    }
}
