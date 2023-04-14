package com.smakhorin.easycodeandroidtask;

import androidx.annotation.IdRes;
import androidx.fragment.app.FragmentManager;

public interface ShowScreenWithParams {
    void show(@IdRes Integer containerId, FragmentManager fragmentManager, Object... params);
}
