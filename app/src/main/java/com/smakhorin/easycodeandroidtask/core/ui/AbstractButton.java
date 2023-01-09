package com.smakhorin.easycodeandroidtask.core.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;

abstract public class AbstractButton extends AppCompatButton implements BaseView {

    public AbstractButton(@NonNull Context context) {
        super(context);
    }

    public AbstractButton(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public AbstractButton(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
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
