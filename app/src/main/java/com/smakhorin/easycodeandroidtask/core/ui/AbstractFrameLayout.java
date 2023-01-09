package com.smakhorin.easycodeandroidtask.core.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

abstract public class AbstractFrameLayout extends FrameLayout implements BaseView {
    public AbstractFrameLayout(@NonNull Context context) {
        super(context);
    }

    public AbstractFrameLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public AbstractFrameLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public AbstractFrameLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public void show(CharSequence text) {
        /* No - op */
    }

    @Override
    public void show(Integer textId) {
        /* No - op */
    }

    @Override
    public void loadImage(String url) {
        /* No - op */
    }

    @Override
    public void showImageResource(Integer id) {
        /* No - op */
    }

    @Override
    public void enable(Boolean isEnabled) {
        /* No - op */
    }

    @Override
    public void check(Boolean isChecked) {
        /* No - op */
    }

    @Override
    public void show(Bitmap image) {
        /* No - op */
    }
}
