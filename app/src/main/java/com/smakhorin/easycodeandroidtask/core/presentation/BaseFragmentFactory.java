package com.smakhorin.easycodeandroidtask.core.presentation;

import androidx.fragment.app.FragmentManager;

import com.smakhorin.easycodeandroidtask.core.FragmentFactory;
import com.smakhorin.easycodeandroidtask.core.NavigationScreen;
import com.smakhorin.easycodeandroidtask.main.presentation.MainNavigationScreen;
import com.smakhorin.easycodeandroidtask.presentation.WebScreen;

import java.util.ArrayList;
import java.util.List;

public class BaseFragmentFactory extends FragmentFactory.Abstract {
    public BaseFragmentFactory(Integer containerId, FragmentManager fragmentManager) {
        super(containerId, fragmentManager);
    }

    @Override
    protected List<NavigationScreen> getScreens() {
        List<NavigationScreen> list = new ArrayList<>();
        list.add(new MainNavigationScreen());
        list.add(new WebScreen());
        return list;
    }
}
