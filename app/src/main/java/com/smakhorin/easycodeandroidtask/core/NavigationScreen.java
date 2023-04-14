package com.smakhorin.easycodeandroidtask.core;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;

import com.smakhorin.easycodeandroidtask.ShowScreen;
import com.smakhorin.easycodeandroidtask.core.presentation.BaseFragment;

abstract public class NavigationScreen implements ShowScreen, Matches<NavigationScreen> {
    private final String id;
    private final Class<? extends BaseFragment<?>> clazz;
    private final ShowStrategy strategy;

    private final Bundle args;

    public NavigationScreen(@NonNull String id,
                            @NonNull Class<? extends BaseFragment<?>> clazz,
                            @NonNull ShowStrategy strategy,
                            @Nullable Bundle args) {
        this.id = id;
        this.clazz = clazz;
        this.strategy = strategy;
        this.args = args;
    }

    @NonNull
    @Override
    public String toString() {
        return "id" + id;
    }

    @Override
    public void show(Integer containerId, FragmentManager fragmentManager) {
        try {
            strategy.show(id, clazz, containerId, fragmentManager, args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Boolean matches(NavigationScreen data) {
        return this.id.equals(data.id);
    }
}
