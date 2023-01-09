package com.smakhorin.easycodeandroidtask.core.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.smakhorin.easycodeandroidtask.core.ui.AbstractFrameLayout;

public class BaseFrameLayout extends AbstractFrameLayout {
    public BaseFrameLayout(@NonNull Context context) {
        super(context);
    }

    public BaseFrameLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public BaseFrameLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public BaseFrameLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public void handleClick(OnClickListener listener) {
        setOnClickListener(listener);
    }

    @Override
    public void changeIsVisible(Boolean isVisible) {
        if (isVisible) {
            setVisibility(View.VISIBLE);
        } else {
            setVisibility(View.GONE);
        }
    }
}
