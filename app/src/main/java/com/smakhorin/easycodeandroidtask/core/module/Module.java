package com.smakhorin.easycodeandroidtask.core.module;

import androidx.lifecycle.ViewModel;

public interface Module<T extends ViewModel> {
    T viewModel();
}
