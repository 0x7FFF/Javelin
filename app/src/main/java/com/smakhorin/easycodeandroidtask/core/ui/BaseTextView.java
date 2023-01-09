package com.smakhorin.easycodeandroidtask.core.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class BaseTextView extends AbstractTextView {
    public BaseTextView(@NonNull Context context) {
        super(context);
    }

    public BaseTextView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public BaseTextView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void show(CharSequence text) {
        setText(text);
    }

    @Override
    public void show(Integer textId) {
        setTag(textId);
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
