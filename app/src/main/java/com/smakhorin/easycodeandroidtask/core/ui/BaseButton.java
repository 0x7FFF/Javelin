package com.smakhorin.easycodeandroidtask.core.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.smakhorin.easycodeandroidtask.core.ui.AbstractButton;

public class BaseButton extends AbstractButton {

    public BaseButton(@NonNull Context context) {
        super(context);
    }

    public BaseButton(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public BaseButton(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
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
