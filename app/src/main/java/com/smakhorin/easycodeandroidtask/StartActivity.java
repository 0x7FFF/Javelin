package com.smakhorin.easycodeandroidtask;

import androidx.lifecycle.ViewModelStoreOwner;

import android.os.Bundle;
import android.widget.ProgressBar;

import com.smakhorin.easycodeandroidtask.core.presentation.BackPress;
import com.smakhorin.easycodeandroidtask.core.presentation.BaseFragmentFactory;
import com.smakhorin.easycodeandroidtask.core.FragmentFactory;

public class StartActivity extends BackPress.Activity<StartActivityViewModel> implements ProvideViewModel {

    private final String TAG = "MainActivity";

    private FragmentFactory fragmentFactory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentFactory = new BaseFragmentFactory(R.id.container, getSupportFragmentManager());

        viewModel = provideViewModel(StartActivityViewModel.class, this);

        viewModel.observeNavigation(this, navigationScreen -> fragmentFactory.fragment(navigationScreen));

        ProgressBar progressBar = findViewById(R.id.progressLayout);

        viewModel.observeProgress(this, visibility -> visibility.apply(progressBar));
    }

    @Override
    public <T extends androidx.lifecycle.ViewModel> T provideViewModel(Class<T> clazz, ViewModelStoreOwner owner) {
        return ((ProvideViewModel) getApplication()).provideViewModel(clazz, owner);
    }
}
