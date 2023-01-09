package com.smakhorin.easycodeandroidtask.core.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;

import com.smakhorin.easycodeandroidtask.core.ui.BaseView;

abstract public class AbstractTextView extends AppCompatTextView implements BaseView {
    public AbstractTextView(@NonNull Context context) {
        super(context);
    }

    public AbstractTextView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public AbstractTextView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
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
    public void show(Bitmap image) {
        /* No - op */
    }
}
