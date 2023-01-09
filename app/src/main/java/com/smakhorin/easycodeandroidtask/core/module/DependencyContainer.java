package com.smakhorin.easycodeandroidtask.core.module;

import androidx.lifecycle.ViewModel;

public interface DependencyContainer {
    <T extends ViewModel> Module<?> module(Class<T> clazz);

    class Error implements DependencyContainer {

        @Override
        public <T extends ViewModel> Module<?> module(Class<T> clazz) {
            throw new IllegalStateException("no module found for " + clazz.toString());
        }
    }
}
