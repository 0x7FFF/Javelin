package com.smakhorin.easycodeandroidtask.core;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;

import com.smakhorin.easycodeandroidtask.core.presentation.BaseFragment;

abstract public class ShowStrategy {
    abstract void show(String id, Class<? extends BaseFragment<?>> clazz, Integer containerId, FragmentManager fragmentManager) throws InstantiationException, IllegalAccessException;

    public final static class ADD extends ShowStrategy {

        @NonNull
        public static final ADD INSTANCE;

        static {
            INSTANCE = new ADD();
        }

        @Override
        void show(String id,
                  Class<? extends BaseFragment<?>> clazz,
                  Integer containerId, FragmentManager fragmentManager) throws InstantiationException, IllegalAccessException {
            fragmentManager
                    .beginTransaction()
                    .add(containerId, clazz.newInstance())
                    .addToBackStack(id)
                    .commit();
        }

    }

    public static final class REPLACE extends ShowStrategy {

        @NonNull
        public static final REPLACE INSTANCE;

        static {
            INSTANCE = new REPLACE();
        }

        @Override
        void show(String id, Class<? extends BaseFragment<?>> clazz, Integer containerId, FragmentManager fragmentManager) throws InstantiationException, IllegalAccessException {
            try {
                fragmentManager
                        .beginTransaction()
                        .replace(containerId, clazz.newInstance())
                        .commit();
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public static final class POPUP extends ShowStrategy {

        @NonNull
        public static final POPUP INSTANCE;

        static {
            INSTANCE = new POPUP();
        }


        @Override
        void show(String id, Class<? extends BaseFragment<?>> clazz, Integer containerId, FragmentManager fragmentManager) throws InstantiationException, IllegalAccessException {
            fragmentManager.popBackStack();
        }
    }

}
