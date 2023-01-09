package com.smakhorin.easycodeandroidtask.core;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;

import com.smakhorin.easycodeandroidtask.ShowScreen;
import com.smakhorin.easycodeandroidtask.core.presentation.BaseFragment;

abstract public class NavigationScreen implements ShowScreen, Matches<NavigationScreen> {
    private final String id;
    private final Class<? extends BaseFragment<?>> clazz;
    private final ShowStrategy strategy;

    public NavigationScreen(@NonNull String id, @NonNull Class<? extends BaseFragment<?>> clazz, @NonNull ShowStrategy strategy) {
        this.id = id;
        this.clazz = clazz;
        this.strategy = strategy;
    }

    @NonNull
    @Override
    public String toString() {
        return "id" + id;
    }

    @Override
    public void show(Integer containerId, FragmentManager fragmentManager) {
        try {
            strategy.show(id, clazz, containerId, fragmentManager);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Boolean matches(NavigationScreen data) {
        return this.id.equals(data.id);
    }
}
