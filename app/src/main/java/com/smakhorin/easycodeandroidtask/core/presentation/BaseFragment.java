package com.smakhorin.easycodeandroidtask.core.presentation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;

import com.smakhorin.easycodeandroidtask.ProvideViewModel;

public abstract class BaseFragment<T extends ViewModel> extends Fragment {
    protected T viewModel;

    protected abstract Class<T> viewModelClass();

    protected abstract Integer getLayoutResId();

    protected BaseFragment() {
        super();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = ((ProvideViewModel) requireActivity()).provideViewModel(viewModelClass(), this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return getLayoutInflater().inflate(getLayoutResId(), container, false);
    }
}
