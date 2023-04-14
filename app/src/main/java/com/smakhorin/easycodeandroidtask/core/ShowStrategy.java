package com.smakhorin.easycodeandroidtask.core;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;

import com.smakhorin.easycodeandroidtask.core.presentation.BaseFragment;

abstract public class ShowStrategy {
    abstract void show(String id,
                       Class<? extends BaseFragment<?>> clazz,
                       Integer containerId,
                       FragmentManager fragmentManager,
                       Bundle args
    ) throws InstantiationException, IllegalAccessException;

    public final static class ADD extends ShowStrategy {

        @NonNull
        public static final ADD INSTANCE;

        static {
            INSTANCE = new ADD();
        }

        @Override
        void show(String id,
                  Class<? extends BaseFragment<?>> clazz,
                  Integer containerId,
                  FragmentManager fragmentManager,
                  Bundle args
        ) throws InstantiationException, IllegalAccessException {
            BaseFragment<?> fragment = clazz.newInstance();
            if (args != null) {
                fragment.setArguments(args);
            }
            fragmentManager
                .beginTransaction()
                .add(containerId, fragment)
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
        void show(String id,
                  Class<? extends BaseFragment<?>> clazz,
                  Integer containerId,
                  FragmentManager fragmentManager,
                  Bundle args
        ) throws InstantiationException, IllegalAccessException {
            try {
                BaseFragment<?> fragment = clazz.newInstance();
                if (args != null) {
                    fragment.setArguments(args);
                }
                fragmentManager
                    .beginTransaction()
                    .replace(containerId, fragment)
                    .commit();
            } catch (Exception ex) {
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
        void show(String id,
                  Class<? extends BaseFragment<?>> clazz,
                  Integer containerId,
                  FragmentManager fragmentManager,
                  Bundle args) {
            fragmentManager.popBackStack();
        }
    }

}

