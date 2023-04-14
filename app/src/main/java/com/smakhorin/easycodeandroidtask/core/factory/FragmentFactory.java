package com.smakhorin.easycodeandroidtask.core.factory;

import androidx.fragment.app.FragmentManager;

import com.smakhorin.easycodeandroidtask.core.NavigationScreen;

import java.util.List;

public interface FragmentFactory {
    void fragment(NavigationScreen navigationScreen);

    class Error implements FragmentFactory {
        @Override
        public void fragment(NavigationScreen navigationScreen) {
            throw new IllegalStateException("no matches found for screen:" + navigationScreen);
        }
    }

    abstract class Abstract implements FragmentFactory {
        private final Integer containerId;
        private final FragmentManager fragmentManager;
        private final FragmentFactory fragmentFactory = new Error();

        public Abstract(Integer containerId, FragmentManager fragmentManager) {
            this.containerId = containerId;
            this.fragmentManager = fragmentManager;
        }

        protected abstract List<NavigationScreen> getScreens();

        @Override
        public void fragment(NavigationScreen navigationScreen) {
            NavigationScreen found = null;
            for (NavigationScreen curNavScreen : getScreens()) {
                if (curNavScreen.matches(navigationScreen)) {
                    found = curNavScreen;
                    break;
                }
            }
            if (found == null) {
                fragmentFactory.fragment(navigationScreen);
            } else {
                navigationScreen.show(containerId, fragmentManager);
            }
        }
    }
}
