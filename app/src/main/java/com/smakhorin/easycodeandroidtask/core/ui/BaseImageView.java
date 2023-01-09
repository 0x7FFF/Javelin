package com.smakhorin.easycodeandroidtask.core.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class BaseImageView extends AbstractImageView {
    public BaseImageView(@NonNull Context context) {
        super(context);
    }

    public BaseImageView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public BaseImageView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void show(Bitmap image) {
        setImageBitmap(image);
    }
}
