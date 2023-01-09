package com.smakhorin.easycodeandroidtask;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;

public interface ProvideViewModel {

    <T extends ViewModel> T provideViewModel(Class<T> clazz, ViewModelStoreOwner owner);
}
