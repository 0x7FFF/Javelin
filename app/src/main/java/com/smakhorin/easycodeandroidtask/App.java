package com.smakhorin.easycodeandroidtask;

import android.app.Application;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;

import com.smakhorin.easycodeandroidtask.core.factory.ViewModelsFactory;
import com.smakhorin.easycodeandroidtask.core.module.DependencyContainer;
import com.smakhorin.easycodeandroidtask.sl.CoreModule;
import com.smakhorin.easycodeandroidtask.sl.FeaturesDependencyContainer;
import com.smakhorin.easycodeandroidtask.sl.MainActivityDependencyContainer;

public class App extends Application implements ProvideViewModel {
    private ViewModelsFactory viewModelsFactory;

    @Override
    public void onCreate() {
        super.onCreate();
        CoreModule coreModule = new CoreModule.Base(this);
        MainActivityDependencyContainer startDependencyContainer =
            new MainActivityDependencyContainer(
                new DependencyContainer.Error(),
                coreModule
            );
        viewModelsFactory = new ViewModelsFactory(new FeaturesDependencyContainer(coreModule, startDependencyContainer));
    }

    @Override
    public <T extends ViewModel> T provideViewModel(Class<T> clazz, ViewModelStoreOwner owner) {
        return new ViewModelProvider(owner, viewModelsFactory).get(clazz);
    }
}
