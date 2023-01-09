package com.smakhorin.easycodeandroidtask.core.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;

abstract public class AbstractImageView extends AppCompatImageView implements BaseView {
    public AbstractImageView(@NonNull Context context) {
        super(context);
    }

    public AbstractImageView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public AbstractImageView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
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
    public void handleClick(OnClickListener listener) {
        /* No - op */
    }

    @Override
    public void changeIsVisible(Boolean isVisible) {
        /* No - op */
    }
}
